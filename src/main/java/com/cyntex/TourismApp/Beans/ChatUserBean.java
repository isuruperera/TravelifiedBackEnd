package com.cyntex.TourismApp.Beans;

public class ChatUserBean {
	private String _id; //Foreign key  
	private String name;
	//private String  avatar;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ChatUserBean(String _id, String name) {
		super();
		this._id = _id;
		this.name = name;
	}
	
	


	
	
	

}
