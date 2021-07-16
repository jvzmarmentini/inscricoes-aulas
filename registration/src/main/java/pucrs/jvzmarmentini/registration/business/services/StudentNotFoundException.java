package pucrs.jvzmarmentini.registration.business.services;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Integer reg) {
        super("Could not find student " + reg);
    }
}
