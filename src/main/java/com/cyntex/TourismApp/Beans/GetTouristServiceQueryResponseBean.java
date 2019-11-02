package com.cyntex.TourismApp.Beans;

import java.util.List;

public class GetTouristServiceQueryResponseBean {
	
	private int serviceId;	
	//private String addedBy;
	private String serviceTitle;	
	private String serviceDescription;	
	private String ownername;		
	private String titlePhoto;	
	private String photoCollectionId;	
	private String ratingProfileId;
	private List<String> photoUrlCollection;
	private double lng;
	private double lat;
	
	


	






	public GetTouristServiceQueryResponseBean(int serviceId,
			String serviceTitle, String serviceDescription, String ownername,
			String titlePhoto, String photoCollectionId,
			String ratingProfileId, double lng, double lat) {
		super();
		this.serviceId = serviceId;
		this.serviceTitle = serviceTitle;
		this.serviceDescription = serviceDescription;
		this.ownername = ownername;
		this.titlePhoto = titlePhoto;
		this.photoCollectionId = photoCollectionId;
		this.ratingProfileId = ratingProfileId;
		this.lng = lng;
		this.lat = lat;
	}


	public List<String> getPhotoUrlCollection() {
		return photoUrlCollection;
	}


	public void setPhotoUrlCollection(List<String> photoUrlCollection) {
		this.photoUrlCollection = photoUrlCollection;
	}


	public String getPhotoCollectionId() {
		return photoCollectionId;
	}
	public void setPhotoCollectionId(String photoCollectionId) {
		this.photoCollectionId = photoCollectionId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
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
	public String getTitlePhoto() {
		return titlePhoto;
	}
	public void setTitlePhoto(String titlePhoto) {
		this.titlePhoto = titlePhoto;
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
