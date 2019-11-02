package com.cyntex.TourismApp.Beans;

public class DiscoverTouristAttractionQueryResponseBean {
	private int  attraction_id;
	private double longitude;
	private double latitude;
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public int getAttraction_id() {
		return attraction_id;
	}
	public void setAttraction_id(int attraction_id) {
		this.attraction_id = attraction_id;
	}
	public DiscoverTouristAttractionQueryResponseBean(int attraction_id,
			double longitude, double latitude) {
		super();
		this.attraction_id = attraction_id;
		this.longitude = longitude;
		this.latitude = latitude;
	}


	
	

}
