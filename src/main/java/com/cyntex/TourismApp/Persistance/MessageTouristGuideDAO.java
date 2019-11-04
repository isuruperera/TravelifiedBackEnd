package com.cyntex.TourismApp.Persistance;


import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Beans.ChatUserBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideGetMessageQueryResponseBean;
import com.cyntex.TourismApp.Beans.SendMessageQueryResponsBean;
import com.cyntex.TourismApp.Util.DataSourceManager;
import com.cyntex.TourismApp.Util.FSManager;


@Component
public class MessageTouristGuideDAO {
	

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private static final String saveMessageQuery=
			"insert into message_details_guide(service_id,username, message ,created_date) values (?,?,?,?)";
	private static final String getMessageDetailsQuery =
			"select * from message_details_guide as one left join user as two on (one.username = two.username) where (one.service_id = ?  and two.username= ? ) order by one.created_date ";
	
	

	public void saveMessage(int serviceId, String username,String message){
		jdbcTemplate.update(saveMessageQuery,
                new Object[] {serviceId,username,message, new Date()},
                new int[]{Types.INTEGER,Types.VARCHAR,Types.VARCHAR,Types.DATE});

		
	}

	public List<ContactTouristGuideGetMessageQueryResponseBean> getMessageDetails(int serviceId ,String username){
		 List<ContactTouristGuideGetMessageQueryResponseBean> queryData = jdbcTemplate.query(
				getMessageDetailsQuery,
                new Object[] {serviceId , username},
                new int[]{Types.INTEGER,Types.VARCHAR},
                (rs,rowNum) -> new ContactTouristGuideGetMessageQueryResponseBean(
                        rs.getInt("message_id"),
                         rs.getString("message"),
                        rs.getDate("created_date"),
                        new ChatUserBean(rs.getString("username"),rs.getString("first_name")+" "+rs.getString("last_name")))
        );
        
		return queryData;
	} 

}
