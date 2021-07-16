package pucrs.jvzmarmentini.registration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMeetingRepository extends JpaRepository<Meeting, MeetingID> {
    Meeting newMeeting(Meeting newMeeting);

    List<Meeting> allMeetings();
}
