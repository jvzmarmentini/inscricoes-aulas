package pucrs.jvzmarmentini.registration.business.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.HashSet;

@Entity(name = "Meeting")
@Table(name = "meeting")
public class Meeting {

    @EmbeddedId
    private MeetingID id;
    private int day;
    private int month;

    @ManyToMany(mappedBy = "registeredMeetings")
    private Set<Student> registereds = new HashSet<Student>();

    public Meeting() {
    }

    public Meeting(String codcred, Integer classNum, int day, int month) {
        this.id = new MeetingID(codcred, classNum);
        this.day = day;
        this.month = month;
    }

    public String getCodcred() {
        return id.getCodcred();
    }

    public void setCodcred(String codcred) {
        this.id.setCodcred(codcred);
    }

    public Integer getClassNum() {
        return id.getClassNum();
    }

    public void setClassNum(Integer classNum) {
        this.id.setClassNum(classNum);
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

    public Meeting addRegistered(Student student) {
        // if (registereds.size() >= 10) {
        // throw new Exception("Limite de alunos!");
        // }
        if (this.registereds.add(student))
            student.addRegisteredMeeting(this);
        return this;
    }

    public Meeting removeRegistered(Student student) {
        // if (registereds.size() >= 10) {
        // throw new Exception("Limite de alunos!");
        // }
        this.registereds.remove(student);
        student.removeRegisteredMeeting(this);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.day, this.month);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Meeting))
            return false;

        Meeting meeting = (Meeting) obj;
        return Objects.equals(this.id, meeting.id) && Objects.equals(this.day, meeting.day)
                && Objects.equals(this.month, meeting.month);
    }

    @Override
    public String toString() {
        return "Meeting [classNum=" + id.getClassNum() + ", codcred=" + id.getCodcred() + ", day=" + day + ", month="
                + month + ", registereds=" + registereds + "]";
    }

}