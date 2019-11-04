package com.cyntex.TourismApp.Beans;

import java.util.List;

public class MyEventInvitationsResponseBean extends BaseResponse {
    private List<MyEventsBean> events;

    public List<MyEventsBean> getEvents() {
        return events;
    }

    public void setEvents(List<MyEventsBean> events) {
        this.events = events;
    }
}
