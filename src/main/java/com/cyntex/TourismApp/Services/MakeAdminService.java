package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.MakeAdminRequestBean;
import com.cyntex.TourismApp.Beans.MakeAdminResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Logic.MakeAdminRequestHandler;


@Service
public class MakeAdminService {
	
	@Autowired
	MakeAdminRequestHandler makeAdminRequestHandler;
	
	public BaseResponse makeAdmin(MakeAdminRequestBean makeAdminRequestBean){
		MakeAdminResponseBean baseResponse= new MakeAdminResponseBean();
		try{
			makeAdminRequestHandler.makeAdmin(makeAdminRequestBean);
		    baseResponse.setStatus("SUCCESS");

		}catch(BadRequestException e){
			
			baseResponse.setStatus(e.getMessage());
			
		}
		catch(Exception e){
			
			baseResponse.setStatus("Transaction fails "+e.getMessage());
			
		}
		return baseResponse;
		
	}
	
}
