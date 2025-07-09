package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class Language {


    private String catalogueName ="LANGUAGE";
    private String value ="EN";
    public Language() {
    }



}