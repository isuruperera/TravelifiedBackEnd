package com.cyntex.TourismApp.Beans;

public class RatingProfileFetchQueryBasedOnCategoryBean {
	public RatingProfileFetchQueryBasedOnCategoryBean(String userName) {
		this.userName = userName;
	}

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
