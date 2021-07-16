package pucrs.jvzmarmentini.registration.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.services.ServiceMeeting;

@Component
public class RegisterMeetingUC {

    private ServiceMeeting servMeet;

    @Autowired
    public RegisterMeetingUC(ServiceMeeting servMeet) {
        this.servMeet = servMeet;
    }

    public Meeting run(Meeting newMeeting) {
        return servMeet.newMeeting(newMeeting);
    }

}