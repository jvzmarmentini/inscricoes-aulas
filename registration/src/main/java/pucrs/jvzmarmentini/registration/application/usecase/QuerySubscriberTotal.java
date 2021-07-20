package pucrs.jvzmarmentini.registration.application.usecase;

import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.application.dto.SubscribersTotalDTO;
import pucrs.jvzmarmentini.registration.application.services.ServicoSubscribers;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@Component
public class QuerySubscriberTotal {

    private ServicoSubscribers servSubs;

    public QuerySubscriberTotal(ServicoSubscribers servSubs) {
        this.servSubs = servSubs;
    }

    public SubscribersTotalDTO run(String codcred, Integer classNum) {
        return servSubs.subscribersTotal(codcred, classNum);
    }
}
