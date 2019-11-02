package com.cyntex.TourismApp.Beans;

import java.util.ArrayList;
import java.util.List;

public class SearchFriendResponseBean extends BaseResponse{
	private List<SearchFriendQueryResponseBean> searchFriendQueryResponseBean= new ArrayList();

	public List<SearchFriendQueryResponseBean> getSearchFriendQueryResponseBean() {
		return searchFriendQueryResponseBean;
	}

	public void setSearchFriendQueryResponseBean(
			List<SearchFriendQueryResponseBean> searchFriendQueryResponseBean) {
		this.searchFriendQueryResponseBean = searchFriendQueryResponseBean;
	}
	
	
	
	


}
