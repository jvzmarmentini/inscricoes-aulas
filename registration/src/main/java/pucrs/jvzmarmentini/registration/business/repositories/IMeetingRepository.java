package pucrs.jvzmarmentini.registration.business.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.Student;

@Repository
public interface IMeetingRepository {
    Meeting newMeeting(Meeting newMeeting);

    List<Meeting> allMeetings();

    Meeting allMeetings(String codcred, Integer classNum);

    List<Student> getStudents(String codcred, Integer classNum);

    Meeting subscribeStudent(String codcred, Integer classNum, Student stud);
}
