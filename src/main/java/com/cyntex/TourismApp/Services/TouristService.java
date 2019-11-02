package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.AddServiceProviderRequestBean;
import com.cyntex.TourismApp.Beans.AddServiceProviderResponseBean;
import com.cyntex.TourismApp.Beans.AddTouristServiceRequestBean;
import com.cyntex.TourismApp.Beans.AddTouristServiceResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.GetTouristServiceResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Logic.TouristServiceHandler;
import com.cyntex.TourismApp.Logic.TouristServiceProvideHandler;


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



}
