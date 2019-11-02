package com.cyntex.TourismApp.Persistance;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class ServiceProviderDAO {
	

    
	private int response;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	 
	 
    
	private final static String addServiceProviderRequestQuery="insert into service_providers values (?,?)";
	
	private final static String validateServiceProvider=
			"select count(*) as counter from service_providers where service_id= ? and username = ?  ";
	
	
	public void addServiceProvider(int serviceId,String username){
	
		jdbcTemplate.update(addServiceProviderRequestQuery,
                new Object[] {serviceId,username},
                new int[]{Types.INTEGER,Types.VARCHAR});
		
		
		
		
	}

	public boolean validateServiceProvider( int serviceId,String username){
		
		jdbcTemplate.query(validateServiceProvider,
                new Object[] {serviceId, username},
                new int[]{Types.INTEGER,Types.VARCHAR},(rs,rawNo) -> response=rs.getInt("counter"));
              
	    
		if(response == 0){return false;} else{return true;}


	}
	
}
