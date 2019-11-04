package com.cyntex.TourismApp.Beans;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DiscoverTouristAttractionPlaceResponseBean extends BaseResponse{
    @JsonProperty("attractions")
    private List<DiscoverTouristAttractionPlaceQueryResponseBean> discoverTouristAttractionPlaceQueryResponseBean;

	public List<DiscoverTouristAttractionPlaceQueryResponseBean> getDiscoverTouristAttractionPlaceQueryResponseBean() {
		return discoverTouristAttractionPlaceQueryResponseBean;
	}

	public void setDiscoverTouristAttractionPlaceQueryResponseBean(
			List<DiscoverTouristAttractionPlaceQueryResponseBean> discoverTouristAttractionPlaceQueryResponseBean) {
		this.discoverTouristAttractionPlaceQueryResponseBean = discoverTouristAttractionPlaceQueryResponseBean;
	}



}
