package pucrs.jvzmarmentini.registration.adapters.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.MeetingID;
import pucrs.jvzmarmentini.registration.business.entities.Student;
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

    @Override
    public Meeting allMeetings(String codcred, Integer classNum) {
        MeetingID id = new MeetingID(codcred, classNum);
        return meetCRUD.findById(id).orElseThrow();
    }

    @Override
    public Set<Student> getStudents(String codcred, Integer classNum) {
        MeetingID id = new MeetingID(codcred, classNum);
        return meetCRUD.findById(id).get().getRegistereds();
    }

    @Override
    public Meeting subscribeStudent(String codcred, Integer classNum, Student stud) {
        Meeting meeting = meetCRUD.findById(new MeetingID(codcred, classNum)).get();
        try {
            return meetCRUD.save(meeting.addRegistered(stud));
        } catch (Exception e) {
            e.printStackTrace();
            return meeting;
        }
    }

}
