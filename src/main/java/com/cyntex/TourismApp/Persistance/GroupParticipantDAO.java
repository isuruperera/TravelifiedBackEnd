package com.cyntex.TourismApp.Persistance;

import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Beans.AddFriendToChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.GetUserChatGroupQueryResponseBean;
import com.cyntex.TourismApp.Util.DataSourceManager;



@Component
public class GroupParticipantDAO {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private int response;
	
	private static final String checkExistance=
	        "select count(*) as counter from group_participant where username = ? and chat_group_id = ?";
	private  static final String addFriendRequest=
			"insert into group_participant(username,chat_group_id,added_by) values (?,?,?)";
	
	private  static final String deleteFriendRequest=
			"delete from group_participant where  username = ? and chat_group_id = ?";
	
	private  static final String addGroupCreator=
			"insert into group_participant(username,chat_group_id,is_admin) values (?,?,?)";
		
	private  static final String checkIsAdmin=
			"select count(*) as counter from group_participant where username  = ? and chat_group_id = ? and is_admin = '1'  ";
	
	private static final String makeAdmin=
			"update group_participant set is_admin= '1' where username = ? and chat_group_id = ?";
	
	private static final String getUserChatGroupDetails=
			"select * from group_participant as one left join chat_group as two on (one.chat_group_id=two.chat_group_id) where one.username = ?";
			
	
	public void makeAdmin(int chatGroupId, String username){
		
		jdbcTemplate.update(makeAdmin,
                new Object[] {username,chatGroupId},
                new int[]{Types.VARCHAR,Types.INTEGER});
		
		
	}		

	public boolean checkExistance(int chatGroupId, String username){
	
		jdbcTemplate.query(checkExistance,
                new Object[] {username,chatGroupId},
                new int[]{Types.VARCHAR,Types.INTEGER},(rs,rawNo) ->response= rs.getInt("counter"));
	    
		if(response == 0){return false;} else{return true;}
	}
	
	
	public void addFriend(String username,int chatGroupId,String addedBy){

		
		jdbcTemplate.update(addFriendRequest,
                new Object[] {username,chatGroupId,addedBy},
                new int[]{Types.VARCHAR,Types.INTEGER,Types.VARCHAR});
                
	}

	public void addAdmin(int chatGroupId,String username){
		
		jdbcTemplate.update(addGroupCreator,
                new Object[] {username,chatGroupId,1},
                new int[]{Types.INTEGER,Types.INTEGER,Types.INTEGER});
                
		
	}
	public List<GetUserChatGroupQueryResponseBean> getUserChatGroup(String username){
		
		List<GetUserChatGroupQueryResponseBean> response=jdbcTemplate.query(getUserChatGroupDetails, 
				new Object[]{username}, new int[]{Types.VARCHAR},
				(rs,rawNo)-> new GetUserChatGroupQueryResponseBean(rs.getInt("chat_group_id"),rs.getString("group_title")
						,rs.getString("category"),rs.getDate("created_date")));
		return response;
	
	}
	
	public void deleteFriend(String username , int chatGroupId){
		
		jdbcTemplate.update(deleteFriendRequest,
                new Object[] {username, chatGroupId},
                new int[]{Types.VARCHAR,Types.INTEGER});
                
		
	}
	
	
	public boolean isAdmin(String addedBy, int chatGroupId){
		
		jdbcTemplate.query(checkIsAdmin,
                new Object[] {addedBy,chatGroupId},
                new int[]{Types.VARCHAR,Types.INTEGER},(rs,rawNo) -> response=rs.getInt("counter"));

		if(response == 0){return false;} else{return true;}
	}
	
	

}
