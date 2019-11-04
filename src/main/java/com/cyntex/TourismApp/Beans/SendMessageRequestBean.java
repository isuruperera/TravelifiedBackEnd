package com.cyntex.TourismApp.Beans;

import java.time.LocalDate;
import java.util.Date;

public class SendMessageRequestBean {
 
//	private int messageId; //this will be a auto increment  id
	private String username;
	private int groupId;
	private String message;
//	private String firstname;
//	private Date createdDate;// this will be suppled by us when message save
	
	

	
	
	public int getGroupId() {
		return groupId;
	}
//	public String getFirstname() {
//		return firstname;
//	}
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
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