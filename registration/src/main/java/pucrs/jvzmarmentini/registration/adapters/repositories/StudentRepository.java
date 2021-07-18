package pucrs.jvzmarmentini.registration.adapters.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.Student;
import pucrs.jvzmarmentini.registration.business.repositories.IStudentRepository;

@Component
public class StudentRepository implements IStudentRepository {

    private IStudentCRUD studCRUD;

    @Autowired
    public StudentRepository(IStudentCRUD studCRUD) {
        this.studCRUD = studCRUD;
    }

    @Override
    public List<Student> allStudents() {
        return studCRUD.findAll();
    }

    @Override
    public Student allStudents(Integer reg) {
        return studCRUD.findAll().stream().filter(student -> student.getReg().equals(reg)).findFirst().orElseThrow();
    }

    @Override
    public Student allStudents(String name) {
        return studCRUD.findAll().stream().filter(student -> student.getName().equals(name)).findFirst().orElseThrow();
    }

    @Override
    public Student newStudent(Student newStudent) {
        return studCRUD.save(newStudent);
    }

    @Override
    public Student replaceStudent(Student newStudent, Integer reg) {
        return studCRUD.findById(reg).map(student -> {
            student.setReg(newStudent.getReg());
            student.setName(newStudent.getName());
            return studCRUD.save(student);
        }).orElseGet(() -> {
            newStudent.setReg(reg);
            return studCRUD.save(newStudent);
        });
    }

    @Override
    public boolean deleteStudent(Integer reg) {
        try {
            studCRUD.deleteById(reg);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public List<Meeting> getMeetings(Integer reg) {
        return studCRUD.findById(reg).get().getRegisteredMeetings();
    }

    @Override
    public void subscribeMeeting(Meeting meet, Integer reg) {
        studCRUD.findById(reg).get().addRegisteredMeeting(meet);
    }

}
