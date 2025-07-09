package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;

@Data
public class EnrolmentContactPointsEmail extends EnrolmentContactPoints {

    //private String usage;
    //private String channel;
    private String confirmedAt;
    private String email;
    private boolean bounced;
    //private boolean standard;

    public EnrolmentContactPointsEmail() {}

    public EnrolmentContactPointsEmail(String usage, String channel, boolean standard, String email) {
        super(usage, channel, standard);
        this.usage = "PRIVATE";
        this.channel = "Email";
        this.confirmedAt = "2018-06-13T07:46:47.152";
        this.email = email;
        this.bounced = false;
        //this.standard = true;
    }
}
