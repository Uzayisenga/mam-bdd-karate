package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class EnrolmentContactPointsPhoneTEV extends EnrolmentContactPointsTEV{


    //private String usage;
    //private String channel;

    private String confirmedAt;
    private String internationalDialingPrefix;
//    private String areaCode;
    private String localNumber;
    private boolean standard;
    public EnrolmentContactPointsPhoneTEV() {}

    public EnrolmentContactPointsPhoneTEV(String usage, String channel,String internationalDialingPrefix,String localNumber,boolean standard) {
        super(usage, channel);
        this.confirmedAt = "2018-06-22T07:03:12.383";
        this.internationalDialingPrefix =internationalDialingPrefix;
//        this.areaCode = "69";
        this.localNumber = localNumber;
        this.standard=standard;

    }
}
