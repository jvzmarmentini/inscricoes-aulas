package pucrs.jvzmarmentini.registration;

public class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(Integer reg) {
        super("Could not find student " + reg);
    }
}
