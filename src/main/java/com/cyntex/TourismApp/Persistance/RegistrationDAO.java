package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Util.DataSourceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;


@Component
public class RegistrationDAO {
    private static String registerQuery = "insert into user " +
//<<<<<<< HEAD
//            "(username, first_name, last_name, gender, country, contact_number, pwd_salt, password, picture_link," +
//            "location_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
//=======
            "(username, " +
            "first_name, " +
            "last_name, " +
            "gender, " +
            "country, " +
            "contact_number, " +
            "picture_link, " +
            "location_id, " +
            "pwd_salt, " +
            "password) VALUES (?,?,?,?,?,?,?,?,?,?)";
//>>>>>>> 17255464ae7af3e8bfa154280d0c3f97dd868db7
    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
//<<<<<<< HEAD
//    public void addNewRecord(String userName,String firstName,String lastName, String gender, String country,
//                             String contactNumber, String pwdSalt, String password, String pictureLink,
//                             String locationId){
//        dataSourceManager.getJdbcTemplate().update(registerQuery,
//                new Object[] {userName,firstName,lastName,gender,country,contactNumber,pwdSalt,
//        		password, pictureLink,locationId},
//                new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
//                Types.VARCHAR,Types.VARCHAR,Types.VARCHAR});
//=======
    public void addNewUser(String userName, String firstName, String lastName, String gender, String country,
                           String contactNumber,
                           String pictureLink, String locationId, String pwdSalt, String password) {

        dataSourceManager.getJdbcTemplate().update(registerQuery,
                                                   new Object[]{userName, firstName, lastName, gender, country, contactNumber, pictureLink, locationId, pwdSalt,
                                                           password},
                                                   new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
                                                           Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});
//>>>>>>> 17255464ae7af3e8bfa154280d0c3f97dd868db7
    }
}
