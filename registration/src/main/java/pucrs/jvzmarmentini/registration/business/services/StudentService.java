package pucrs.jvzmarmentini.registration.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pucrs.jvzmarmentini.registration.business.entities.Student;
import pucrs.jvzmarmentini.registration.business.repositories.IStudentRepository;

@Service
public class StudentService {

    private final IStudentRepository studRepo;

    @Autowired
    public StudentService(IStudentRepository studRepo) {
        this.studRepo = studRepo;
    }

    public List<Student> allStudents() {
        return studRepo.findAll();
    }

    public Student newStudent(Student newStudent) {
        return studRepo.save(newStudent);
    }

    public Student oneById(Integer reg) {
        return studRepo.findById(reg).orElseThrow(() -> new StudentNotFoundException(reg));
    }

    public Student oneByName(String name) {
        // TODO
        return null;
    }

    public Student replaceStudent(Student newStudent, Integer reg) {
        return studRepo.findById(reg).map(student -> {
            student.setReg(newStudent.getReg());
            student.setName(newStudent.getName());
            return studRepo.save(student);
        }).orElseGet(() -> {
            newStudent.setReg(reg);
            return studRepo.save(newStudent);
        });
    }

    public boolean deleteStudent(Integer reg) {
        try {
            studRepo.deleteById(reg);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
