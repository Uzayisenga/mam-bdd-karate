package com.mamcom_BDDSpring.dataProvider;

import com.mamcom_BDDSpring.DataModel_API_Request.EnrolmentAliases;
import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

import java.util.ArrayList;

@Data
@PageObjects
public class updateUser {

    private int id = 0;
    private String type="ONEID";
    private String aliasName="testsample1@yopmail.com";
    private String password="Test@1234";

}

