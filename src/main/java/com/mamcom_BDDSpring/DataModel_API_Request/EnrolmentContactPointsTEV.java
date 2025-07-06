package com.mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;

@Data
public class EnrolmentContactPointsTEV {

    protected String usage;
    protected String channel;



    public EnrolmentContactPointsTEV() {}

    public EnrolmentContactPointsTEV(String usage, String channel) {
        this.usage = usage;
        this.channel = channel;


    }
}
