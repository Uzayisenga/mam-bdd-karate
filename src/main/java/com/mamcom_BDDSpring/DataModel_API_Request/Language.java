package com.mamcom_BDDSpring.DataModel_API_Request;
import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@PageObjects
public class Language {


    private String catalogueName ="LANGUAGE";
    private String value ="EN";
    public Language() {
    }



}