package com.mamcom_BDDSpring.DataModel_API_Request;

import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class Gender {

    private String value ="MALE";
    public Gender() {}

}