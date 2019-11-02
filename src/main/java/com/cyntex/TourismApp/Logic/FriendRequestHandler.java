package com.cyntex.TourismApp.Logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.web.firewall.FirewalledRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.AddFriendRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.GetUserFriendQueryResponse;
import com.cyntex.TourismApp.Beans.GetUserFriendRequest;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Persistance.FriendListDAO;




@Component
public class FriendRequestHandler {
	
	@Autowired
	FriendListDAO friendListDAO;
	
	@Transactional(rollbackFor= Exception.class, timeout=120)
	public void addTouristFriend(AddFriendRequestBean addFriendRequestBean) throws Exception{
		String username=addFriendRequestBean.getUserName();
		String friendname=addFriendRequestBean.getFriendName();
			
			if(!(StringUtils.isEmpty(username) || StringUtils.isEmpty(friendname))){
			friendListDAO.addFriend(username, friendname);
			
			}else{
				throw new BadRequestException("FAILED: Check the payload again");
			}
			
	
	}
	@Transactional(rollbackFor= Exception.class , timeout=120)
	public List<GetUserFriendQueryResponse> getUserFriend(GetUserFriendRequest getUserFriendRequest )throws Exception{
		String username=getUserFriendRequest.getUsername();
		
		if(!StringUtils.isEmpty(username)){
			return friendListDAO.getFriend(username);
			
		}else{
			throw new BadRequestException("FAILED: Check the payload again");
		}
		
		
		
	}
}
