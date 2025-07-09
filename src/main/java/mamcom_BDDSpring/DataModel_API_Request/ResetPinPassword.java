package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class ResetPinPassword {

        private EnrolmentContextTravelIDTEV context;
        private String principal;
        private String principalType;
       // private String redirecturi;
    ResetPinPassword(){
        }
    ResetPinPassword(EnrolmentContextTravelIDTEV enrolmentContextTravelIDTEV, String principal,String principalType){
        }

    }

