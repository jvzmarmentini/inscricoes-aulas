package pucrs.jvzmarmentini.registration.business.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "Student")
public class Student {

    private @Id Integer reg;
    private String name;

    @ManyToMany
    // @JoinTable(name = "meeting_registered", joinColumns = @JoinColumn(name =
    // "student_reg"), inverseJoinColumns = @JoinColumn(name = "meeting_id"))
    private List<Meeting> registeredMeetings;

    public Student() {
    }

    public Student(Integer reg, String name) {
        this.reg = reg;
        this.name = name;
    }

    public Student(Integer reg, String name, List<Meeting> registeredMeetings) {
        this.reg = reg;
        this.name = name;
        this.registeredMeetings = registeredMeetings;
    }

    public Integer getReg() {
        return reg;
    }

    public void setReg(Integer reg) {
        this.reg = reg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meeting> getRegisteredMeetings() {
        return registeredMeetings;
    }

    public void setRegisteredMeetings(List<Meeting> registeredMeetings) {
        this.registeredMeetings = registeredMeetings;
    }

    public void addRegisteredMeeting(Meeting meet) {
        registeredMeetings.add(meet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Student))
            return false;

        Student student = (Student) obj;
        return Objects.equals(this.reg, student.reg) && Objects.equals(this.name, student.name);
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", reg=" + reg + ", registeredMeetings=" + registeredMeetings + "]";
    }

}
