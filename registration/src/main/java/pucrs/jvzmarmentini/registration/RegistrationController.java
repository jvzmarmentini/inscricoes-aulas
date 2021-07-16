package pucrs.jvzmarmentini.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final IStudentRepository studRepo;
    private final IMeetingRepository meetRepo;

    @Autowired
    public RegistrationController(IStudentRepository studRepo, IMeetingRepository meetRepo) {
        this.studRepo = studRepo;
        this.meetRepo = meetRepo;
    }

    // Students end points

    @GetMapping("/students")
    @CrossOrigin(origins = "*")
    public List<Student> allStudents() {
        return studRepo.allStudents();
    }

    @PostMapping("/students")
    @CrossOrigin(origins = "*")
    public Student newStudent(@RequestBody Student newStudent) {
        return studRepo.newStudent(newStudent);
    }

    @GetMapping("/students/{reg}")
    @CrossOrigin(origins = "*")
    public Student one(@PathVariable Integer reg) {
        return studRepo.oneById(reg);
    }

    @GetMapping("/students/{name}")
    @CrossOrigin(origins = "*")
    public Student one(@PathVariable String name) {
        return studRepo.oneByName(name);
    }

    @PutMapping("/students/{reg}")
    @CrossOrigin(origins = "*")
    public Student replaceStudent(@RequestBody Student newStudent, @PathVariable Integer reg) {
        return studRepo.replaceStudent(newStudent, reg);
    }

    @DeleteMapping("/students/{reg}")
    @CrossOrigin(origins = "*")
    public boolean deleteStudent(@PathVariable Integer reg) {
        return studRepo.deleteStudent(reg);
    }

    // Meetings end points

    @PostMapping("/meetings")
    @CrossOrigin(origins = "*")
    public Meeting newMeeting(@RequestBody Meeting newMeeting) {
        return meetRepo.newMeeting(newMeeting);
    }

    @GetMapping("/meetings")
    @CrossOrigin(origins = "*")
    public List<Meeting> allMeetings() {
        return meetRepo.allMeetings();
    }

    // Subscribers end points

}
