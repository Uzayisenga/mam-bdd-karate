package mamcom_BDDSpring.dataProvider;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class Member {

        private String internationalDialingPrefix;
        private String localNumber;
        private String custNo;
        private String verificationCode;
        private String mobileId;
    }

