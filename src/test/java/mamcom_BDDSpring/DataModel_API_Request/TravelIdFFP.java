package mamcom_BDDSpring.DataModel_API_Request;


import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

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
