package mamcom_BDDSpring.DataModel_API_Request;


import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class TravelIdFFP {

    private String enrolment;
    private String aliasType;
    TravelIdFFP(){

    }
    TravelIdFFP(String enrolment,String aliasType){

    }
}
