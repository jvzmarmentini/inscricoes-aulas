package pucrs.jvzmarmentini.registration.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.services.ServiceStudent;
import pucrs.jvzmarmentini.registration.business.entities.Student;

@Component
public class UpdateStudentUC {

    private ServiceStudent servStud;

    @Autowired
    public UpdateStudentUC(ServiceStudent servStud) {
        this.servStud = servStud;
    }

    public Student run(Student newStudent, Integer reg) {
        return servStud.replaceStudent(newStudent, reg);
    }

}
