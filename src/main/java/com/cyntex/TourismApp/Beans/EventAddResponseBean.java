package com.cyntex.TourismApp.Beans;

public class EventAddResponseBean extends BaseResponse {
    private String eventId;

    public EventAddResponseBean(String eventId) {
        this.setEventId(eventId);
    }

    public EventAddResponseBean() {

    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
