package pucrs.jvzmarmentini.registration.business.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@Entity(name = "Student")
public class Student {

    @Id
    private Integer reg;
    private String name;

    @JsonIgnore
    @ManyToMany
    private Set<Meeting> registeredMeetings = new HashSet<Meeting>();

    public Student() {
    }

    public Student(Integer reg, String name) {
        this.reg = reg;
        this.name = name;
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

    public Set<Meeting> getRegisteredMeetings() {
        return registeredMeetings;
    }

    public void setRegisteredMeetings(Set<Meeting> registeredMeetings) {
        this.registeredMeetings = registeredMeetings;
    }

    public Student addRegisteredMeeting(Meeting meet) throws Exception {
        if (meet.getRegistereds().size() == 10)
            throw new Exception("Limite de alunos!");
        if (this.registeredMeetings.add(meet))
            meet.addRegistered(this);
        return this;
    }

    public Student removeRegisteredMeeting(Meeting meet) {
        if (this.registeredMeetings.remove(meet))
            meet.removeRegistered(this);
        return this;
    }

    public boolean regValid() {
        return this.reg != null;
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
