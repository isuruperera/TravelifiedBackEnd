package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.DiscoverTouristFriendRatingDetailQueryResponseBean;
import com.cyntex.TourismApp.Beans.RatingProfileFetchQueryBasedOnCategoryBean;
import com.cyntex.TourismApp.Beans.RatingsProfileQueryResponseBean;
import com.cyntex.TourismApp.Util.DataSourceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class UserRatingsProfileDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    private static final String ratingsProfileFetchQuery
            = "select * from user_rating_profile where username = ?";
    
    private static final String findAverageRatingValueFetchQuery
    		= "select username,avg(rating) as average_rating from user_rating_profile where category = ? and username != ? group by username ";
    
   

    public List<RatingsProfileQueryResponseBean> getUserRatingsProfile(String username) {
        List<RatingsProfileQueryResponseBean> queryData = jdbcTemplate.query(
                ratingsProfileFetchQuery,new Object[]{username},new int[]{Types.VARCHAR},
                (rs, rowNum) -> new RatingsProfileQueryResponseBean(
                        rs.getString("category"), rs.getDouble("rating"))
        );
        return queryData;
    }
    

    public List<DiscoverTouristFriendRatingDetailQueryResponseBean> getAverageRating(String category, String username){
   
    	List<DiscoverTouristFriendRatingDetailQueryResponseBean> queryData= jdbcTemplate.query(
    			findAverageRatingValueFetchQuery,new Object[]{category, username},new int[]{Types.VARCHAR,Types.VARCHAR},
                (rs, rowNum) -> new DiscoverTouristFriendRatingDetailQueryResponseBean(
                        rs.getString("username"),rs.getDouble("average_rating"))
        );
    	return queryData;
    
    }
}
