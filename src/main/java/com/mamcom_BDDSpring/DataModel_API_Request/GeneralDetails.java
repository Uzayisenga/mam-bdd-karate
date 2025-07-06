package com.mamcom_BDDSpring.DataModel_API_Request;
import com.mamcom_BDDSpring.GlobalFunctions.GlobalFunctions;
import com.mamcom_BDDSpring.annotations.LazyAutowired;
import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@PageObjects
public class GeneralDetails  {

    private String action="INSERT";
    private String firstName= "Alpha123";
    private String lastName="Testuser";
    private String dateOfBirth="2003-01-01";
private Language language;
private Gender gender;

    GeneralDetails(){
        Language l =new Language();
        l.getCatalogueName();
        l.getValue();
        setLanguage(l);
        Gender g = new Gender();
        g.getValue();
        setGender(g);
    }


}