package com.cyntex.TourismApp.Beans;

public class EventGetMyEventsRequestBean extends BaseResponse {
    private String userId;

    public EventGetMyEventsRequestBean(String userId) {
        this.setUserId(userId);
    }

    public EventGetMyEventsRequestBean() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
