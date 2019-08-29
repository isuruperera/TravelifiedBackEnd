package com.cyntex.TourismApp.Logic;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.AddFriendToChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.AddFriendToChatGroupResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberRequestBean;
import com.cyntex.TourismApp.Persistance.GroupParticipantDAO;


@Component
public class GroupParticipantRequestHandler {
	
	@Autowired
	GroupParticipantDAO groupParticipantDAO;

	public BaseResponse addMember(AddFriendToChatGroupRequestBean addFriendRequestBean){
		
		AddFriendToChatGroupResponseBean responseBean= new AddFriendToChatGroupResponseBean();
    	String username=addFriendRequestBean.getUsername();
    	int  chatGroupId=addFriendRequestBean.getChatGroupId();
    	String addedBy=addFriendRequestBean.getAddedBy();
    	String avatar=addFriendRequestBean.getAvatar();
		try{
			if(!(StringUtils.isEmpty(username)|| StringUtils.isEmpty(addedBy) || StringUtils.isEmpty(avatar) || chatGroupId==0)){
				 if(groupParticipantDAO.isAdmin(addedBy,chatGroupId) && !groupParticipantDAO.checkExistance( chatGroupId, username)){
					 groupParticipantDAO.addFriend(username,chatGroupId,addedBy,avatar);
					 responseBean.setStatus("SUCCESS ");
			     }else{
					 responseBean.setStatus("FAILED: you are not a admin or friend is already a member of the group");
					
				}
			}else{
				responseBean.setStatus(" Check the payload again  ");
			}
			
		}catch(DataIntegrityViolationException  e){
			responseBean.setStatus("FAILED: duplicate entry  ");
			
		}catch(Exception e ){
			responseBean.setStatus("FAILED: user cannot be added  " );
		}
		 return responseBean;
    }
	
	public BaseResponse deleteMember(DeleteChatGroupMemberRequestBean deleteChatGroupMemberRequestBean){
		AddFriendToChatGroupResponseBean responseBean= new AddFriendToChatGroupResponseBean();
    	String username=deleteChatGroupMemberRequestBean.getUsername();
    	int  chatGroupId=deleteChatGroupMemberRequestBean.getChatGroupId();
    	String deletedBy=deleteChatGroupMemberRequestBean.getDeletedBy();
    	
		try{
			if(!(StringUtils.isEmpty(username)|| StringUtils.isEmpty(deletedBy)|| chatGroupId==0) ){
				 if(groupParticipantDAO.isAdmin(deletedBy,chatGroupId) && groupParticipantDAO.checkExistance( chatGroupId, username)){
					 groupParticipantDAO.deleteFriend(username , chatGroupId);
					 responseBean.setStatus("SUCCESS ");
			     }else{
						 responseBean.setStatus("FAILED: you are not a admin or friend isn't a member of the group");
						 return responseBean;
				}
			}
			else{
				 responseBean.setStatus("FAILED:check the payload again");	 
			}
		}
		catch(Exception e ){
			responseBean.setStatus("FAILED: user cannot be deleted " );
		}
		 return responseBean;
			
			
		}
		
	
}
