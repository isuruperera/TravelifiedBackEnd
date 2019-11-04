package com.cyntex.TourismApp.Beans;

public class AdminUserListBean {

    private String username;
    private String fullname;
    private String imageID;
    private int userStatus;


    public AdminUserListBean(String username, String fullname, String imageID, int userStatus) {
        super();
        this.username = username;
        this.fullname = fullname;
        this.setImageID(imageID);
        this.setUserStatus(userStatus);
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

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
}
