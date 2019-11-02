package com.cyntex.TourismApp.Logic;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.AddServiceProviderRequestBean;
import com.cyntex.TourismApp.Beans.AddServiceProviderResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Exception.PermissionDeniedException;
import com.cyntex.TourismApp.Persistance.ServiceProviderDAO;
import com.cyntex.TourismApp.Persistance.UserDAO;


@Component
public class TouristServiceProvideHandler {
	
	@Autowired
	UserDAO userDAO; 
	
	@Autowired
	ServiceProviderDAO serviceProviderDAO;
	
	@Transactional(rollbackFor= Exception.class , timeout=120)
	public void addServiceProvider(AddServiceProviderRequestBean addServiceProviderRequestBean) throws  Exception{
		
		AddServiceProviderResponseBean response= new AddServiceProviderResponseBean();
		
			String addedBy=addServiceProviderRequestBean.getAddedBy();
			int serviceId=addServiceProviderRequestBean.getServiceId();
			String username=addServiceProviderRequestBean.getUsername();
			
			
				if(userDAO.isAdmin(addedBy)){
					if(!(StringUtils.isEmpty(username)|| serviceId==0)){
						
						serviceProviderDAO.addServiceProvider(serviceId,username);
					}else{
						throw new BadRequestException("FAILED :Check the payload");
						
					}
				
				}else{
					throw new PermissionDeniedException("FAILED : you are not an admin ");
				}

	}
	

}
