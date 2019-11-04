package com.cyntex.TourismApp.Beans;

public class EventGetMyParticipateEventsRequestBean extends BaseResponse {
    private String userId;

    public EventGetMyParticipateEventsRequestBean(String userId) {
        this.setUserId(userId);
    }

    public EventGetMyParticipateEventsRequestBean() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
