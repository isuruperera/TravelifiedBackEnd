package com.cyntex.TourismApp.Beans;

import java.util.List;

public class DiscoverTouristAttractionPlaceResponseBean extends BaseResponse{
	private List<DiscoverTouristAttractionPlaceQueryResponseBean> discoverTouristAttractionPlaceQueryResponseBean;

	public List<DiscoverTouristAttractionPlaceQueryResponseBean> getDiscoverTouristAttractionPlaceQueryResponseBean() {
		return discoverTouristAttractionPlaceQueryResponseBean;
	}

	public void setDiscoverTouristAttractionPlaceQueryResponseBean(
			List<DiscoverTouristAttractionPlaceQueryResponseBean> discoverTouristAttractionPlaceQueryResponseBean) {
		this.discoverTouristAttractionPlaceQueryResponseBean = discoverTouristAttractionPlaceQueryResponseBean;
	}



}
