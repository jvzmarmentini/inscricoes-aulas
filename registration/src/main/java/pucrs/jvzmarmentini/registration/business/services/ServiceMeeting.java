package pucrs.jvzmarmentini.registration.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.repositories.IMeetingRepository;

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
}
