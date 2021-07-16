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

    private final StudentRepository stdRepo;

    @Autowired
    public RegistrationController(StudentRepository stdRepo) {
        this.stdRepo = stdRepo;
    }

    @GetMapping("/students")
    @CrossOrigin(origins = "*")
    public List<Student> all() {
        return stdRepo.findAll();
    }

    @PostMapping("/students")
    @CrossOrigin(origins = "*")
    public Student newStudent(@RequestBody Student newStudent) {
        return stdRepo.save(newStudent);
    }

    @GetMapping("/students/{id}")
    @CrossOrigin(origins = "*")
    public Student one(@PathVariable String name) {
        return stdRepo.findById(name).orElseThrow(() -> new StudentNotFoundException(name));
    }

    @PutMapping("/students/{id}")
    @CrossOrigin(origins = "*")
    public Student replaceStudent(@RequestBody Student newStudent, @PathVariable String name) {
        return stdRepo.findById(name).map(student -> {
            student.setName(newStudent.getName());
            return stdRepo.save(student);
        }).orElseGet(() -> {
            newStudent.setName(name);
            return stdRepo.save(newStudent);
        });
    }

    @DeleteMapping("/students/{id}")
    @CrossOrigin(origins = "*")
    public void deleteStudent(@PathVariable String name) {
        stdRepo.deleteById(name);
    }
}
