package com.cyntex.TourismApp.Logic;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.AddFriendToChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.AddFriendToChatGroupResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberRequestBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Exception.PermissionDeniedException;
import com.cyntex.TourismApp.Persistance.GroupParticipantDAO;


@Component
public class GroupParticipantRequestHandler {
	
	@Autowired
	GroupParticipantDAO groupParticipantDAO;

	
	@Transactional(rollbackFor= Exception.class  , timeout=120)
	public void addMember(AddFriendToChatGroupRequestBean addFriendRequestBean) throws Exception{
    	String username=addFriendRequestBean.getUsername();
    	int  chatGroupId=addFriendRequestBean.getChatGroupId();
    	String addedBy=addFriendRequestBean.getAddedBy();
   
		if(!(StringUtils.isEmpty(username)|| StringUtils.isEmpty(addedBy) || chatGroupId==0)){
			 if(groupParticipantDAO.isAdmin(addedBy,chatGroupId) && !groupParticipantDAO.checkExistance( chatGroupId, username)){
				 groupParticipantDAO.addFriend(username,chatGroupId,addedBy);
				 
		     }else{
		    	 throw new PermissionDeniedException("FAILED: you are not a admin or friend is already a member of the group");		
			}
		}else{
			throw new BadRequestException(" Check the payload again  ");
		}

    }
	
	@Transactional(rollbackFor= Exception.class ,  timeout=120)
	public void deleteMember(DeleteChatGroupMemberRequestBean deleteChatGroupMemberRequestBean) throws Exception{
		AddFriendToChatGroupResponseBean responseBean= new AddFriendToChatGroupResponseBean();
    	String username=deleteChatGroupMemberRequestBean.getUsername();
    	int  chatGroupId=deleteChatGroupMemberRequestBean.getChatGroupId();
    	String deletedBy=deleteChatGroupMemberRequestBean.getDeletedBy();
    	
			if(!(StringUtils.isEmpty(username)|| StringUtils.isEmpty(deletedBy)|| chatGroupId==0) ){
				 if(groupParticipantDAO.isAdmin(deletedBy,chatGroupId) && groupParticipantDAO.checkExistance( chatGroupId, username)){
					 groupParticipantDAO.deleteFriend(username , chatGroupId);
					 responseBean.setStatus("SUCCESS ");
			     }else{
			    	 throw new PermissionDeniedException("FAILED: you are not a admin or friend isn't a member of the group");
			    	 
				}
			}
			else{
				throw new BadRequestException("FAILED:check the payload again");
				
			}
		}
		
	
}
