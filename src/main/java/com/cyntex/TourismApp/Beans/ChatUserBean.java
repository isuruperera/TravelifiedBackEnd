package com.cyntex.TourismApp.Beans;

public class ChatUserBean {
	private String username; //Foreign key  
	private String firstname;
	private String  avatar;
	
	

	public ChatUserBean(String username, String firstname, String avatar) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.avatar = avatar;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	
	

}
