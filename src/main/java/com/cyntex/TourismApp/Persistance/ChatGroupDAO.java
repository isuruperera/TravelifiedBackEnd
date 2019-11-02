package com.cyntex.TourismApp.Persistance;


import java.sql.Types;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class ChatGroupDAO {
	@Autowired
	GroupParticipantDAO groupParticipantDAO;
	
//	@Autowired
//	private DataSourceManager datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	private static final String createChatGroupRequest=

			"insert into chat_group(chat_group_id,group_title,category,created_by,created_date) values (?,?,?,?,?)";


    public void createChatGroup(List<String> selectedUsers ,int chatGroupId, String title, String category, String createdBy){
	
    	jdbcTemplate.update(createChatGroupRequest,
                new Object[] {chatGroupId,title,category,createdBy,new Date()},
                new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.DATE});


   
    	

    	
    }
    


}
