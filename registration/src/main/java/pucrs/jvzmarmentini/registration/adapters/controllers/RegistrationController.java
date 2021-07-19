package pucrs.jvzmarmentini.registration.adapters.controllers;

import java.util.List;
import java.util.Set;

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

import pucrs.jvzmarmentini.registration.application.usecase.QueryStudentUC;
import pucrs.jvzmarmentini.registration.application.usecase.RegisterStudentUC;
import pucrs.jvzmarmentini.registration.application.usecase.UpdateStudentUC;
import pucrs.jvzmarmentini.registration.application.usecase.DeleteStudentUC;
import pucrs.jvzmarmentini.registration.application.usecase.QueryMeetingUC;
import pucrs.jvzmarmentini.registration.application.usecase.RegisterMeetingUC;
import pucrs.jvzmarmentini.registration.application.usecase.QuerySubscriberMeetingUC;
import pucrs.jvzmarmentini.registration.application.usecase.QuerySubscriberStudentUC;
import pucrs.jvzmarmentini.registration.application.usecase.RegisterSubscriberUC;
import pucrs.jvzmarmentini.registration.business.entities.Meeting;
import pucrs.jvzmarmentini.registration.business.entities.Student;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final QueryStudentUC queryStdu;
    private final RegisterStudentUC regStdu;
    private final UpdateStudentUC updStdu;
    private final DeleteStudentUC delStdu;
    private final QueryMeetingUC queryMeet;
    private final RegisterMeetingUC regMeet;
    private final QuerySubscriberMeetingUC querySubsMeet;
    private final QuerySubscriberStudentUC querySubsStud;
    private final RegisterSubscriberUC regSubs;

    @Autowired
    public RegistrationController(QueryStudentUC queryStdu, RegisterStudentUC regStdu, UpdateStudentUC updStdu,
            DeleteStudentUC delStdu, QueryMeetingUC queryMeet, RegisterMeetingUC regMeet,
            QuerySubscriberMeetingUC querySubsMeet, QuerySubscriberStudentUC querySubsStud,
            RegisterSubscriberUC regSubs) {
        this.queryStdu = queryStdu;
        this.regStdu = regStdu;
        this.updStdu = updStdu;
        this.delStdu = delStdu;
        this.queryMeet = queryMeet;
        this.regMeet = regMeet;
        this.querySubsMeet = querySubsMeet;
        this.querySubsStud = querySubsStud;
        this.regSubs = regSubs;
    }

    // Students end points

    @GetMapping("/students")
    @CrossOrigin(origins = "*")
    public List<Student> allStudents() {
        return queryStdu.run();
    }

    @GetMapping("/students/{reg}")
    @CrossOrigin(origins = "*")
    public Student oneById(@PathVariable Integer reg) {
        return queryStdu.run(reg);
    }

    @GetMapping("/students/name/{name}")
    @CrossOrigin(origins = "*")
    public Student oneByName(@PathVariable String name) {
        return queryStdu.run(name);
    }

    @PostMapping("/students")
    @CrossOrigin(origins = "*")
    public Student newStudent(@RequestBody Student newStudent) {
        return regStdu.run(newStudent);
    }

    @PutMapping("/students/{reg}")
    @CrossOrigin(origins = "*")
    public Student replaceStudent(@RequestBody Student newStudent, @PathVariable Integer reg) {
        return updStdu.run(newStudent, reg);
    }

    @DeleteMapping("/students/{reg}")
    @CrossOrigin(origins = "*")
    public boolean deleteStudent(@PathVariable Integer reg) {
        return delStdu.run(reg);
    }

    // Meetings end points

    @GetMapping("/meetings")
    @CrossOrigin(origins = "*")
    public List<Meeting> allMeetings() {
        return queryMeet.run();
    }

    @PostMapping("/meetings")
    @CrossOrigin(origins = "*")
    public Meeting newMeeting(@RequestBody Meeting newMeeting) {
        return regMeet.run(newMeeting);
    }

    // Subscribers end points

    @GetMapping("/meetings/{codcred}/{classNum}/students")
    @CrossOrigin(origins = "*")
    public Set<Student> studentsMeeting(@PathVariable("codcred") String codcred,
            @PathVariable("classNum") Integer classNum) {
        return querySubsMeet.run(codcred, classNum);
    }

    @GetMapping("/students/{reg}/meetings")
    @CrossOrigin(origins = "*")
    public Set<Meeting> meetingsStudent(@PathVariable Integer reg) {
        return querySubsStud.run(reg);
    }

    @PutMapping("/meetings/{codcred}/{classNum}/students/{reg}")
    @CrossOrigin(origins = "*")
    public void subscriber(@PathVariable("codcred") String codcred, @PathVariable("classNum") Integer classNum,
            @PathVariable("reg") Integer reg) {
        regSubs.run(codcred, classNum, reg);
    }

    @PutMapping("/students/{reg}/meetings/{codcred}/{classNum}")
    @CrossOrigin(origins = "*")
    public void subscriber(@PathVariable("reg") Integer reg, @PathVariable("codcred") String codcred,
            @PathVariable("classNum") Integer classNum) {
        regSubs.run(reg, codcred, classNum);
    }
}
