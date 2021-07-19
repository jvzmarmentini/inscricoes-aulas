package pucrs.jvzmarmentini.registration.application.dto;

import java.util.HashSet;
import java.util.Set;

import pucrs.jvzmarmentini.registration.business.entities.Student;

public class StudentsNamesDTO {

    private Set<Student> names;

    public StudentsNamesDTO() {
        this.names = new HashSet<Student>();
    }

    public StudentsNamesDTO(Set<Student> names) {
        this.names = names;
    }

    public Set<Student> getNames() {
        return names;
    }
}
