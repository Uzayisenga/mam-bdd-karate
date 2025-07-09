package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;

@Data
public class BasicUserEnrolmentContactPoints {

    protected String usage;
    protected String channel;
    protected boolean standard;


    public BasicUserEnrolmentContactPoints() {}

    public BasicUserEnrolmentContactPoints(String usage, String channel, boolean standard) {
        this.usage = usage;
        this.channel = channel;
        this.standard = standard;

    }
}
