package com.cyntex.TourismApp.Services;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Logic.TouristServiceHandler;
import com.cyntex.TourismApp.Logic.TouristServiceProvideHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;


@Service
public class TouristService {
	
	@Autowired
	private TouristServiceHandler  touristServiceHandler;
	
	@Autowired
	private TouristServiceProvideHandler touristServiceProvideHandler;
      
	public BaseResponse addTouristService(AddTouristServiceRequestBean addTouristServiceRequestBean){
		AddTouristServiceResponseBean baseResponse = new AddTouristServiceResponseBean();
		
		try{
			touristServiceHandler.addTouristService(addTouristServiceRequestBean);
	        baseResponse.setStatus("SUCCESS");
	        
		}catch(DuplicateKeyException e){
			baseResponse.setStatus("FAILED : this service already exists ");
		
		}catch(BadRequestException e){
			
			baseResponse.setStatus(e.getMessage());
			
		}catch(Exception e){
			
			baseResponse.setStatus("Transaction fails "+e.getMessage());
			
		}
		return baseResponse;
		
	}
	
	public BaseResponse addServiceProvider(AddServiceProviderRequestBean addServiceProviderRequestBean){
		AddServiceProviderResponseBean baseResponse= new AddServiceProviderResponseBean();
		
		
		try{
			touristServiceProvideHandler.addServiceProvider(addServiceProviderRequestBean);
	        baseResponse.setStatus("SUCCESS");
		
		}catch(BadRequestException e){
			
			baseResponse.setStatus(e.getMessage());
			
		}catch(DuplicateKeyException e){
			baseResponse.setStatus("FAILED : this service provider already exists ");
			
		}	
		catch(Exception e){
			
			baseResponse.setStatus("Transaction fails"+e.getMessage());
			
		}
		return baseResponse;
		
		
		
		
	}
	
	public BaseResponse getTouristServicesByTitle(String title){
		
		GetTouristServiceResponseBean  baseResponse = new GetTouristServiceResponseBean();
		
		try{
			baseResponse.setGetTouristServiceQueryResponseBean(touristServiceHandler.getTouristServiceByTitle(title)); ;
	        baseResponse.setStatus("SUCCESS");
		
		}catch(BadRequestException e){
			baseResponse.setStatus(e.getMessage());
			
		}catch(Exception e){
			baseResponse.setStatus("Transaction fails"+e.getMessage());
			
		}
		return baseResponse;
		
	}
	
	public BaseResponse getAllTouristServices(){
		GetTouristServiceResponseBean  baseResponse = new GetTouristServiceResponseBean();
		try{
			baseResponse.setGetTouristServiceQueryResponseBean(touristServiceHandler.getAllTouristServices());
	        baseResponse.setStatus("SUCCESS");
		
		}catch(Exception e){
			
			baseResponse.setStatus("Transaction fails"+e.getMessage());
		}
		return baseResponse;
	}

	public BaseResponse addTouristServiceComment(ServiceRatingCommentBean comment) {
		BaseResponse baseResponse = new BaseResponse();
		try {
			touristServiceHandler.addServiceComment(comment);
			baseResponse.setStatus("SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponse;
	}

	public BaseResponse getAllServiceComments(ServiceCommentRequestBean comment) {
		TouristServiceCommentsResponse baseResponse = new TouristServiceCommentsResponse();
		try {
			baseResponse = touristServiceHandler.getAllServiceComments(comment.getServiceId());
			baseResponse.setStatus("SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponse;
	}



}
