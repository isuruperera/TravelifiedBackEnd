package com.cyntex.TourismApp.Beans;

public class EventParticipantBean {

    private String username;
    private String fullname;
    private String imageID;
    private String status;


    public EventParticipantBean(String username, String fullname, String imageID, String status) {
        super();
        this.username = username;
        this.fullname = fullname;
        this.setImageID(imageID);
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
