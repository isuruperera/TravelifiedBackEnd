package com.cyntex.TourismApp.Beans;

public class AddTouristServiceRequestBean {
	
	
	//private int service_id	
	private String addedBy;
	private String serviceTitle;	
	private String serviceDescription;	
	private String ownername;	
	private String titlePhoto;	
	//private String photoCollectionId;	
	private String ratingProfileId;
	private String[] photoCollection;
	private double lng;
	private double lat;
	
	
	
	
	public String[] getPhotoCollection() {
		return photoCollection;
	}
	public void setPhotoCollection(String[] photoCollection) {
		this.photoCollection = photoCollection;
	}
	public String getTitlePhoto() {
		return titlePhoto;
	}
	public void setTitlePhoto(String titlePhoto) {
		this.titlePhoto = titlePhoto;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getRatingProfileId() {
		return ratingProfileId;
	}
	public void setRatingProfileId(String ratingProfileId) {
		this.ratingProfileId = ratingProfileId;
	}
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
	
	
	

}
