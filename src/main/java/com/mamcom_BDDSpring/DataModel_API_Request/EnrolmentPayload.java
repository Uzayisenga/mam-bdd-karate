package com.mamcom_BDDSpring.DataModel_API_Request;//package com.mamcom_BDDSpring.DataModel_API_Request;


import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

import java.util.ArrayList;

@Data
@PageObjects
public class
EnrolmentPayload {

//    private  ArrayList<HashMap<String, EnrolmentAliasesTEV>> aliases = new ArrayList<>();
//    private  ArrayList<HashMap<String ,EnrolmentContactPointsTEV>> contactPoints = new ArrayList<>();


    public ArrayList<EnrolmentAliasesTEV> aliases = new ArrayList<>(  );
    public ArrayList<EnrolmentContactPointsTEV> contactPoints = new ArrayList<>(  );


    private String dateOfBirth;
    private String enrollmentSourceCode;
    private String firstName;
    private String lastName;
    private String language;
    private String gender;
    private boolean allInOnePermission;

    public EnrolmentPayload() {
        System.out.println("Empty contractor ");
    }

    public EnrolmentPayload(ArrayList<EnrolmentAliasesTEV> aliases, ArrayList<EnrolmentContactPointsTEV> contactPoints, String dateOfBirth,
                            String enrollmentSourceCode, String firstName, String lastName, String language, String gender, boolean allInOnePermission) {
        System.out.println("parameterized constractor  ");
        this.aliases = aliases;
        this.contactPoints = contactPoints;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentSourceCode = enrollmentSourceCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
        this.gender = gender;
        this.allInOnePermission = allInOnePermission;

    }
    public ArrayList<EnrolmentAliasesTEV> createAliasesForEnrolment(String aliaseName){
        ArrayList<EnrolmentAliasesTEV> enrolmentAliases = new ArrayList<EnrolmentAliasesTEV>();
        enrolmentAliases.add(new EnrolmentAliasesTEV(aliaseName));
        return enrolmentAliases;
    }


//    public ArrayList<EnrolmentAliasesTEV> createAliasesForEnrolment(String aliaseName) {
//        ArrayList<HashMap<String ,EnrolmentAliasesTEV>> enrolmentAliases = new ArrayList<>();
//        HashMap<String,EnrolmentAliasesTEV> map=new HashMap<>();
//        EnrolmentAliasesTEV enrolmentAliasesTEV=new EnrolmentAliasesTEV();
//object.aliasName.toString();
      /*  String alisases=enrolmentAliasesTEV.aliasName.toString();
        String[] password={enrolmentAliasesTEV.password};
        String[] type={enrolmentAliasesTEV.type};
        (() enrolmentAliasesTEV)
        //EnrolmentAliasesTEV obj=alisases;
        map.put("type",((EnrolmentAliasesTEV) enrolmentAliasesTEV.type);
        map.put("aliases", {aliaseName});
        map.put("password", password);*/
//        enrolmentAliases.add(map);
//        System.out.println(enrolmentAliases);
//        return enrolmentAliases;
//    }
    public EnrolmentContactPointsPostTEV createContactPointPostForEnrolment(String country,String city,String zipCode, String street ) {
        ArrayList<EnrolmentContactPointsPostTEV> enrolmentContactPoints = new ArrayList<>();
        EnrolmentContactPointsPostTEV enrolmentContactPointsPostTEV = new EnrolmentContactPointsPostTEV("PRIVATE", "Post", true, country, city, zipCode, street);
        enrolmentContactPoints.add(enrolmentContactPointsPostTEV);
        System.out.println(enrolmentContactPoints.toString());
        return enrolmentContactPointsPostTEV;
    }

    public EnrolmentContactPointsEmailTEV createContactPointEmailForEnrolment(String email) {

        ArrayList<EnrolmentContactPointsEmailTEV> enrolmentContactPoints = new ArrayList<>();
        EnrolmentContactPointsEmailTEV enrolmentContactPointsEmailTEV = new EnrolmentContactPointsEmailTEV("PRIVATE","post",email,true);
        enrolmentContactPoints.add(enrolmentContactPointsEmailTEV);
        System.out.println(enrolmentContactPoints.toString());
        return enrolmentContactPointsEmailTEV;
    }

    public EnrolmentContactPointsPhoneTEV createContactPointPhoneForEnrolment(String internationalDialingPrefix,String localNumber) {
        ArrayList<EnrolmentContactPointsPhoneTEV> enrolmentContactPoints = new ArrayList<>();
        EnrolmentContactPointsPhoneTEV enrolmentContactPointPhone = new EnrolmentContactPointsPhoneTEV("PRIVATE", "Mobile", internationalDialingPrefix,localNumber,true);
        enrolmentContactPoints.add(enrolmentContactPointPhone);

        return enrolmentContactPointPhone;
    }

}
