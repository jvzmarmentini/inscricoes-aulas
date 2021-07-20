package pucrs.jvzmarmentini.registration.business.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.Student;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@Repository
public interface IMeetingRepository {
    Meeting newMeeting(Meeting newMeeting);

    List<Meeting> allMeetings();

    Meeting allMeetings(String codcred, Integer classNum);

    Set<Student> getStudents(String codcred, Integer classNum);

    Meeting subscribeStudent(String codcred, Integer classNum, Student stud);
}
