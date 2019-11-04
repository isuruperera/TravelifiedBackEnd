package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.AdminEventBean;
import com.cyntex.TourismApp.Beans.AdminServiceBean;
import com.cyntex.TourismApp.Beans.AdminUserListBean;
import com.cyntex.TourismApp.Util.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class AdminDAO {
    private String getAllUsers = "select * from user";
    private String getAllEvents = "select * from tourist_event";
    private String getAllServices = "select * from tourist_service";

    private String updateUser = "update user set is_active = ? where username = ?";
    private String updateEvent = "update tourist_event set is_active = ? where event_id = ?";
    private String updateService = "update tourist_service set is_active = ? where service_id = ?";


    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public List<AdminUserListBean> getAllUsers() {
        return dataSourceManager.getJdbcTemplate().query(
                getAllUsers,
                (rs, rowNum) -> new AdminUserListBean(
                        rs.getString("username"),
                        rs.getString("first_name") + " " + rs.getString("last_name"),
                        rs.getString("picture_link"),
                        rs.getInt("is_active")
                )
        );
    }

    @Transactional
    public void updateUser(String id, int state) {
        dataSourceManager.getJdbcTemplate().update(
                updateUser,
                new Object[]{state, id},
                new int[]{Types.INTEGER, Types.VARCHAR}
        );
    }

    @Transactional
    public List<AdminEventBean> getAllEvents() {
        return dataSourceManager.getJdbcTemplate().query(
                getAllEvents,
                (rs, rowNum) -> new AdminEventBean(
                        rs.getString("event_id"),
                        rs.getString("event_title"),
                        rs.getString("title_photo_url"),
                        rs.getInt("is_active")
                )
        );
    }

    @Transactional
    public void updateEvent(String id, int state) {
        dataSourceManager.getJdbcTemplate().update(
                updateEvent,
                new Object[]{state, id},
                new int[]{Types.INTEGER, Types.VARCHAR}
        );
    }

    @Transactional
    public List<AdminServiceBean> getAllServices() {
        return dataSourceManager.getJdbcTemplate().query(
                getAllServices,
                (rs, rowNum) -> new AdminServiceBean(
                        rs.getString("service_id"),
                        rs.getString("service_title"),
                        rs.getString("title_photo_url"),
                        rs.getInt("is_active")
                )
        );
    }

    @Transactional
    public void updateService(String id, int state) {
        dataSourceManager.getJdbcTemplate().update(
                updateService,
                new Object[]{state, id},
                new int[]{Types.INTEGER, Types.VARCHAR}
        );
    }

}
