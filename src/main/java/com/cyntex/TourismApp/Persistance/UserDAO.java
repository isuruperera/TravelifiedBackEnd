package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.AuthenticatedUserBean;
import com.cyntex.TourismApp.Beans.RatingsProfileQueryResponseBean;
import com.cyntex.TourismApp.Beans.UserBean;
import com.cyntex.TourismApp.Util.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class UserDAO {

    private static String userRetrieveQuery = "select * from user where username = ?";

    private static final String ratingsProfileFetchQuery
            = "select * from user_rating_profile where username = ?";

    @Autowired
    private DataSourceManager dataSourceManager;

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
}
