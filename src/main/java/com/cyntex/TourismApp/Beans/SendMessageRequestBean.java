package com.cyntex.TourismApp.Beans;

import java.time.LocalDate;
import java.util.Date;

public class SendMessageRequestBean {
 
//	private int messageId; //this will be a auto increment  id
	private String username;
	private int groupId;
	private String message;
//	private Date createdDate;// this will be suppled by us when message save
	
	
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//	public int getMessageId() {
//		return messageId;
//	}
//	public void setMessageId(int messageId) {
//		this.messageId = messageId;
//	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	
	
	public int getGroupId() {
		return groupId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	



}