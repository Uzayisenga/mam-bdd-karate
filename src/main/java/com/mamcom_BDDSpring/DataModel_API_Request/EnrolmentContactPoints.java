package com.mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;

@Data
public class EnrolmentContactPoints {

    //super(usage, channel, standard);

    protected String usage;
    protected String channel;
    protected boolean standard;


    public EnrolmentContactPoints() {}

    public EnrolmentContactPoints(String usage, String channel, boolean standard) {
        this.usage = usage;
        this.channel = channel;
        this.standard = standard;

    }
}
