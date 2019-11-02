package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.AuthenticatedUserBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendUserProfileQueryResponseBean;
import com.cyntex.TourismApp.Beans.SearchFriendQueryResponseBean;
import com.cyntex.TourismApp.Beans.SearchFriendResponseBean;
import com.cyntex.TourismApp.Util.DataSourceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	 private int response;
	 
	private static final String checkIsAdmin=
			"select count(*) as counter from user where username = ? and is_admin = '1' ";
		
	private static final String checkExistance=
		    "select count(*) as counter from user where username = ? and first_name = ?";

    private static final String userRetrieveQuery = 
    		"select * from user where username = ?";
    
    private static final String userRetreveRequestQuery= 
    		"select * from user where first_name like ?";
    
   
    
	 
  
    @Transactional
    public List<AuthenticatedUserBean> getAuthenticatedUser(String username) {
        List<AuthenticatedUserBean> queryData = jdbcTemplate.query(
                userRetrieveQuery,
                new Object[]{username},
                new int[]{Types.VARCHAR},
                (rs, rowNum) -> new AuthenticatedUserBean(
                        rs.getString("username"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("contact_number"),
                        rs.getString("country"),
                        rs.getString("gender"),
                        rs.getString("picture_link"),
                        rs.getString("password"),
                        rs.getString("pwd_salt"),
                        rs.getInt("is_admin"))
        );
        return queryData;
    }
    

    @Transactional
    public DiscoverTouristFriendUserProfileQueryResponseBean getUserRatingsProfile(String username) {
    
    	DiscoverTouristFriendUserProfileQueryResponseBean queryData = jdbcTemplate.query(
    			userRetrieveQuery, new Object[]{username}, 
                (rs, rowNum) -> new DiscoverTouristFriendUserProfileQueryResponseBean(
                rs.getString("username"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("contact_number"),
                rs.getString("country"),rs.getString("gender"),rs.getString("picture_link")
                )
                ).get(0);

        return queryData;
    }
    
    
    @Transactional
    public List<SearchFriendQueryResponseBean> getSearchFriend(String firstname){
    //	System.out.print(firstname);
    
    List<SearchFriendQueryResponseBean> queryData=jdbcTemplate.query(
    		userRetreveRequestQuery, new Object[]{firstname+"%"}, new int[]{Types.VARCHAR},
            (rs, rowNum) -> new SearchFriendQueryResponseBean(
            rs.getString("username"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("contact_number"),
            rs.getString("country"),rs.getString("gender"),rs.getString("picture_link")
            )
            );
 //   System.out.print(queryData.size());
       return queryData;
            
    }
    @Transactional
    public boolean validate(String username,String firstname){
    	
    	jdbcTemplate.query(checkExistance,
	                new Object[] {username,firstname},
	                new int[]{Types.VARCHAR,Types.VARCHAR},(rs,rawNo) ->response= rs.getInt("counter"));
			   
//		System.out.println("checkExistance "+response);        
			if(response == 0){return false;} else{return true;}
    }
    
	@Transactional
	public boolean isAdmin(String addedBy){
		
		jdbcTemplate.query(checkIsAdmin,
                new Object[] {addedBy},
                new int[]{Types.VARCHAR},(rs,rawNo) -> response=rs.getInt("counter"));
              
	    
	    System.out.println("isAdmin "+response);  
		if(response == 0){return false;} else{return true;}
	}
}
