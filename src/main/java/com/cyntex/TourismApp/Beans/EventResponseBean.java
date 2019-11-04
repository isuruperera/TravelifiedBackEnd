package com.cyntex.TourismApp.Beans;

import java.util.List;

public class EventResponseBean extends BaseResponse {
    private String description;
    private String photoURL;
    private String userId;
    private String userName;
    private String eventName;
    private long eventDate;
    private String eventId;
    private double latitude;
    private double longitude;
    private int state;
    private List<EventParticipantBean> eventParticipants;

    public EventResponseBean(String eventId, String userId, String eventName, String photoURL, String description,
                             long eventDate,
                             double lat, double lng, int state) {
        this.userId = userId;
        this.photoURL = photoURL;
        this.description = description;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.latitude = lat;
        this.longitude = lng;
        this.eventId = eventId;
        this.setState(state);
    }

    public EventResponseBean() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<EventParticipantBean> getEventParticipants() {
        return eventParticipants;
    }

    public void setEventParticipants(List<EventParticipantBean> eventParticipants) {
        this.eventParticipants = eventParticipants;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
