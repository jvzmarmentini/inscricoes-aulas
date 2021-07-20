package pucrs.jvzmarmentini.registration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.Student;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@SpringBootTest
class RegistrationApplicationTests {

	@Test
	void insertMoreThan10InMeeting() throws Exception {
		Set<Student> students = new HashSet<Student>();
		Meeting meet = new Meeting();
		for (int i = 0; i <= 20; i++) {
			students.add(new Student(i, ""));
		}

		for (Student student : students)
			meet.addRegistered(student);
	}

	@Test
	void givenStudentNullReg() {
		Student student = new Student(null, "João");

		assertTrue(student.regValid());
	}

	@Test
	void givenStudentNotNullReg() {
		Student student = new Student(123, "João");

		assertTrue(student.regValid());
	}

}
