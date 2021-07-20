package pucrs.jvzmarmentini.registration.application.usecase;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.entities.Student;
import pucrs.jvzmarmentini.registration.business.services.ServiceMeeting;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@Component
public class QuerySubscriberMeetingUC {

    private ServiceMeeting servMeet;

    @Autowired
    public QuerySubscriberMeetingUC(ServiceMeeting servMeet) {
        this.servMeet = servMeet;
    }

    public Set<Student> run(String codcred, Integer classNum) {
        return servMeet.getStudents(codcred, classNum);
    }

}
