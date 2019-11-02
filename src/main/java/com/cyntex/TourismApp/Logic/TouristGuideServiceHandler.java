package com.cyntex.TourismApp.Logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.ContactTouristGuideGetMessageQueryResponseBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideGetMessageRequestBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideGetMessageResponseBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideSendMessageRequestBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideSendMessageResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Exception.DataMismatchException;
import com.cyntex.TourismApp.Persistance.MessageTouristGuideDAO;
import com.cyntex.TourismApp.Persistance.ServiceProviderDAO;
import com.cyntex.TourismApp.Persistance.UserDAO;


@Component
public class TouristGuideServiceHandler {
	
	@Autowired
	MessageTouristGuideDAO messageTouristGuideDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	ServiceProviderDAO serviceProviderDAO; 
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor= Exception.class ,  timeout=120)
	public void sendMessage(ContactTouristGuideSendMessageRequestBean contactTouristGuideSendMessageRequestBean) throws Exception{
		
			int serviceId=contactTouristGuideSendMessageRequestBean.getServiceId();
			String username=contactTouristGuideSendMessageRequestBean.getUsername();
			String message=contactTouristGuideSendMessageRequestBean.getMessage();
			String firstname=userDAO.getAuthenticatedUser(username).get(0).getFirstName();
	
			if(serviceProviderDAO.validateServiceProvider(serviceId, username)){
			
					
					if(!(StringUtils.isEmpty(firstname) || StringUtils.isEmpty(username) || serviceId==0)){
						messageTouristGuideDAO.saveMessage(serviceId,username,firstname,message);
					}else{
						throw new BadRequestException("FAILED :Check the payload");
						
					}
			
		 }else{
			 throw new DataMismatchException("FAILED : user dosen't provide this kind of service");
		 }


		
	}
	
	@Transactional( timeout=120)
	public List<ContactTouristGuideGetMessageQueryResponseBean> getMessage(ContactTouristGuideGetMessageRequestBean contactTouristGuideGetMessageRequestBean) throws Exception{

		
			int serviceId=contactTouristGuideGetMessageRequestBean.getServiceId();
			String username=contactTouristGuideGetMessageRequestBean.getUsername();
			List<ContactTouristGuideGetMessageQueryResponseBean> messageQueryResponse;
			if(!(StringUtils.isEmpty(username)|| serviceId==0)){
				
				messageQueryResponse=messageTouristGuideDAO.getMessageDetails(serviceId,username);
					
			}else{
				throw new BadRequestException("FAILED :Check the payload");
				
			}

		return messageQueryResponse;		
		
		
	}

}
