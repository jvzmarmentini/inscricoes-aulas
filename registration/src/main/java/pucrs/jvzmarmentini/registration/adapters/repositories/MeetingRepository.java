package pucrs.jvzmarmentini.registration.adapters.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.repositories.IMeetingRepository;

@Component
public class MeetingRepository implements IMeetingRepository {

    private IMeetingCRUD meetCRUD;

    @Autowired
    public MeetingRepository(IMeetingCRUD meetCRUD) {
        this.meetCRUD = meetCRUD;
    }

    @Override
    public Meeting newMeeting(Meeting newMeeting) {
        return meetCRUD.save(newMeeting);
    }

    @Override
    public List<Meeting> allMeetings() {
        return meetCRUD.findAll();
    }

}
