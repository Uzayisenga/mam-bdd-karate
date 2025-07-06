package com.mamcom_BDDSpring.dataProvider;
import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class Member {

        private String internationalDialingPrefix;
        private String localNumber;
        private String custNo;
        private String verificationCode;
        private String mobileId;
    }

