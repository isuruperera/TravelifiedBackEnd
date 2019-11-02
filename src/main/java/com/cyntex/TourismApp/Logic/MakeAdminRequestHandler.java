package com.cyntex.TourismApp.Logic;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.MakeAdminRequestBean;
import com.cyntex.TourismApp.Beans.MakeAdminResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Exception.PermissionDeniedException;
import com.cyntex.TourismApp.Persistance.GroupParticipantDAO;


@Component
public class MakeAdminRequestHandler {
	
	@Autowired
	GroupParticipantDAO groupParticipantDAO;
	
	
	
	@Transactional(rollbackFor= Exception.class,  timeout=120)
	public void makeAdmin(MakeAdminRequestBean makeAdminRequestBean) throws Exception{
	
		int chatGroupId=makeAdminRequestBean.getGroupId();
		String username=makeAdminRequestBean.getUsername();
		String adminname=makeAdminRequestBean.getAdminname();
	
			
		 if(!(StringUtils.isEmpty(username)|| StringUtils.isEmpty(adminname) || chatGroupId==0)){
			if(groupParticipantDAO.isAdmin(adminname, chatGroupId) && groupParticipantDAO.checkExistance( chatGroupId, username) && !groupParticipantDAO.isAdmin(username, chatGroupId)){
				groupParticipantDAO.makeAdmin(chatGroupId, username);
				
			}else{
				throw new PermissionDeniedException("FAILED: you are not an admin or user is not in the group or user already an admin : making admin is unsuccessful");
	
			}
			
		 }else{
			 throw new BadRequestException("FAILED: check the payload again");
			
		 }
	
	}
}
