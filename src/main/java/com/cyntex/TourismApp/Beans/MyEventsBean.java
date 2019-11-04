package com.cyntex.TourismApp.Beans;

public class MyEventsBean {
    private String description;
    private String photoURL;
    private String eventName;
    private String eventId;
    private int state;

    public MyEventsBean(String eventId, String eventName, String photoURL, String description, int state) {
        this.setEventId(eventId);
        this.photoURL = photoURL;
        this.description = description;
        this.setEventName(eventName);
        this.state = state;
    }

    public MyEventsBean() {

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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

