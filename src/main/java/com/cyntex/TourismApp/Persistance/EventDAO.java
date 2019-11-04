package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.EventParticipantBean;
import com.cyntex.TourismApp.Beans.EventResponseBean;
import com.cyntex.TourismApp.Beans.MyEventsBean;
import com.cyntex.TourismApp.Util.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class EventDAO {

    private String addEvent = "insert into tourist_event(event_id, event_title, event_description, title_photo_url, " +
            "event_time, created_by, lat, lng) values (?,?,?,?,?,?,?,?)";

    private String addParticipant = "insert into event_participation(username, event_id, state) values(?,?,?)";

    private String updateParticipation = "update event_participation set state = ? where username = ? and event_id = ?";

    private String getEvent = "select * from tourist_event, event_participation where tourist_event.event_id " +
            "= event_participation.event_id and tourist_event.event_id = ? and event_participation.username = ? and" +
            " tourist_event.is_active = '1'";

    private String getMyEvents = "select * from tourist_event where created_by = ? and tourist_event.is_active = '1'";

    private String allMyEvents = "select * from event_participation, tourist_event where event_participation.username" +
            " = ? and event_participation.event_id = tourist_event.event_id and tourist_event.is_active = '1'";

    private String eventParticipants = "select * from event_participation, user where event_participation.username = " +
            "user.username and event_participation.event_id = ? and user.is_active = '1'";

    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public void runAddEventQuery(String eventId, String eventTitle, String eventDescription,
                                 String eventTitlePhotoURL, long eventTime, String createdBy, double lat, double lng) {
        dataSourceManager.getJdbcTemplate().update(
                addEvent,
                new Object[]{eventId, eventTitle, eventDescription, eventTitlePhotoURL, eventTime, createdBy, lat, lng},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT, Types.VARCHAR,
                        Types.DOUBLE, Types.DOUBLE}
        );
    }

    @Transactional
    public void runAddParticipantQuery(String eventId, String userId, int state) {
        dataSourceManager.getJdbcTemplate().update(
                addParticipant,
                new Object[]{userId, eventId, state},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER}
        );
    }

    @Transactional
    public void runUpdateParticipantQuery(String eventId, String userId, int state) {
        dataSourceManager.getJdbcTemplate().update(
                updateParticipation,
                new Object[]{state, userId, eventId},
                new int[]{Types.INTEGER, Types.VARCHAR, Types.VARCHAR}
        );
    }

    @Transactional
    public List<EventResponseBean> getTouristEventQuery(String eventId, String userId) {
        List<EventResponseBean> events =
                dataSourceManager.getJdbcTemplate().query(
                        getEvent, new Object[]{eventId, userId}, new int[]{Types.VARCHAR, Types.VARCHAR},
                        (rs, rowNum) -> new EventResponseBean(
                                rs.getString("event_id"),
                                rs.getString("created_by"),
                                rs.getString("event_title"),
                                rs.getString("title_photo_url"),
                                rs.getString("event_description"),
                                rs.getLong("event_time"),
                                rs.getDouble("lat"),
                                rs.getDouble("lng"),
                                rs.getInt("event_participation.state")
                        )
                );
        return events;
    }

    @Transactional
    public List<MyEventsBean> getMyEventsQuery(String userId) {
        List<MyEventsBean> events =
                dataSourceManager.getJdbcTemplate().query(
                        getMyEvents, new Object[]{userId}, new int[]{Types.VARCHAR},
                        (rs, rowNum) -> new MyEventsBean(
                                rs.getString("event_id"),
                                rs.getString("event_title"),
                                rs.getString("title_photo_url"),
                                rs.getString("event_description"),
                                rs.getInt("state")
                        )
                );
        return events;
    }

    @Transactional
    public List<MyEventsBean> getAllMyEventsQuery(String userId) {
        List<MyEventsBean> events =
                dataSourceManager.getJdbcTemplate().query(
                        allMyEvents, new Object[]{userId}, new int[]{Types.VARCHAR},
                        (rs, rowNum) -> new MyEventsBean(
                                rs.getString("event_id"),
                                rs.getString("event_title"),
                                rs.getString("title_photo_url"),
                                rs.getString("event_description"),
                                rs.getInt("event_participation.state")
                        )
                );
        return events;
    }

    @Transactional
    public List<EventParticipantBean> getEventParticipantsQuery(String eventId) {
        List<EventParticipantBean> events =
                dataSourceManager.getJdbcTemplate().query(
                        eventParticipants, new Object[]{eventId}, new int[]{Types.VARCHAR},
                        (rs, rowNum) -> new EventParticipantBean(
                                rs.getString("username"),
                                rs.getString("first_name") + " " + rs.getString("last_name"),
                                rs.getString("picture_link"),
                                rs.getString("event_participation.state")
                        )
                );
        return events;
    }
}
