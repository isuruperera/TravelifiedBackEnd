package com.cyntex.TourismApp.Beans;

public class AddTouristAttractionRequestBean {
	
	private String attractionName;
	private String description;
	private String ratingProfileId;
	private String titlePhoto;
	//private String photoCollectionId;
	private String[] photoCollection;
	private double lng;
	private double lat;
	
	
	

	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
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
	public String getRatingProfileId() {
		return ratingProfileId;
	}
	public void setRatingProfileId(String ratingProfileId) {
		this.ratingProfileId = ratingProfileId;
	}
	public String getTitlePhoto() {
		return titlePhoto;
	}
	public void setTitlePhoto(String titlePhoto) {
		this.titlePhoto = titlePhoto;
	}
	public String[] getPhotoCollection() {
		return photoCollection;
	}
	public void setPhotoCollection(String[] photoCollection) {
		this.photoCollection = photoCollection;
	}
	
	
	

}
