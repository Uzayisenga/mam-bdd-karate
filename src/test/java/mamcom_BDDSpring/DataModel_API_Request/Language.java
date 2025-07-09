package mamcom_BDDSpring.DataModel_API_Request;
import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class Language {


    private String catalogueName ="LANGUAGE";
    private String value ="EN";
    public Language() {
    }



}