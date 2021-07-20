package pucrs.jvzmarmentini.registration;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 * 
 *                    This class wasnt used, but it will help for future changes
 */

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Integer reg) {
        super("Could not find student " + reg);
    }
}
