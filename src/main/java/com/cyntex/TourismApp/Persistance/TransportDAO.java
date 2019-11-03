package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.AttaractionSummary;
import com.cyntex.TourismApp.Beans.DBBusFareBean;
import com.cyntex.TourismApp.Beans.LocationBean;
import com.cyntex.TourismApp.Util.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransportDAO {
    private String fromTownRetrieveQuery = "SELECT DISTINCT tourism_app.tourist_bus_transport.from FROM tourism_app" +
            ".tourist_bus_transport";

    private String toTownRetrieveQuery = "SELECT DISTINCT tourism_app.tourist_bus_transport.to FROM tourism_app" +
            ".tourist_bus_transport";

    private String busFareRetrieveQuery = "SELECT * FROM tourist_bus_transport where " +
            "tourist_bus_transport.from = ? and tourist_bus_transport.to = ?";

    private String locationRetrieveQuery = "SELECT * FROM location where location_id = ?";

    private String serviceDiscioveryQuery = "SELECT f.service_id as svc_id, f.service_fee as svc_fee, " +
            "s.service_title as title, s.service_description as description, l.lat as lat, l.lng as lng " +
            "from service_fee f, tourist_service s, location l " +
            "where f.service_id = s.service_id and s.location_id = l.location_id and l.lat < ? " +
            "and l.lat > ? and l.lng < ? and l.lng > ?";

    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public List<String> getFromTowns() {
        return dataSourceManager.getJdbcTemplate().query(
                fromTownRetrieveQuery,
                (rs, rowNum) -> rs.getString("from")
        );
    }

    @Transactional
    public List<String> getToTowns() {
        return dataSourceManager.getJdbcTemplate().query(
                toTownRetrieveQuery,
                (rs, rowNum) -> rs.getString("to")
        );
    }

    @Transactional
    public List<DBBusFareBean> getTransportInfoForTowns(String from, String to) {
        return dataSourceManager.getJdbcTemplate().query(
                busFareRetrieveQuery,
                new Object[]{from, to},
                new int[]{Types.VARCHAR, Types.VARCHAR},
                (rs, rowNum) -> new DBBusFareBean(
                        rs.getDouble("normal_fare"),
                        rs.getDouble("semi_luxury_fare"),
                        rs.getDouble("luxury_fare"),
                        rs.getDouble("express_way_fare")
                )
        );
    }

    @Transactional
    public List<LocationBean> getLocation(String id) {
        return dataSourceManager.getJdbcTemplate().query(
                locationRetrieveQuery,
                new Object[]{id},
                new int[]{Types.VARCHAR},
                (rs, rowNum) -> new LocationBean(
                        rs.getDouble("lng"),
                        rs.getDouble("lat")
                )
        );
    }

    @Transactional
    public List<AttaractionSummary> getAttaractions(String id) {
        List<LocationBean> locationBeans = this.getLocation(id);
        if (locationBeans.isEmpty()) {
            return new ArrayList<>();

        }
        double longitude = locationBeans.get(0).getLongitude();
        double latitude = locationBeans.get(0).getLatitude();
        return dataSourceManager.getJdbcTemplate().query(
                serviceDiscioveryQuery,
                new Object[]{latitude + 0.0001, latitude - 0.0001, longitude + 0.0001, longitude - 0.0001},
                new int[]{Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE},
                (rs, rowNum) -> new AttaractionSummary(
                        rs.getInt("svc_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        new LocationBean(rs.getDouble("lng"), rs.getDouble("lat")),
                        rs.getDouble("svc_fee")
                )
        );
    }

}