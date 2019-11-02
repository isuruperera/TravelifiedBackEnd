package com.cyntex.TourismApp.Beans;

import java.util.List;

public class GetUserFriendResponse extends BaseResponse{
	private List<GetUserFriendQueryResponse> userFriendList;

	public List<GetUserFriendQueryResponse> getUserFriendList() {
		return userFriendList;
	}

	public void setUserFriendList(List<GetUserFriendQueryResponse> userFriendList) {
		this.userFriendList = userFriendList;
	}
	
	

}
