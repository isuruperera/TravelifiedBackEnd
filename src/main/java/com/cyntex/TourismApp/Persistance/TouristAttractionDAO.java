package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionPlaceQueryResponseBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionQueryResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.List;

@Component
public class TouristAttractionDAO {
	
	private static final String touristAttractionPlacesFetchQuery=
			"select * from tourist_attraction where attraction_id = ?";
	private static final String addTouristAttrationQuery=
			"insert into tourist_attraction(attraction_name,description,rating_profile_id,title_photo_url," +
					"photo_collection_id,longitude,latitude)  values (?,?,?,?,?,?,?)";
	
	public static final String locationDetailFetcQuery=
			"select * from tourist_attraction";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public DiscoverTouristAttractionPlaceQueryResponseBean getTouristAttraction(int attraction_id ) throws Exception{
 
    	DiscoverTouristAttractionPlaceQueryResponseBean queryData = jdbcTemplate.query(
    			touristAttractionPlacesFetchQuery, new Object[]{attraction_id}, new int[]{Types.INTEGER},
                (rs, rowNum) -> new DiscoverTouristAttractionPlaceQueryResponseBean(rs.getInt("attraction_id"),rs.getDouble("lat"),rs.getDouble("lng"),rs.getString("attraction_name"),
                	rs.getString("description"),rs.getString("title_photo_url"),rs.getString("photo_collection_id"))).get(0);
    	return queryData;
  }
    

    public void addTouristAttraction(String attractionName,String description,String ratingProfileId,String titlePhotoID,String photoCollectionId,double lng,double lat) throws Exception{
    	
    	jdbcTemplate.update(
    			addTouristAttrationQuery, new Object[]{attractionName,description,ratingProfileId,titlePhotoID,photoCollectionId,lng,lat},
    			new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.DOUBLE,Types.DOUBLE}
                );
    }
    


    public List<DiscoverTouristAttractionQueryResponseBean> getUserRatingsProfile() {

    	List<DiscoverTouristAttractionQueryResponseBean> queryData = jdbcTemplate.query(
    			locationDetailFetcQuery, 
                (rs, rowNum) -> new DiscoverTouristAttractionQueryResponseBean( rs.getInt("attraction_id"),rs.getDouble("lng"),rs.getDouble("lat")));
	
    	return queryData;
    }

}
