package pucrs.jvzmarmentini.registration.business.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.MeetingID;

@Repository
public interface IMeetingRepository extends JpaRepository<Meeting, MeetingID> {
    Meeting newMeeting(Meeting newMeeting);

    List<Meeting> allMeetings();
}
