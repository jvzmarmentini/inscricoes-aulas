package pucrs.jvzmarmentini.registration.application.dto;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

public class SubscribersTotalDTO {

    private int totalSubscribers;

    public SubscribersTotalDTO(int totalSubscribers) {
        this.totalSubscribers = totalSubscribers;
    }

    public int getTotalSubscribers() {
        return totalSubscribers;
    }
}
