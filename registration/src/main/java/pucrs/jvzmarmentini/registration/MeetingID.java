package pucrs.jvzmarmentini.registration;

import java.io.Serializable;

public class MeetingID implements Serializable {

    private String codcred;
    private Integer classNum;

    public MeetingID() {
    }

    public MeetingID(String codcred, Integer classNum) {
        this.codcred = codcred;
        this.classNum = classNum;
    }

}