package pucrs.jvzmarmentini.registration.business.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;

@Repository
public interface IMeetingRepository {
    Meeting newMeeting(Meeting newMeeting);

    List<Meeting> allMeetings();
}
