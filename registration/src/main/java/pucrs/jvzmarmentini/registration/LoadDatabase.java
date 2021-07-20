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

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initStudentDatabase(IStudentCRUD studCRUD) {
        return args -> {
            log.info("Preloading " + studCRUD.save(new Student(1, "Yuga Aoyama")));
            log.info("Preloading " + studCRUD.save(new Student(2, "Mina Ashido")));
            log.info("Preloading " + studCRUD.save(new Student(3, "Tsuyu Asui")));
            log.info("Preloading " + studCRUD.save(new Student(4, "Tenya Iida")));
            log.info("Preloading " + studCRUD.save(new Student(5, "Ochaco Uraraka")));
            log.info("Preloading " + studCRUD.save(new Student(6, "Mashirao Ojiro")));
            log.info("Preloading " + studCRUD.save(new Student(7, "Denki Kaminari")));
            log.info("Preloading " + studCRUD.save(new Student(8, "Eijiro Kirishima")));
            log.info("Preloading " + studCRUD.save(new Student(9, "Koji Koda")));
            log.info("Preloading " + studCRUD.save(new Student(10, "Rikido Sato")));
            log.info("Preloading " + studCRUD.save(new Student(11, "Mezo Shoji")));
            log.info("Preloading " + studCRUD.save(new Student(12, "Kyoka Jiro")));
            log.info("Preloading " + studCRUD.save(new Student(13, "Hanta Sero")));
            log.info("Preloading " + studCRUD.save(new Student(14, "Fumikage Tokoyami")));
            log.info("Preloading " + studCRUD.save(new Student(15, "Shoto Todoroki")));
            log.info("Preloading " + studCRUD.save(new Student(16, "Toru Hagakure")));
            log.info("Preloading " + studCRUD.save(new Student(17, "Katsuki Bakugo")));
            log.info("Preloading " + studCRUD.save(new Student(18, "Izuku Midoriya")));
            log.info("Preloading " + studCRUD.save(new Student(19, "Minoru Mineta")));
            log.info("Preloading " + studCRUD.save(new Student(20, "Momo Yaoyorozu")));
        };
    }

    @Bean
    CommandLineRunner initMeetingDatabase(IMeetingCRUD meetCRUD) {
        return args -> {
            log.info("Preloading " + meetCRUD.save(new Meeting("9A1", 1, 20, 8)));
            log.info("Preloading " + meetCRUD.save(new Meeting("9A1", 2, 22, 8)));
            log.info("Preloading " + meetCRUD.save(new Meeting("9B1", 1, 21, 8)));
            log.info("Preloading " + meetCRUD.save(new Meeting("9B1", 2, 23, 8)));
        };
    }
}
