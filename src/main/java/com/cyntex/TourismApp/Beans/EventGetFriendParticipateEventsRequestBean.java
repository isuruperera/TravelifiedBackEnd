package com.cyntex.TourismApp.Beans;

public class EventGetFriendParticipateEventsRequestBean extends BaseResponse {
    private String userId;
    private String eventId;

    public EventGetFriendParticipateEventsRequestBean(String userId) {
        this.setUserId(userId);
    }

    public EventGetFriendParticipateEventsRequestBean() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
