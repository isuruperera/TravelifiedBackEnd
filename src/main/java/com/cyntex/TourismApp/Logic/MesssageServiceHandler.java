package com.cyntex.TourismApp.Logic;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Exception.PermissionDeniedException;
import com.cyntex.TourismApp.Persistance.GroupParticipantDAO;
import com.cyntex.TourismApp.Persistance.MessageDAO;
import com.cyntex.TourismApp.Persistance.UserDAO;


@Component
public class MesssageServiceHandler {
	
	@Autowired
	private MessageDAO messageDAO;
	
	@Autowired
	private GroupParticipantDAO groupParticipantDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	
	@Transactional(rollbackFor= Exception.class, timeout=120)
	public void sendMessage(SendMessageRequestBean requestBean) throws Exception{
		

		 String username=requestBean.getUsername();
	     int chatGroupId=requestBean.getGroupId();
		 String message=requestBean.getMessage();
		 String firstname=requestBean.getFirstname();
		 
		 if(!(StringUtils.isEmpty(username)|| StringUtils.isEmpty(firstname) ||chatGroupId==0)){
	    
			 if(groupParticipantDAO.checkExistance( chatGroupId, username) && userDAO.validate(username,firstname)){
			    messageDAO.saveMessage(chatGroupId,username,firstname,message);
			 }else{
				 throw new PermissionDeniedException("FAILED: user is not in the group or username and firstname are not match");
			 }
		 }else{
			 throw new BadRequestException("FAILED: Check the payload again");
	
		 }

		
	}
	@Transactional(rollbackFor= Exception.class, timeout=120)
	public List<SendMessageQueryResponsBean> getMessage(int chatGroupId) throws Exception{
		
		
		List<SendMessageQueryResponsBean> messageReponseList;
		messageReponseList=messageDAO.getMessageDetails(chatGroupId);
		
		
		return messageReponseList;
			
		}
	

	

}
