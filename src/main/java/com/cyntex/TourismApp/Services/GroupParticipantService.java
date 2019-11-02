package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;










import com.cyntex.TourismApp.Beans.AddFriendToChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.AddFriendToChatGroupResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberRequestBean;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Logic.GroupParticipantRequestHandler;


@Service 
public class GroupParticipantService {
	@Autowired
	GroupParticipantRequestHandler addFriendRequestHandler;
	
	public BaseResponse addFriend(AddFriendToChatGroupRequestBean addFriendRequestBean){
		 
		AddFriendToChatGroupResponseBean baseResponse= new AddFriendToChatGroupResponseBean();
		try{
			addFriendRequestHandler.addMember(addFriendRequestBean);	
		    baseResponse.setStatus("SUCCESS");

		}catch(BadRequestException e){
			baseResponse.setStatus(e.getMessage());
		}catch(DataIntegrityViolationException e){
			baseResponse.setStatus("FAILED : this member is already exists ");
		}	
		catch(Exception e){
			baseResponse.setStatus("Transaction fails "+e.getMessage());
		}
		return baseResponse;	
	
	}
	
	public BaseResponse deleteMember(DeleteChatGroupMemberRequestBean deleteChatGroupMemberRequestBean){
		
		DeleteChatGroupMemberResponseBean baseResponse= new DeleteChatGroupMemberResponseBean();
		
		
		try{
			addFriendRequestHandler.deleteMember(deleteChatGroupMemberRequestBean);
			
		    baseResponse.setStatus("SUCCESS");

		}catch(BadRequestException e){			
			baseResponse.setStatus(e.getMessage());			
		}catch(DuplicateKeyException e){
			baseResponse.setStatus("FAILED : this service provider already exists ");			
		}catch(Exception e){
			baseResponse.setStatus("Transaction fails "+e.getMessage());
			
		}
		return baseResponse;
	}

	

}



