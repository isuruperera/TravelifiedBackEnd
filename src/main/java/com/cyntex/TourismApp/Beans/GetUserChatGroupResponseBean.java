package com.cyntex.TourismApp.Beans;

import java.util.List;

public class GetUserChatGroupResponseBean extends BaseResponse{

	private List<GetUserChatGroupQueryResponseBean> userChatGroupList;

	public List<GetUserChatGroupQueryResponseBean> getUserChatGroupList() {
		return userChatGroupList;
	}

	public void setUserChatGroupList(
			List<GetUserChatGroupQueryResponseBean> userChatGroupList) {
		this.userChatGroupList = userChatGroupList;
	}
	
	
	
	
	
	
}
