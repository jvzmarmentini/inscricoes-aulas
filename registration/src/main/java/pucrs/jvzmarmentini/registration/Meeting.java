package pucrs.jvzmarmentini.registration;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(MeetingID.class)
public class Meeting {

    private @Id String codcred;
    private @Id Integer classNum;
    private int day;
    private int month;

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

    @Override
    public int hashCode() {
        return Objects.hash(this.codcred, this.classNum, this.day, this.month);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Student))
            return false;

        Meeting meeting = (Meeting) obj;
        return Objects.equals(this.codcred, meeting.codcred) && Objects.equals(this.classNum, meeting.classNum)
                && Objects.equals(this.day, meeting.day) && Objects.equals(this.month, meeting.month);
    }

    @Override
    public String toString() {
        return "Meeting [classNum=" + classNum + ", codcred=" + codcred + ", day=" + day + ", month=" + month + "]";
    }

}