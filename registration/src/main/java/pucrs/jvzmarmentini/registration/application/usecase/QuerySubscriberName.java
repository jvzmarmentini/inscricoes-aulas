package pucrs.jvzmarmentini.registration.application.usecase;

import java.util.Set;

import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.application.dto.SubscribersNamesDTO;
import pucrs.jvzmarmentini.registration.application.services.ServicoSubscribers;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@Component
public class QuerySubscriberName {

    private ServicoSubscribers servSubs;

    public QuerySubscriberName(ServicoSubscribers servSubs) {
        this.servSubs = servSubs;
    }

    public Set<SubscribersNamesDTO> run(String codcred, Integer classNum) {
        return servSubs.subscribersNames(codcred, classNum);
    }
}
