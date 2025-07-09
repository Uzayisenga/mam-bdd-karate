package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;

@Data
public class BasicUserEnrolmentContactPointsEmail extends BasicUserEnrolmentContactPoints {



    private String usage;
    private String channel;
    private boolean standard;
    private String email;
    public BasicUserEnrolmentContactPointsEmail() {}

    public BasicUserEnrolmentContactPointsEmail(String usage, String channel, boolean standard, String email) {

        this.usage=usage;
        this.channel=channel;
        this.standard=standard;
        this.email = email;


    }
}
