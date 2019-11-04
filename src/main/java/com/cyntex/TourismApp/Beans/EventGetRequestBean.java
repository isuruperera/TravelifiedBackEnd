package com.cyntex.TourismApp.Beans;

public class EventGetRequestBean extends BaseResponse {
    private String eventId;
    private String userId;

    public EventGetRequestBean(String eventId) {
        this.setEventId(eventId);
    }

    public EventGetRequestBean() {

    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
