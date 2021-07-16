package pucrs.jvzmarmentini.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pucrs.jvzmarmentini.registration.adapters.repositories.IMeetingCRUD;
import pucrs.jvzmarmentini.registration.adapters.repositories.IStudentCRUD;
import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.Student;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initStudentDatabase(IStudentCRUD studCRUD) {
        return args -> {
            log.info("Preloading " + studCRUD.save(new Student(20100001, "Bilbo Baggins")));
            log.info("Preloading " + studCRUD.save(new Student(20100002, "Frodo Baggins")));
        };
    }

    @Bean
    CommandLineRunner initMeetingDatabase(IMeetingCRUD meetCRUD) {
        return args -> {
            log.info("Preloading " + meetCRUD.save(new Meeting("98801-04", 30, 20, 8)));
            log.info("Preloading " + meetCRUD.save(new Meeting("98H00-04", 30, 21, 8)));
        };
    }
}
