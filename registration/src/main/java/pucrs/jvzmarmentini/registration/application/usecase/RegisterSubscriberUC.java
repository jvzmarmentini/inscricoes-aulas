package pucrs.jvzmarmentini.registration.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.Student;
import pucrs.jvzmarmentini.registration.business.services.ServiceMeeting;
import pucrs.jvzmarmentini.registration.business.services.ServiceStudent;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@Component
public class RegisterSubscriberUC {

    private ServiceStudent servStud;
    private ServiceMeeting servMeet;

    @Autowired
    public RegisterSubscriberUC(ServiceStudent servStud, ServiceMeeting servMeet) {
        this.servStud = servStud;
        this.servMeet = servMeet;
    }

    public Meeting run(String codcred, Integer classNum, Integer reg) {
        return servMeet.subscribeStudent(codcred, classNum, servStud.allStudents(reg));
    }

    public Student run(Integer reg, String codcred, Integer classNum) {
        return servStud.subscribeMeeting(servMeet.allMeetings(codcred, classNum), reg);
    }

    public Meeting run(String codcred, Integer classNum, String name) {
        return servMeet.subscribeStudent(codcred, classNum, servStud.allStudents(name));
    }

    public Student run(String name, String codcred, Integer classNum) {
        return servStud.subscribeMeeting(servMeet.allMeetings(codcred, classNum), servStud.allStudents(name).getReg());
    }
}
