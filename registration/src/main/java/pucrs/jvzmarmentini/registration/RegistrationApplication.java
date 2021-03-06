package pucrs.jvzmarmentini.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@SpringBootApplication
@ComponentScan(basePackages = { "pucrs.jvzmarmentini" })
@EntityScan(basePackages = { "pucrs.jvzmarmentini" })
@EnableJpaRepositories(basePackages = { "pucrs.jvzmarmentini" })
public class RegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}

}
