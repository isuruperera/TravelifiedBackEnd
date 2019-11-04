package com.cyntex.TourismApp.Beans;

import java.util.List;

public class EventParticipantFriendsResponseBean extends BaseResponse {
    private List<GetUserFriendQueryResponse> eventParticipants;

    public EventParticipantFriendsResponseBean() {

    }

    public List<GetUserFriendQueryResponse> getEventParticipants() {
        return eventParticipants;
    }

    public void setEventParticipants(List<GetUserFriendQueryResponse> eventParticipants) {
        this.eventParticipants = eventParticipants;
    }
}
