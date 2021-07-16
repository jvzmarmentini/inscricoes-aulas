package pucrs.jvzmarmentini.registration.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.MeetingID;

public interface IMeetingCRUD extends JpaRepository<Meeting, MeetingID> {
}
