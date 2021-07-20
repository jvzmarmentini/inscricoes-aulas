package pucrs.jvzmarmentini.registration;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.Student;

@SpringBootTest
class RegistrationApplicationTests {

	@Test
	void insertMoreThan10InMeeting() {
		Set<Student> students = new HashSet<Student>();
		Meeting meet = new Meeting();
		for (int i = 0; i <= 10; i++) {
			students.add(new Student(i, ""));
		}

		System.out.println(students.size());

		try {
			for (Student student : students)
				meet.addRegistered(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
