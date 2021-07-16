package pucrs.jvzmarmentini.registration.adapters.repositories;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pucrs.jvzmarmentini.registration.business.entities.Student;

public interface IStudentCRUD extends JpaRepository<Student, Integer> {
}
