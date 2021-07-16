package pucrs.jvzmarmentini.registration.application.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.services.ServiceMeeting;

@Component
public class QueryMeetingUC {

    private ServiceMeeting servMeet;

    @Autowired
    public QueryMeetingUC(ServiceMeeting servMeet) {
        this.servMeet = servMeet;
    }

    public List<Meeting> run() {
        return servMeet.allMeetings();
    }

}
