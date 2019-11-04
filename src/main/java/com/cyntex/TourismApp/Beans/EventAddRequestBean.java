package com.cyntex.TourismApp.Beans;

public class EventAddRequestBean {
    private String description;
    private String photo;
    private String userId;
    private String eventName;
    private long eventDate;
    private double longitude;
    private double latitude;

    public EventAddRequestBean(String userId, String eventName, String photo, String description, long eventDate) {
        this.userId = userId;
        this.photo = photo;
        this.description = description;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public EventAddRequestBean() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getEventDate() {
        return eventDate;
    }

    public void setEventDate(long eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
