package com.cyntex.TourismApp.Beans;

import java.util.Date;

public class ContactTouristGuideGetMessageQueryResponseBean {
	
	private int messageId; // auto increment id
//	private int userId; // Relevant to chat group to identify the user
	//private int chatId; // id of the chat group to identify the chat
	private String message;
	private Date createdDate;
	private ChatUserBean senderDetails;
	 

	public ContactTouristGuideGetMessageQueryResponseBean(int messageId, String message,
			Date createdDate, ChatUserBean senderDetails) {
	
		this.messageId = messageId;
		this.message = message;
		this.createdDate = createdDate;
		this.senderDetails = senderDetails;
	}

	public ChatUserBean getSenderDetails() {
		return senderDetails;
	}

	public void setSenderDetails(ChatUserBean senderDetails) {
		this.senderDetails = senderDetails;
	}

	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
