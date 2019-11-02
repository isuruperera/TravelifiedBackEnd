package com.cyntex.TourismApp.Beans;

import java.util.List;

public class DiscoverTouristAttractionPlaceQueryResponseBean {
	private int attaractionId;
	private double latitude;
	private double longitude;
	private String attractionName;
	private String description;
	private String titlePhotoUrl;
	private String photoCollectionId;	
	private List<String> photoUrlCollection;
	


	public DiscoverTouristAttractionPlaceQueryResponseBean(int attaractionId,
			double latitude, double longitude, String attractionName,
			String description, String titlePhotoUrl, String photoCollectionId) {
		super();
		this.attaractionId = attaractionId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.attractionName = attractionName;
		this.description = description;
		this.titlePhotoUrl = titlePhotoUrl;
		this.photoCollectionId = photoCollectionId;
	}

	
	
	
	public double getLatitude() {
		return latitude;
	}
	public String getPhotoCollectionId() {
		return photoCollectionId;
	}
	public void setPhotoCollectionId(String photoCollectionId) {
		this.photoCollectionId = photoCollectionId;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getAttaractionId() {
		return attaractionId;
	}
	public void setAttaractionId(int attaractionId) {
		this.attaractionId = attaractionId;
	}
	public String getAttractionName() {
		return attractionName;
	}
	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitlePhotoUrl() {
		return titlePhotoUrl;
	}
	public void setTitlePhotoUrl(String titlePhotoUrl) {
		this.titlePhotoUrl = titlePhotoUrl;
	}
	public List<String> getPhotoUrlCollection() {
		return photoUrlCollection;
	}
	public void setPhotoUrlCollection(List<String> photoUrlCollection) {
		this.photoUrlCollection = photoUrlCollection;
	}
	


	

}
