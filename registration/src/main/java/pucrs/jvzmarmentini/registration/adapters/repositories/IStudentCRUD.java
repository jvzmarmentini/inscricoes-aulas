package pucrs.jvzmarmentini.registration.adapters.repositories;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pucrs.jvzmarmentini.registration.business.entities.Student;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

public interface IStudentCRUD extends JpaRepository<Student, Integer> {
}
