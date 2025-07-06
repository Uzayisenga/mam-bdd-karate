package com.mamcom_BDDSpring.DataModel_API_Request;

import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
//@PageObjects
public class EnrolmentContactPointsEmailTEV extends EnrolmentContactPointsTEV{


    //private String usage;
    //private String channel;
    private String confirmedAt;
    private String email;
//    private boolean bounced;
    private boolean standard;

    public EnrolmentContactPointsEmailTEV() {}

    public EnrolmentContactPointsEmailTEV(String usage, String channel, String email,boolean standard) {
        super(usage, channel);
        this.usage = "PRIVATE";
        this.channel = "Email";
        this.confirmedAt = "2018-06-13T07:46:47.152";
        this.email = email;
//        this.bounced = false;
        this.standard = true;
    }
}
