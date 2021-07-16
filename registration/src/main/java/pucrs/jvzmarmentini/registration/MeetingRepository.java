package pucrs.jvzmarmentini.registration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, MeetingID> {
}
