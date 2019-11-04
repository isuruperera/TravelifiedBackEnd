package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Persistance.EventDAO;
import com.cyntex.TourismApp.Persistance.FriendListDAO;
import com.cyntex.TourismApp.Util.FSManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class EventRequestHandler {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private FriendListDAO friendListDAO;

    public EventAddResponseBean handle(EventAddRequestBean requestBean) {
        EventAddResponseBean eventAddResponseBean = new EventAddResponseBean();
        try {
            String imageID = UUID.randomUUID().toString();
            String eventId = UUID.randomUUID().toString();
            FSManager.saveImage(imageID, requestBean.getPhoto());
            eventDAO.runAddEventQuery(
                    eventId,
                    requestBean.getEventName(),
                    requestBean.getDescription(),
                    imageID,
                    requestBean.getEventDate(),
                    requestBean.getUserId(),
                    requestBean.getLatitude(),
                    requestBean.getLongitude()
            );
            eventDAO.runAddParticipantQuery(eventId, requestBean.getUserId(), 2);
            eventAddResponseBean.setEventId(eventId);
            eventAddResponseBean.setStatus("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventAddResponseBean;
    }


    public BaseResponse handle(EventParticipationRequestBean requestBean) {
        BaseResponse eventAddResponseBean = new BaseResponse();
        try {
            eventDAO.runAddParticipantQuery(
                    requestBean.getEventId(), requestBean.getUsername(), requestBean.getStatus()
            );
            eventAddResponseBean.setStatus("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventAddResponseBean;
    }

    public BaseResponse handle(EventParticipationUpdateRequestBean requestBean) {
        BaseResponse eventAddResponseBean = new BaseResponse();
        try {
            eventDAO.runUpdateParticipantQuery(
                    requestBean.getEventId(), requestBean.getUsername(), requestBean.getStatus()
            );
            eventAddResponseBean.setStatus("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventAddResponseBean;
    }

    public BaseResponse handle(EventGetRequestBean requestBean) {
        EventResponseBean eventAddResponseBean = new EventResponseBean();
        try {
            eventAddResponseBean = eventDAO.getTouristEventQuery(
                    requestBean.getEventId(), requestBean.getUserId()
            ).get(0);
            eventAddResponseBean.setEventParticipants(eventDAO.getEventParticipantsQuery(requestBean.getEventId()));
            eventAddResponseBean.setStatus("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventAddResponseBean;
    }

    public BaseResponse handle(EventGetMyEventsRequestBean requestBean) {
        MyEventsResponseBean eventAddResponseBean = new MyEventsResponseBean();
        try {
            List<MyEventsBean> myEventsQuery = eventDAO.getMyEventsQuery(
                    requestBean.getUserId()
            );
            eventAddResponseBean.setEvents(myEventsQuery);
            eventAddResponseBean.setStatus("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventAddResponseBean;
    }

    public BaseResponse handle(EventGetMyParticipateEventsRequestBean requestBean) {
        MyEventInvitationsResponseBean eventAddResponseBean = new MyEventInvitationsResponseBean();
        try {
            List<MyEventsBean> myEventsQuery = eventDAO.getAllMyEventsQuery(
                    requestBean.getUserId()
            );
            eventAddResponseBean.setEvents(myEventsQuery);
            eventAddResponseBean.setStatus("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventAddResponseBean;
    }

    public BaseResponse handle(EventGetFriendParticipateEventsRequestBean requestBean) {
        EventParticipantFriendsResponseBean eventAddResponseBean = new EventParticipantFriendsResponseBean();
        try {
            List<EventParticipantBean> eventParticipantBeans =
                    eventDAO.getEventParticipantsQuery(requestBean.getEventId());
            List<GetUserFriendQueryResponse> friends = friendListDAO.getFriend(requestBean.getUserId());
            List<GetUserFriendQueryResponse> selectedFriends = new ArrayList<>();

            for (GetUserFriendQueryResponse friend : friends) {
                boolean isFound = false;
                for (EventParticipantBean participant : eventParticipantBeans) {
                    if (participant.getUsername().equals(friend.getUsername())) {
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    selectedFriends.add(friend);
                }
            }
            eventAddResponseBean.setEventParticipants(selectedFriends);
            eventAddResponseBean.setStatus("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventAddResponseBean;
    }


}
