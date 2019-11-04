package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.GetTouristServiceQueryResponseBean;
import com.cyntex.TourismApp.Beans.ServiceRatingUserMappedCommentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.List;


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

    private static final String getTouristServicesByTitleQuery = "select * from tourist_service where service_title = ?" +
            "  and is_active = '1'";

    private static final String getServiceRatingProfileQuery = "select * from service_rating_profile where " +
            "service_id = ? ";

    private static final String putServiceRatingCommentQuery = "insert into service_rating_profile(user_id, " +
            "service_id, rating, comment, photo_url) " +
            "values(?,?,?,?,?)";

    private static final String getAllTouristServices = "select * from tourist_service where is_active = '1'";
    
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
                new Object[] {serviceTitle},
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

    public void addServiceRatingComment(String userId, int serviceId, double rating, String comment, String photoUrl) {
        jdbcTemplate.update(putServiceRatingCommentQuery,
                            new Object[]{userId, serviceId, rating, comment, photoUrl},
                            new int[]{Types.VARCHAR, Types.INTEGER, Types.DOUBLE, Types.VARCHAR, Types.VARCHAR});
    }

    public List<ServiceRatingUserMappedCommentBean> getAllTouristServiceComments(int serviceId) {
        List<ServiceRatingUserMappedCommentBean> queryData
                = jdbcTemplate.query(getServiceRatingProfileQuery,
                                     new Object[]{serviceId},
                                     new int[]{Types.INTEGER},
                                     (rs, rowNum) -> new ServiceRatingUserMappedCommentBean(
                                             rs.getString("user_id"), rs.getInt("service_Id"),
                                             rs.getString("photo_url"), rs.getString("comment"),
                                             rs.getDouble("rating")));

        return queryData;
	}
	


}
