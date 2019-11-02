package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.RatingsProfileQueryResponseBean;
import com.cyntex.TourismApp.Util.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class TestDAO {
    private String testQuery = "update test_table set value_save = ? where user_name = ?";

    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public void runTestUpdateQuery(String username, String saveValue) {
         dataSourceManager.getJdbcTemplate().update(
                 testQuery,
                new Object[]{ saveValue, username},
                new int[]{Types.VARCHAR, Types.VARCHAR}
        );
    }
}
