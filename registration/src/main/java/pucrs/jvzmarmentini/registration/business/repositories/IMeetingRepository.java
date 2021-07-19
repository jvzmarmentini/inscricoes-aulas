package pucrs.jvzmarmentini.registration.business.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.Student;

@Repository
public interface IMeetingRepository {
    Meeting newMeeting(Meeting newMeeting);

    List<Meeting> allMeetings();

    Meeting allMeetings(String codcred, Integer classNum);

    Set<Student> getStudents(String codcred, Integer classNum);

    void subscribeStudent(String codcred, Integer classNum, Student stud);
}
