package com.cyntex.TourismApp.Beans;

public class DeleteChatGroupMemberRequestBean {
	private String username;
	private String deletedBy;
	private int chatGroupId;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}
	public int getChatGroupId() {
		return chatGroupId;
	}
	public void setChatGroupId(int chatGroupId) {
		this.chatGroupId = chatGroupId;
	}
	
	

}
