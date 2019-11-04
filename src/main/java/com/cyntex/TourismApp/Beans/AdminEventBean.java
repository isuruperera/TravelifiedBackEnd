package com.cyntex.TourismApp.Beans;

public class AdminEventBean {

    private String eventId;
    private String eventName;
    private String imageID;
    private int eventStatus;


    public AdminEventBean(String eventId, String eventName, String imageID, int eventStatus) {
        super();
        this.eventId = eventId;
        this.eventName = eventName;
        this.setImageID(imageID);
        this.setEventStatus(eventStatus);
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public int getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(int eventStatus) {
        this.eventStatus = eventStatus;
    }
}
