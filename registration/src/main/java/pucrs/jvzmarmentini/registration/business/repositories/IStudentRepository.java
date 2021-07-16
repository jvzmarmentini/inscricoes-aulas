package pucrs.jvzmarmentini.registration.business.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pucrs.jvzmarmentini.registration.business.entities.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> allStudents();

    Student newStudent(Student newStudent);

    Student oneById(Integer reg);

    Student oneByName(String name);

    Student replaceStudent(Student newStudent, Integer reg);

    boolean deleteStudent(Integer reg);
}
