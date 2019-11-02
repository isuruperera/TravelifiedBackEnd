package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.AddFriendRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.GetUserFriendRequest;
import com.cyntex.TourismApp.Beans.GetUserFriendResponse;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Logic.FriendRequestHandler;

@Service

public class UserFriendService {
	@Autowired
	FriendRequestHandler friendRequestHandler;
	
	public BaseResponse addTouristFriend(AddFriendRequestBean addFriendRequestBean){
		BaseResponse response= new BaseResponse();
		try{
		friendRequestHandler.addTouristFriend(addFriendRequestBean);
		response.setStatus("SUCCESS");
		
		}catch(DuplicateKeyException  e){
			response.setStatus("FAILED : "+"Friend is already added");
			
		}
		catch(BadRequestException e){
			response.setStatus(e.getMessage());
			
		}
		catch(Exception e){
			
			response.setStatus("FAILED : "+e.getMessage());
			
		}
		return response;
	}
	
	
	public BaseResponse getUserFriend(GetUserFriendRequest getUserFriendRequest){
		GetUserFriendResponse response= new GetUserFriendResponse();
		try{
		response.setUserFriendList(friendRequestHandler.getUserFriend(getUserFriendRequest));
		response.setStatus("SUCCESS");
		
		}catch(DuplicateKeyException  e){
			response.setStatus("FAILED : "+"Friend is already added");
			
		}
		catch(BadRequestException e){
			response.setStatus(e.getMessage());
			
		}
		catch(Exception e){
			
			response.setStatus("FAILED : "+e.getMessage());
			
		}
		return response;
		
	}

}
