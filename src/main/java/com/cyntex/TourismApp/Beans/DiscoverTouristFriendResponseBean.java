package com.cyntex.TourismApp.Beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cyntex.TourismApp.Logic.DiscoverTouristFriendRequestHandler;

public class DiscoverTouristFriendResponseBean extends BaseResponse{
	
	private List<DiscoverTouristFriendUserProfileQueryResponseBean> userProfiles;

	public List<DiscoverTouristFriendUserProfileQueryResponseBean> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(
			List<DiscoverTouristFriendUserProfileQueryResponseBean> userProfiles) {
		this.userProfiles = userProfiles;
	}


	

}
