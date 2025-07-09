package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class TravelIDBasic {
    private String enrolment;
    private String aliasType;
    TravelIDBasic(){

    }

    TravelIDBasic(String enrolment,String aliasType){

    }

}



