package com.cyntex.TourismApp.Persistance;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Beans.GetTouristServiceQueryResponseBean;
import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class TouristServiceDAO {
   
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
    private static final String getTouristServicesByTitleQuery="select * from tourist_service where service_title like ? ";
	
    
    private static final String getAllTouristServices="select * from tourist_service ";
    
	private static final String addTrouristServiceQuery="insert into tourist_service(service_title,"
			+ "service_description,"
			+ "owner_uname,"
			+ "title_photo_url, "
			+ "photo_collection_id, "
			+ "rating_profile_id, lng, lat) values (?,?,?,?,?,?,?,?)";
	
	
	
	public void addTouristService(String serviceTitle,String serviceDescription,String ownername,String titlePhotoUrl,String photoCollectionId,String ratingProfileId,double lng,double lat){
		
		jdbcTemplate.update(addTrouristServiceQuery,
                new Object[] {serviceTitle,serviceDescription,ownername,titlePhotoUrl,photoCollectionId,ratingProfileId,lng,lat},
                new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.DOUBLE,Types.DOUBLE});
		
		
	}

	public List<GetTouristServiceQueryResponseBean> getTouristServiceByTitle(String serviceTitle) throws Exception{
		List<GetTouristServiceQueryResponseBean> queryData=jdbcTemplate.query(getTouristServicesByTitleQuery,
                new Object[] {serviceTitle+"%"},
                new int[]{Types.VARCHAR },  (rs, rowNum) -> new GetTouristServiceQueryResponseBean(
                		rs.getInt("service_id"),rs.getString("service_title"),rs.getString("service_description"),
                		rs.getString("owner_uname"),rs.getString("title_photo_url"),
                		rs.getString("photo_collection_id"),rs.getString("rating_profile_id"),rs.getDouble("lng"),rs.getDouble("lat")
                		
                		
                		
                		));
		
		return queryData;
		
		
	}
	public List<GetTouristServiceQueryResponseBean> getAllTouristServices()throws Exception{
		List<GetTouristServiceQueryResponseBean> queryData=jdbcTemplate.query(getAllTouristServices,
            (rs, rowNum) -> new GetTouristServiceQueryResponseBean(
                		rs.getInt("service_id"),rs.getString("service_title"),rs.getString("service_description"),
                		rs.getString("owner_uname"),rs.getString("title_photo_url"),
                		rs.getString("photo_collection_id"),rs.getString("rating_profile_id"),rs.getDouble("lng"),rs.getDouble("lat")
                		                		
                		));
		
		return queryData;
		
		
	}
	


}
