package pucrs.jvzmarmentini.registration.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.services.ServiceMeeting;
import pucrs.jvzmarmentini.registration.business.services.ServiceStudent;

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
        servStud.subscribeMeeting(servMeet.allMeetings(codcred, classNum), reg);
        return servMeet.subscribeStudent(codcred, classNum, servStud.allStudents(reg));
    }
}
