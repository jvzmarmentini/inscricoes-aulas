package pucrs.jvzmarmentini.registration.business.services;

import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.repositories.IMeetingRepository;

import pucrs.jvzmarmentini.registration.business.entities.Student;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@Service
public class ServiceMeeting {

    private final IMeetingRepository meetRepo;

    @Autowired
    public ServiceMeeting(IMeetingRepository meetRepo) {
        this.meetRepo = meetRepo;
    }

    public Meeting newMeeting(Meeting newMeeting) {
        return meetRepo.newMeeting(newMeeting);
    }

    public List<Meeting> allMeetings() {
        return meetRepo.allMeetings();
    }

    public Meeting allMeetings(String codcred, Integer classNum) {
        return meetRepo.allMeetings(codcred, classNum);
    }

    public Set<Student> getStudents(String codcred, Integer classNum) {
        return meetRepo.getStudents(codcred, classNum);
    }

    public Meeting subscribeStudent(String codcred, Integer classNum, Student stud) {
        return meetRepo.subscribeStudent(codcred, classNum, stud);
    }
}
