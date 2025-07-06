package com.mamcom_BDDSpring.DataModel_API_Request;

import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class EnrollmentPayLoad {

    public  String enrollmentPayload(String userType1,String userType2, String tenant ){
        return "{\r\n " +
                "     \"enrolment\": \""+userType1+"\",\r\n" +
                "    \"aliasType\": \""+userType2+"\",\r\n " +
                "   \"tenantId\": \""+tenant+"\"\r\n  " +
                "  \r\n  " +
                " }";
    }
}
