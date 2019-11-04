package com.cyntex.TourismApp.Beans;

import java.time.LocalDate;
import java.util.Date;

public class SendMessageQueryResponsBean {

	private int _id; // auto increment id
//	private int userId; // Relevant to chat group to identify the user
	//private int chatId; // id of the chat group to identify the chat
	private String text;
	private Date createdAt;
	private ChatUserBean user;
	
	
	
	
	public SendMessageQueryResponsBean(int _id, String text, Date createdAt,
			ChatUserBean user) {
		super();
		this._id = _id;
		this.text = text;
		this.createdAt = createdAt;
		this.user = user;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public ChatUserBean getUser() {
		return user;
	}
	public void setUser(ChatUserBean user) {
		this.user = user;
	}
	 

	
	
}
