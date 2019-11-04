package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Util.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class UserDAO {

    private static final String checkIsAdmin =
            "select count(*) as counter from user where username = ? and is_admin = '1' and is_active = '1'";

    private static final String ratingsProfileFetchQuery
            = "select * from user_rating_profile where username = ?";
    private static final String checkExistance=
            "select count(*) as counter from user where username = ? and first_name = ? and is_active = '1'";

    private int response;
    private static final String addUserRating = "insert into user_rating_profile (username, category, rating, " +
            "rated_by) values(?,?,?,?)";

    private static final String userRetreveRequestQuery=
            "select * from user where first_name like ?";
    private static String userRetrieveQuery = "select * from user where username = ? and is_active = '1'";

    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public void setAddUserRating(String userId, String raterId, int adventurer, int entertainer, int friend,
                                 int masterChef, int animalLover) {
        JdbcTemplate jdbcTemplate = dataSourceManager.getJdbcTemplate();
        jdbcTemplate.update(
                addUserRating,
                new Object[]{userId, "Adventurer", adventurer, raterId},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR}
        );
        jdbcTemplate.update(
                addUserRating,
                new Object[]{userId, "Entertainer", entertainer, raterId},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR}
        );
        jdbcTemplate.update(
                addUserRating,
                new Object[]{userId, "Friend In Need", friend, raterId},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR}
        );
        jdbcTemplate.update(
                addUserRating,
                new Object[]{userId, "Master Chef", masterChef, raterId},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR}
        );
        jdbcTemplate.update(
                addUserRating,
                new Object[]{userId, "Animal Lover", animalLover, raterId},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR}
        );
    }

    @Transactional
    public List<AuthenticatedUserBean> getAuthenticatedUser(String username) {
        List<AuthenticatedUserBean> queryData = dataSourceManager.getJdbcTemplate().query(
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
    public List<UserBean> getUserProfile(String username) {
        List<UserBean> queryData = dataSourceManager.getJdbcTemplate().query(
                userRetrieveQuery,
                new Object[]{username},
                new int[]{Types.VARCHAR},
                (rs, rowNum) -> new UserBean(
                        rs.getString("username"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("contact_number"),
                        rs.getString("country"),
                        rs.getString("gender"),
                        rs.getString("picture_link"))
        );
        return queryData;
    }

    @Transactional
    public List<RatingsProfileQueryResponseBean> getUserRatingsProfile(String username) {
        List<RatingsProfileQueryResponseBean> queryData = dataSourceManager.getJdbcTemplate().query(
                ratingsProfileFetchQuery,
                new Object[]{username},
                new int[]{Types.VARCHAR},
                (rs, rowNum) -> new RatingsProfileQueryResponseBean(
                        rs.getString("category"), rs.getInt("rating"))
        );
        return queryData;
    }

    @Transactional
    public DiscoverTouristFriendUserProfileQueryResponseBean getDiscoveryProfile(String username) {

        DiscoverTouristFriendUserProfileQueryResponseBean queryData = dataSourceManager.getJdbcTemplate().query(
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

        List<SearchFriendQueryResponseBean> queryData = dataSourceManager.getJdbcTemplate().query(
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
        dataSourceManager.getJdbcTemplate().query(checkExistance,
                                                  new Object[] {username,firstname},
                                                  new int[]{Types.VARCHAR, Types.VARCHAR},
                                                  (rs, rawNo) -> response = rs.getInt("counter"));

//		System.out.println("checkExistance "+response);
        if(response == 0){return false;} else{return true;}
    }

    @Transactional
    public boolean isAdmin(String addedBy){

        dataSourceManager.getJdbcTemplate().query(checkIsAdmin,
                                                  new Object[] {addedBy},
                                                  new int[]{Types.VARCHAR}, (rs,rawNo) -> response=rs.getInt("counter"));


        System.out.println("isAdmin "+response);
        if(response == 0){return false;} else{return true;}
    }
}
