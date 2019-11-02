package com.cyntex.TourismApp.Logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.SearchFriendQueryResponseBean;
import com.cyntex.TourismApp.Beans.SearchFriendResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Persistance.UserDAO;


@Component
public class SearchFriendRequestHandler {
	
	@Autowired
	UserDAO userDAO;
	
	@Transactional(rollbackFor= Exception.class ,  timeout=120)
	public List<SearchFriendQueryResponseBean> handle(String firstname) throws Exception{
		
		 List<SearchFriendQueryResponseBean> friendList;
		if(!StringUtils.isEmpty(firstname)){		
			friendList=userDAO.getSearchFriend(firstname);
			
		}else{
			throw new BadRequestException("FAILED: Check the payload again");

		}

		return friendList;
		
		
		
	}

}
