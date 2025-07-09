package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;

@Data
public class EnrolmentContactPointsForTravelidUser {


    protected String channel;
    protected String email;
    protected boolean standard;
    protected String usage;

    public EnrolmentContactPointsForTravelidUser() {}

    public EnrolmentContactPointsForTravelidUser(String channel,String email, boolean standard,String usage) {
        this.channel = channel;
        this.email=email;
        this.standard = standard;
        this.usage = usage;

    }
}
