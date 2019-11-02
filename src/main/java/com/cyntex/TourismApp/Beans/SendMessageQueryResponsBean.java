package com.cyntex.TourismApp.Beans;

import java.time.LocalDate;
import java.util.Date;

public class SendMessageQueryResponsBean {

	private int messageId; // auto increment id
//	private int userId; // Relevant to chat group to identify the user
	//private int chatId; // id of the chat group to identify the chat
	private String message;
	private Date createdDate;
	private ChatUserBean senderDetails;
	 

	public SendMessageQueryResponsBean(int messageId, String message,
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
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public int getChatId() {
//		return chatId;
//	}
//	public void setChatId(int chatId) {
//		this.chatId = chatId;
//	}
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
