package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendRequestBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendResponseBean;
import com.cyntex.TourismApp.Beans.SearchFriendResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Logic.DiscoverTouristFriendRequestHandler;
import com.cyntex.TourismApp.Logic.SearchFriendRequestHandler;

@Service
public class TouristFriendService {
	@Autowired
	private DiscoverTouristFriendRequestHandler discoverTouristFriendRequestHandler;
	
	@Autowired
	private SearchFriendRequestHandler searchFriendRequestHandler;
	
	public BaseResponse discoverTouristFriend(DiscoverTouristFriendRequestBean discoverTouristFriendRequestBean){
		
		  DiscoverTouristFriendResponseBean baseResponse= new DiscoverTouristFriendResponseBean();
		 
		  
	  try{
		  baseResponse.setUserProfiles(discoverTouristFriendRequestHandler.discoverTouristFriend(discoverTouristFriendRequestBean));
		  baseResponse.setStatus("SUCCESS");

		}catch(BadRequestException e){
			
		  baseResponse.setStatus(e.getMessage());
			
		}	
		catch(Exception e){
			
		  baseResponse.setStatus("Transaction fails "+e.getMessage());
			
		}
	  return baseResponse;
	}
	
	
	public BaseResponse searchFriend(String fullname){
		
		SearchFriendResponseBean baseResponse= new SearchFriendResponseBean();
		try{
			
			baseResponse.setSearchFriendQueryResponseBean(searchFriendRequestHandler.handle(fullname));
		    baseResponse.setStatus("SUCCESS");
		}catch(BadRequestException e){
			baseResponse.setStatus(e.getMessage());	
		}
		catch(Exception e){	
			baseResponse.setStatus("Transaction fails"+e.getMessage());
			
		}
		return baseResponse;
		
	}
}
