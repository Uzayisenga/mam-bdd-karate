package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

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

