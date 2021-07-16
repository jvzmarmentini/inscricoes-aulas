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

    private final StudentRepository studRepo;
    private final MeetingRepository meetRepo;

    @Autowired
    public RegistrationController(StudentRepository studRepo, MeetingRepository meetRepo) {
        this.studRepo = studRepo;
        this.meetRepo = meetRepo;
    }

    @GetMapping("/students")
    @CrossOrigin(origins = "*")
    public List<Student> allStudents() {
        return studRepo.findAll();
    }

    @GetMapping("/meetings")
    @CrossOrigin(origins = "*")
    public List<Meeting> allMeetings() {
        return meetRepo.findAll();
    }

    @PostMapping("/students")
    @CrossOrigin(origins = "*")
    public Student newStudent(@RequestBody Student newStudent) {
        return studRepo.save(newStudent);
    }

    @PostMapping("/meetings")
    @CrossOrigin(origins = "*")
    public Meeting newMeeting(@RequestBody Meeting newMeeting) {
        return meetRepo.save(newMeeting);
    }

    @GetMapping("/students/{reg}")
    @CrossOrigin(origins = "*")
    public Student one(@PathVariable Integer reg) {
        return studRepo.findById(reg).orElseThrow(() -> new StudentNotFoundException(reg));
    }

    @GetMapping("/students/{name}")
    @CrossOrigin(origins = "*")
    public Student one(@PathVariable String name) {
        return studRepo.findByName(name);
    }

    @PutMapping("/students/{reg}")
    @CrossOrigin(origins = "*")
    public Student replaceStudent(@RequestBody Student newStudent, @PathVariable Integer reg) {
        return studRepo.findById(reg).map(student -> {
            student.setReg(newStudent.getReg());
            student.setName(newStudent.getName());
            return studRepo.save(student);
        }).orElseGet(() -> {
            newStudent.setReg(reg);
            return studRepo.save(newStudent);
        });
    }

    @DeleteMapping("/students/{reg}")
    @CrossOrigin(origins = "*")
    public void deleteStudent(@PathVariable Integer reg) {
        System.out.println(reg);
        studRepo.deleteById(reg);
    }
}
