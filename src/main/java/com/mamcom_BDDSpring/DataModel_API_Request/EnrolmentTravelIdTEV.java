package com.mamcom_BDDSpring.DataModel_API_Request;

import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

import java.util.ArrayList;

@Data
@PageObjects
public class EnrolmentTravelIdTEV {
    private EnrolmentContextTravelIDTEV context;
    private EnrolmentPayloadForTravelIdUser enrolmentPayload;
    EnrolmentTravelIdTEV(){
    }
    EnrolmentTravelIdTEV(EnrolmentContextTravelIDTEV enrolmentContextTravelIDTEV,EnrolmentPayloadForTravelIdUser enrolmentPayloadForTravelIdUser){
    }
    public EnrolmentContextTravelIDTEV travelIdUserContactPointPost(String language,String tenantid, String country,String principal_type) {
        EnrolmentContextTravelIDTEV enrolmentContactPointPost = new EnrolmentContextTravelIDTEV( language,tenantid,country,"de",principal_type);
        return enrolmentContactPointPost;
    }
//    Newly added
    public EnrolmentContextTravelIDTEV travelIdUserContactPointPost2(String language,String tenantId,String country,String principal_type,String reduced_state,String response_type, String scope, String state){
        EnrolmentContextTravelIDTEV enrolmentContactPointPost2=new EnrolmentContextTravelIDTEV(language,tenantId,country,"de",principal_type,reduced_state,response_type,scope,state);
        return enrolmentContactPointPost2;
    }


}
