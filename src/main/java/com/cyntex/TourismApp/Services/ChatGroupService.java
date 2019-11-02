package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.CreateChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberRequestBean;
import com.cyntex.TourismApp.Beans.GetUserChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.GetUserChatGroupResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Logic.ChatGroupRequestHandler;

@Service

public class ChatGroupService {
	@Autowired
	private ChatGroupRequestHandler chatGroupRequestHandler;
	
	public BaseResponse createChatGroup(CreateChatGroupRequestBean createChatGroupRequestBean) throws Exception{
		BaseResponse baseResponse = new BaseResponse();
		try{
		 chatGroupRequestHandler.createChatGroup(createChatGroupRequestBean);
		 baseResponse.setStatus("SUCCESS");
		
		}catch(BadRequestException e){
		   baseResponse.setStatus(e.getMessage());
		}catch(Exception e){
			
			baseResponse.setStatus("Transaction fails "+e.getMessage());
			
		}
		return baseResponse;
	}
	
	public BaseResponse getChatUserDetails(GetUserChatGroupRequestBean getUserChatGroupRequestBean) throws Exception{
		GetUserChatGroupResponseBean baseResponse = new GetUserChatGroupResponseBean();
		try{
			baseResponse.setUserChatGroupList(chatGroupRequestHandler.getUserChatGroup(getUserChatGroupRequestBean));
	        baseResponse.setStatus("SUCCESS");
		
		}catch(BadRequestException e){
		   baseResponse.setStatus(e.getMessage());
		}catch(Exception e){
			
			baseResponse.setStatus("Transaction fails");
			
		}
		return baseResponse;	
		
		
		
	}
   
	

}
