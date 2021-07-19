package pucrs.jvzmarmentini.registration.application.usecase;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.services.ServiceStudent;

@Component
public class QuerySubscriberStudentUC {

    private ServiceStudent servStud;

    @Autowired
    public QuerySubscriberStudentUC(ServiceStudent servStud) {
        this.servStud = servStud;
    }

    public Set<Meeting> run(Integer reg) {
        return servStud.getMeetings(reg);
    }

}
