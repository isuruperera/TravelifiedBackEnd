package com.cyntex.TourismApp.Beans;

import java.util.List;

public class ContactTouristGuideGetMessageResponseBean extends BaseResponse{
	
	private List<ContactTouristGuideGetMessageQueryResponseBean> responseList;

	public List<ContactTouristGuideGetMessageQueryResponseBean> getResponseList() {
		return responseList;
	}

	public void setResponseList(
			List<ContactTouristGuideGetMessageQueryResponseBean> responseList) {
		this.responseList = responseList;
	}
	
	
	

}
