package com.cyntex.TourismApp.Beans;

public class GetUserFriendQueryResponse {
	
	private String username;
	private String fullname;
    private String imageID;


    public GetUserFriendQueryResponse(String username, String fullname, String imageID) {
		super();
		this.username = username;
		this.fullname = fullname;
        this.setImageID(imageID);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
}
