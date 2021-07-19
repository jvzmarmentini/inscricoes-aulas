package pucrs.jvzmarmentini.registration.application.dto;

public class SubscribersNamesDTO {

    private String studentName;

    public SubscribersNamesDTO(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }
}
