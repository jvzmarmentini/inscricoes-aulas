package pucrs.jvzmarmentini.registration.business.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MeetingID implements Serializable {

    @Column(name = "codcred")
    private String codcred;

    @Column(name = "classNum")
    private Integer classNum;

    public MeetingID() {
    }

    public MeetingID(String codcred, Integer classNum) {
        this.codcred = codcred;
        this.classNum = classNum;
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

    @Override
    public int hashCode() {
        return Objects.hash(this.codcred, this.classNum);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof MeetingID))
            return false;

        MeetingID meetingID = (MeetingID) obj;
        return Objects.equals(this.codcred, meetingID.codcred) && Objects.equals(this.classNum, meetingID.classNum);
    }
}