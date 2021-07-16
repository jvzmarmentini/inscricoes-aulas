package pucrs.jvzmarmentini.registration.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.business.services.ServiceStudent;

@Component
public class DeleteStudentUC {

    private ServiceStudent servStud;

    @Autowired
    public DeleteStudentUC(ServiceStudent servStud) {
        this.servStud = servStud;
    }

    public boolean run(Integer reg) {
        return servStud.deleteStudent(reg);
    }

}
