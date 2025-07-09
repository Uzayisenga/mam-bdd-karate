package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

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



