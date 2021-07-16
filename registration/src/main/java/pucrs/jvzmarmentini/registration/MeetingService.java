package pucrs.jvzmarmentini.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MeetingService {

    private final IMeetingRepository meetRepo;

    @Autowired
    public MeetingService(IMeetingRepository meetRepo) {
        this.meetRepo = meetRepo;
    }

    public Meeting newMeeting(Meeting newMeeting) {
        return meetRepo.save(newMeeting);
    }

    public List<Meeting> allMeetings() {
        return meetRepo.findAll();
    }
}
