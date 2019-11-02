package com.cyntex.TourismApp.Beans;

import java.util.Date;

public class GetUserChatGroupQueryResponseBean {
	
	private int groupId;
	private String title;
	private String category;
	private Date createdDate;
	
	
	
	
	public GetUserChatGroupQueryResponseBean(int groupId, String title,
			String category, Date createdDate) {
		super();
		this.groupId = groupId;
		this.title = title;
		this.category = category;
		this.createdDate = createdDate;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	

}
