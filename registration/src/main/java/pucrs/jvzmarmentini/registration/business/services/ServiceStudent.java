package pucrs.jvzmarmentini.registration.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pucrs.jvzmarmentini.registration.business.entities.Student;
import pucrs.jvzmarmentini.registration.business.repositories.IStudentRepository;

@Service
public class ServiceStudent {

    private final IStudentRepository studRepo;

    @Autowired
    public ServiceStudent(IStudentRepository studRepo) {
        this.studRepo = studRepo;
    }

    public List<Student> allStudents() {
        return studRepo.allStudents();
    }

    public Student allStudents(Integer reg) {
        return studRepo.allStudents(reg);
        // .orElseThrow(() -> new StudentNotFoundException(reg));
    }

    public Student allStudents(String name) {
        // TODO
        return null;
    }

    public Student newStudent(Student newStudent) {
        return studRepo.newStudent(newStudent);
    }

    public Student replaceStudent(Student newStudent, Integer reg) {
        return replaceStudent(newStudent, reg);
    }

    public boolean deleteStudent(Integer reg) {
        return deleteStudent(reg);
    }
}