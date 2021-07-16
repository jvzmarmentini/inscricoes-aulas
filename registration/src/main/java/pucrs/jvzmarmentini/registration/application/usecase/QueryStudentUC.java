package pucrs.jvzmarmentini.registration.application.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.services.ServiceStudent;
import pucrs.jvzmarmentini.registration.business.entities.Student;

@Component
public class QueryStudentUC {

    private ServiceStudent servStud;

    @Autowired
    public QueryStudentUC(ServiceStudent servStud) {
        this.servStud = servStud;
    }

    public List<Student> run() {
        return servStud.allStudents();
    }

    public Student run(Integer reg) {
        return servStud.allStudents(reg);
    }

    public Student run(String name) {
        return servStud.allStudents(name);
    }
}
