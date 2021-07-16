package pucrs.jvzmarmentini.registration;

public class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(String name) {
        super("Could not find student " + name);
    }
}
