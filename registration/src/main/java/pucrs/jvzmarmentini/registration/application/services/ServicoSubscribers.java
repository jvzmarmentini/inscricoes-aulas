package pucrs.jvzmarmentini.registration.application.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pucrs.jvzmarmentini.registration.application.dto.SubscribersNamesDTO;
import pucrs.jvzmarmentini.registration.application.dto.SubscribersTotalDTO;
import pucrs.jvzmarmentini.registration.business.entities.Student;
import pucrs.jvzmarmentini.registration.business.repositories.IMeetingRepository;

@Component
public class ServicoSubscribers {
    private IMeetingRepository meetRepo;

    @Autowired
    public ServicoSubscribers(IMeetingRepository meetRepo) {
        this.meetRepo = meetRepo;
    }

    public Set<SubscribersNamesDTO> subscribersNames(String codcred, Integer classNum) {
        Set<Student> meetSubscribers = meetRepo.allMeetings(codcred, classNum).getRegistereds();
        return meetSubscribers.stream().map(studentName -> new SubscribersNamesDTO(studentName.getName()))
                .collect(Collectors.toSet());
    }

    public SubscribersTotalDTO subscribersTotal(String codcred, Integer classNum) {
        return new SubscribersTotalDTO(meetRepo.allMeetings(codcred, classNum).getRegistereds().size());
    }

}
