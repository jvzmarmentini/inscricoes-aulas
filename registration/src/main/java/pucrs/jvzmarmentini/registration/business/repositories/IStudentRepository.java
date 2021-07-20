package pucrs.jvzmarmentini.registration.business.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.Student;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@Repository
public interface IStudentRepository {
    List<Student> allStudents();

    Student allStudents(Integer reg);

    Student allStudents(String name);

    Student newStudent(Student newStudent);

    Student replaceStudent(Student newStudent, Integer reg);

    boolean deleteStudent(Integer reg);

    Set<Meeting> getMeetings(Integer reg);

    Student subscribeMeeting(Meeting meet, Integer reg);
}
