package pucrs.jvzmarmentini.registration.application.dto;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

public class SubscribersNamesDTO {

    private String studentName;

    public SubscribersNamesDTO(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }
}
