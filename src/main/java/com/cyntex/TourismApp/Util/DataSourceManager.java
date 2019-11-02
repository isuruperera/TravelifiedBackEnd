package com.cyntex.TourismApp.Util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class DataSourceManager{
//    private static final String DRIVER = "com.mysql.jdbc.Driver";
//    private static final String JDBC_URL = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10304160";
//    private static final String USERNAME = "sql10304160";
//    private static final String PASSWORD = "mji8h8iWDU";
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost/tourism_app";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        DataSource source = getDataSource();
        setJdbcTemplate(new JdbcTemplate(source));
    }

    /**
     * Returns a DataSource object for connection to the database.
     *
     * @return a DataSource.
     */
    public  DataSource getDataSource() {
        // Creates a new instance of DriverManagerDataSource and sets
        // the required parameters such as the Jdbc Driver class,
        // Jdbc URL, database user name and password.
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
