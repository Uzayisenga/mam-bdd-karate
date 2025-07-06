package com.mamcom_BDDSpring.DataModel_API_Request;

import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Data
@PageObjects
public class UDHEnrolment {

    private String initialPassword;
    private String userName;
    private Profile profile;


    UDHEnrolment(){
       Profile p = new Profile();
       p.getGeneralDetails();
       p.getPostalAddresses();
       setProfile(p);

   }

}
