package com.mamcom_BDDSpring.DataModel_API_Request;

import com.mamcom_BDDSpring.GlobalFunctions.GlobalFunctions;
import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.stringtemplate.v4.ST;

import java.util.ArrayList;

@Data
@PageObjects
public class EnrolmentFFP {



    @Autowired
    private GlobalFunctions globalFunctions;
    private String dateOfBirth;
    private String language;
    private String firstName;
    private String lastName;
    private String gender;
    private ArrayList<EnrolmentAliasesFFP> aliases = new ArrayList<>(  );
    private ArrayList<EnrolmentContactPoints> contactPoints = new ArrayList<>(  );
    private EnrolmentContext context;
    private String enrollmentSourceCode;
    private String country;
    private String city;
    private String zipCode;
    private String street;
    private String title;
    private String academicTitle;
    private String day;
    private String month;
    private String year;
    private String middleName;
    private String nameSuffix;
    private boolean allInOnePermission;
    private String bpVersion;
    private String additionalAddressInformation;
    private String countryCode;
    private String number;
    private String otherTelephoneNumbers;
    private String preferredLaunguage;



    public EnrolmentFFP() {
    }

    public EnrolmentFFP(String dateOfBirth, String language,String firstName, String lastName, String middleName,String gender,
                        ArrayList<EnrolmentAliasesFFP> aliases, ArrayList<EnrolmentContactPoints> contactPoints,EnrolmentContext context,
                        String enrollmentSourceCode, String day, String month, String year, String zipCode, String countryCode, String number, String otherTelephoneNumbers,
                        String country, String city, String street,String title, String additionalAddressInformation, String academicTitle, String preferredLaunguage,String nameSuffix, boolean allInOnePermission, String bpVersion) {
        this.dateOfBirth = dateOfBirth;
        this.language = language;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.nameSuffix = nameSuffix;
        this.allInOnePermission = allInOnePermission;
        this.bpVersion = bpVersion;
        this.gender = gender;
        this.aliases = aliases;
        this.contactPoints = contactPoints;
        this.context = context;
        this.enrollmentSourceCode = enrollmentSourceCode;
        this.country = country;
        this.city = city;
        this.zipCode=zipCode;
        this.street=street;
        this.title=title;
        this.academicTitle=academicTitle;
        this.day=day;
        this.month=month;
        this.year=year;
        this.additionalAddressInformation=additionalAddressInformation;
        this.countryCode=countryCode;
        this.number=number;

        this.otherTelephoneNumbers=otherTelephoneNumbers;
        this.preferredLaunguage=preferredLaunguage;

    }

    public ArrayList<EnrolmentAliasesFFP> createAliasesForEnrolment(String password){
        ArrayList<EnrolmentAliasesFFP> enrolmentAliasesForFFP = new ArrayList<EnrolmentAliasesFFP>();
        enrolmentAliasesForFFP.add(new EnrolmentAliasesFFP(globalFunctions.generateRandomString( 10 ), password));
        return enrolmentAliasesForFFP;
    }
    public ArrayList<EnrolmentAliasesFFP> createAliasesForEmailEnrolment(String password){
        ArrayList<EnrolmentAliasesFFP> enrolmentAliases = new ArrayList<EnrolmentAliasesFFP>();
        enrolmentAliases.add(new EnrolmentAliasesFFP(globalFunctions.generateRandomEmail( 10 ), password));
        return enrolmentAliases;
    }
    public ArrayList<EnrolmentContactPoints> createContactPointsforEnrolment() {
        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
        EnrolmentContactPointsPost enrolmentContactPointsPost = new EnrolmentContactPointsPost( "PRIVATE", "Post", true,"DE", "Frankfurt", "60549", "Unterschweinstiege 8", "");
        EnrolmentContactPointsEmail enrolmentContactPointsEmail = new EnrolmentContactPointsEmail( "PRIVATE", "Email", true, globalFunctions.generateRandomString( 10 )+"@yobmail.com" );
        EnrolmentContactPointsPhone enrolmentContactPointsPhone = new EnrolmentContactPointsPhone( "PRIVATE", "Mobile", true) ;
        enrolmentContactPoints.add( enrolmentContactPointsPost);
        enrolmentContactPoints.add( enrolmentContactPointsEmail);
        enrolmentContactPoints.add( enrolmentContactPointsPhone);
        return enrolmentContactPoints;
    }

    public EnrolmentContactPointsPost createContactPointPostForEnrolment() {
        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
        EnrolmentContactPointsPost enrolmentContactPointPost = new EnrolmentContactPointsPost( "PRIVATE", "Post", true,"DE", "Frankfurt", "60549", "Unterschweinstiege 9","");
        return enrolmentContactPointPost;
    }

    public EnrolmentContactPointsEmail createContactPointEmailForEnrolment() {
        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
        EnrolmentContactPointsEmail enrolmentContactPointEmail = new EnrolmentContactPointsEmail( "PRIVATE", "Email", true, globalFunctions.generateRandomString( 10 )+"@yopmail.com" );
        return enrolmentContactPointEmail;
    }

    public EnrolmentContactPointsPhone createContactPointPhoneForEnrolment() {
        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
        EnrolmentContactPointsPhone enrolmentContactPointPhone = new EnrolmentContactPointsPhone( "PRIVATE", "Mobile", true) ;
        return enrolmentContactPointPhone;
    }

    public EnrolmentContext createTenantForEnrolment(String tenant){
        context = new EnrolmentContext();
        context.setTenantId(tenant);
        return context;
    }

}
