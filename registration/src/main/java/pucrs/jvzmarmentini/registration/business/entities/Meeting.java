package pucrs.jvzmarmentini.registration.business.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;

import java.util.HashSet;

/**
 * @author João Victor Zucco Marmentini
 * @custom.matricula 20103144
 * @custom.gitHubLink https://github.com/jvzmarmentini/inscricoes-aulas
 */

@Entity(name = "Meeting")
@IdClass(MeetingID.class)
public class Meeting {

    private @Id String codcred;
    private @Id Integer classNum;
    private int day;
    private int month;

    @ManyToMany(mappedBy = "registeredMeetings")
    private Set<Student> registereds = new HashSet<Student>();

    public Meeting() {
    }

    public Meeting(String codcred, Integer classNum, int day, int month) {
        this.codcred = codcred;
        this.classNum = classNum;
        this.day = day;
        this.month = month;
    }

    public String getCodcred() {
        return codcred;
    }

    public void setCodcred(String codcred) {
        this.codcred = codcred;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Set<Student> getRegistereds() {
        return registereds;
    }

    public void setRegistereds(Set<Student> registereds) {
        this.registereds = registereds;
    }

    public Meeting addRegistered(Student student) throws Exception {
        if (this.registereds.size() == 10)
            throw new Exception("Limite de alunos!");
        if (this.registereds.add(student))
            student.addRegisteredMeeting(this);
        return this;
    }

    public Meeting removeRegistered(Student student) {
        if (registereds.size() == 0)
            return this;
        if (this.registereds.remove(student))
            student.removeRegisteredMeeting(this);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.codcred, this.classNum, this.day, this.month);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Meeting))
            return false;

        Meeting meeting = (Meeting) obj;
        return Objects.equals(this.codcred, meeting.codcred) && Objects.equals(this.classNum, meeting.classNum)
                && Objects.equals(this.day, meeting.day) && Objects.equals(this.month, meeting.month);
    }

    @Override
    public String toString() {
        return "Meeting [classNum=" + classNum + ", codcred=" + codcred + ", day=" + day + ", month=" + month
                + ", registereds=" + registereds + "]";
    }

}