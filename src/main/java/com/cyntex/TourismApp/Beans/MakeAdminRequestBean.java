package com.cyntex.TourismApp.Beans;

public class MakeAdminRequestBean {
	
	private String username;    //  user want to be an admin
	private int groupId;
	private String adminname;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	
	

}
