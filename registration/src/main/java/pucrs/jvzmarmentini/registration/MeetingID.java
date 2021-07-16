package pucrs.jvzmarmentini.registration;

import java.io.Serializable;
import java.util.Objects;

public class MeetingID implements Serializable {

    private String codcred;
    private Integer classNum;

    public MeetingID() {
    }

    public MeetingID(String codcred, Integer classNum) {
        this.codcred = codcred;
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