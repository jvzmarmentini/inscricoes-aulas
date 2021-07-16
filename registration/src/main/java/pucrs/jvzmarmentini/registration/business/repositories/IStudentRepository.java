package pucrs.jvzmarmentini.registration.business.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import pucrs.jvzmarmentini.registration.business.entities.Student;

@Repository
public interface IStudentRepository {
    List<Student> allStudents();

    Student allStudents(Integer reg);

    Student allStudents(String name);

    Student newStudent(Student newStudent);

    Student replaceStudent(Student newStudent, Integer reg);

    boolean deleteStudent(Integer reg);
}
