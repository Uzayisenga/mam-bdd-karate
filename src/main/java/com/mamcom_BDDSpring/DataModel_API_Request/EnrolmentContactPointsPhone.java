package com.mamcom_BDDSpring.DataModel_API_Request;

import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class EnrolmentContactPointsPhone extends EnrolmentContactPoints{

    //private String usage;
    //private String channel;
    //private boolean standard;
    private String confirmedAt;
    private String internationalDialingPrefix;
    private String areaCode;
    private String localNumber;
    private boolean bounced;

    public EnrolmentContactPointsPhone() {}

    public EnrolmentContactPointsPhone(String usage, String channel, boolean standard) {
        super(usage, channel, standard);
        this.confirmedAt = "2018-06-13T07:46:47.152";
        this.internationalDialingPrefix = "+49";
        this.areaCode = "69";
        this.localNumber = "696123456";

//        this.internationalDialingPrefix = null;
//        this.areaCode = null;
//        this.localNumber = null;
        this.bounced = false;
    }
}
