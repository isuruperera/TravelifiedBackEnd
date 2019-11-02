package com.cyntex.TourismApp.Beans;

import java.util.List;

public class GetTouristServiceResponseBean  extends BaseResponse {
	
	private List<GetTouristServiceQueryResponseBean> getTouristServiceQueryResponseBean;

	public List<GetTouristServiceQueryResponseBean> getGetTouristServiceQueryResponseBean() {
		return getTouristServiceQueryResponseBean;
	}

	public void setGetTouristServiceQueryResponseBean(
			List<GetTouristServiceQueryResponseBean> getTouristServiceQueryResponseBean) {
		this.getTouristServiceQueryResponseBean = getTouristServiceQueryResponseBean;
	}
	
	
	
	

}
