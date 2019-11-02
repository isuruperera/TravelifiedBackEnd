package com.cyntex.TourismApp.Beans;

public class AddFriendToChatGroupRequestBean {
	private String username;
	private int chatGroupId;
	private String addedBy;

	
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getChatGroupId() {
		return chatGroupId;
	}
	public void setChatGroupId(int chatGroupId) {
		this.chatGroupId = chatGroupId;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	
	

}
