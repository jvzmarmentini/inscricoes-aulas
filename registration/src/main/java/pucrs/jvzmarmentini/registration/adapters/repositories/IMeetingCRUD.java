package pucrs.jvzmarmentini.registration.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.MeetingID;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

public interface IMeetingCRUD extends JpaRepository<Meeting, MeetingID> {
}
