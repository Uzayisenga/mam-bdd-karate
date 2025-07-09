package mamcom_BDDSpring.DataModel_API_Request;



import mamcom_BDDSpring.GlobalFunctions.GlobalFunctions;
import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


@Data
@PageObjects
public class Enrolment {

    @Autowired
    private GlobalFunctions globalFunctions;

    private String dateOfBirth;
    private String language;
    private String firstName;
    private String lastName;
    private String gender;
    private ArrayList<EnrolmentAliases> aliases = new ArrayList<>();
    private ArrayList<EnrolmentContactPoints> contactPoints = new ArrayList<>();
    private EnrolmentContext context;
    private String enrollmentSourceCode;

    public Enrolment() {
    }

    public Enrolment(String dateOfBirth, String language, String firstName, String lastName, String gender,
                     ArrayList<EnrolmentAliases> aliases, ArrayList<EnrolmentContactPoints> contactPoints, EnrolmentContext context,
                     String enrollmentSourceCode) {
        this.dateOfBirth = dateOfBirth;
        this.language = language;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.aliases = aliases;
        this.contactPoints = contactPoints;
        this.context = context;
        this.enrollmentSourceCode = enrollmentSourceCode;
    }

//    public ArrayList<EnrolmentAliases> createAliasesForEnrolment(String password){
//        ArrayList<EnrolmentAliases> enrolmentAliases = new ArrayList<EnrolmentAliases>();
//        enrolmentAliases.add(new EnrolmentAliases(globalFunctions.generateRandomString( 10 )));
//        return enrolmentAliases;
////    }
    public ArrayList<EnrolmentAliases> createAliasesForEmailEnrolment(){
        ArrayList<EnrolmentAliases> enrolmentAliases1 = new ArrayList<EnrolmentAliases>();
        enrolmentAliases1.add(new EnrolmentAliases(globalFunctions.generateRandomEmail( 10 )));
        return enrolmentAliases1;
    }
//    public ArrayList<EnrolmentContactPoints> createContactPointsforEnrolment() {
//        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
//        EnrolmentContactPointsPost enrolmentContactPointsPost = new EnrolmentContactPointsPost( "PRIVATE", "Post", true,"DE", "Frankfurt", "60549", "Unterschweinstiege 8");
//        EnrolmentContactPointsEmail enrolmentContactPointsEmail = new EnrolmentContactPointsEmail( "PRIVATE", "Email", true, globalFunctions.generateRandomString( 10 )+"@yobmail.com" );
//        EnrolmentContactPointsPhone enrolmentContactPointsPhone = new EnrolmentContactPointsPhone( "PRIVATE", "Mobile", true) ;
//        enrolmentContactPoints.add( enrolmentContactPointsPost);
//        enrolmentContactPoints.add( enrolmentContactPointsEmail);
//        enrolmentContactPoints.add( enrolmentContactPointsPhone);
//        return enrolmentContactPoints;
//    }

//    public EnrolmentContactPointsPost createContactPointPostForEnrolment() {
//        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
//        EnrolmentContactPointsPost enrolmentContactPointPost = new EnrolmentContactPointsPost( "PRIVATE", "Post", true,"DE", "Frankfurt", "60549", "Unterschweinstiege 9");
//        return enrolmentContactPointPost;
//    }

    public EnrolmentContactPointsPost createContactPointPostForEnrolment() {
        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
        EnrolmentContactPointsPost enrolmentContactPointPost = new EnrolmentContactPointsPost( "PRIVATE", "Post", true,"DE", "Frankfurt", "60549", "Unterschweinstiege 9"," ");
        return enrolmentContactPointPost;
    }


    public EnrolmentContactPointsEmail createContactPointEmailForEnrolment() {
        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
        EnrolmentContactPointsEmail enrolmentContactPointEmail = new EnrolmentContactPointsEmail( "PRIVATE", "Email", true, globalFunctions.generateRandomString( 10 )+"@yopmail.com" );
        return enrolmentContactPointEmail;
    }
//
    public EnrolmentContactPointsPhone createContactPointPhoneForEnrolment() {
        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
        EnrolmentContactPointsPhone enrolmentContactPointPhone = new EnrolmentContactPointsPhone( "PRIVATE", "Mobile", true) ;
        return enrolmentContactPointPhone;
    }
//
    public EnrolmentContext createTenantForEnrolment(String tenant){
         context = new EnrolmentContext();
         context.setTenantId(tenant);
        return context;
    }


}
