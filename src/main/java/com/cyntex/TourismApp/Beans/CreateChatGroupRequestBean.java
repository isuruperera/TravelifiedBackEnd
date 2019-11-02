package com.cyntex.TourismApp.Beans;

import java.util.Date;
import java.util.List;



public class CreateChatGroupRequestBean {
	
	//chat_group_id	group_title	category	created_by	created_date
	private List<String> selectedUsers;
	private int chatGroupId;
	private String groupTitle;
	private String category;
	private String createdBy;

	
	
	

	public List<String> getSelectedUsers() {
		return selectedUsers;
	}
	public void setSelectedUsers(List<String> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}
	//private Date createdDate;
	public int getChatGroupId() {
		return chatGroupId;
	}
	public void setChatGroupId(int chatGroupId) {
		this.chatGroupId = chatGroupId;
	}
	public String getGroupTitle() {
		return groupTitle;
	}
	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
