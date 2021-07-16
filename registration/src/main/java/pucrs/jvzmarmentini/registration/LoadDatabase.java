package pucrs.jvzmarmentini.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initStudentDatabase(StudentRepository studRepo) {
        return args -> {
            log.info("Preloading " + studRepo.save(new Student(20100001, "Bilbo Baggins")));
            log.info("Preloading " + studRepo.save(new Student(20100002, "Frodo Baggins")));
        };
    }

    @Bean
    CommandLineRunner initMeetingDatabase(MeetingRepository meetRepo) {
        return args -> {
            log.info("Preloading " + meetRepo.save(new Meeting("98801-04", 30, 20, 8)));
            log.info("Preloading " + meetRepo.save(new Meeting("98H00-04", 30, 21, 8)));
        };
    }
}
