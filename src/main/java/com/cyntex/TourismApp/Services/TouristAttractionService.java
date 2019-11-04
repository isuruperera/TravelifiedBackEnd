package com.cyntex.TourismApp.Services;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Logic.TouristAttractionRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristAttractionService {
	
	
	
	@Autowired
	TouristAttractionRequestHandler touristAttractionRequestHandler;
	
	public BaseResponse discoverTouristAttraction(DiscoverTouristAttractionRequestBean discoverTouristAttractionRequestBean) throws Exception{
		DiscoverTouristAttractionPlaceResponseBean baseResponse= new DiscoverTouristAttractionPlaceResponseBean();
		try{
			baseResponse.setDiscoverTouristAttractionPlaceQueryResponseBean(touristAttractionRequestHandler.getTouristAttraction(discoverTouristAttractionRequestBean));
	        baseResponse.setStatus("SUCCESS");
		}catch(BadRequestException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return baseResponse;
		
	
	
	
	}
	
	
	
	
	
	// adding tourist Attraction

	public BaseResponse addTouristAttraction(AddTouristAttractionRequestBean addTouristAttractionRequestBean ) throws Exception{
		AddTouristAttractionResponseBean baseResponse= new AddTouristAttractionResponseBean();
	
	try{
		touristAttractionRequestHandler.addTouristAttraction(addTouristAttractionRequestBean);
        baseResponse.setStatus("SUCCESS");
	
	}catch(BadRequestException e){
		
		baseResponse.setStatus(e.getMessage());
		
	}catch(Exception e){
		
		baseResponse.setStatus("Transaction fails"+e.getMessage());
		
	}
	return baseResponse;
	}
}
