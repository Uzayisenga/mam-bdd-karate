package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

import java.util.ArrayList;

@Data
@PageObjects
public class BasicUserEnrolment {

//    @Autowired
//    private GlobalFunctions globalFunctions;
    private String gender;
    private String firstName;
    private String lastName;
    private String middleName;
    private String nameSuffix;
    private String academicTitle;
    private String nobilityTitle;
    private String nameOnTicket;
    private String oneId;
    private String password;
    private boolean allInOnePermission;
    private String language;
    private String enrollmentSourceCode;
    private String dateOfBirth;
    private String bpVersion;
    private ArrayList<BasicUserEnrolmentContactPoints> contactPoints = new ArrayList<>(  );
    private EnrolmentContext context;
    private String day;
    private String month;
    private String year;
    private String number;
    private String title;
    private String prefferdLanguage;
    private String otherTelephoneNumbers;

    public BasicUserEnrolment() {
    }

    public BasicUserEnrolment(String gender, String firstName, String lastName, String middleName, String nameSuffix, String academicTitle,
                              String nobilityTitle, String nameOnTicket, String oneId, String password, boolean allInOnePermission, String language, String enrollmentSourceCode, String dateOfBirth, String bpVersion,
                              ArrayList<BasicUserEnrolmentContactPoints> contactPoints, EnrolmentContext context, String day, String month, String year, String number, String title, String prefferdLanguage, String otherTelephoneNumbers) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName=middleName;
        this.nameSuffix=nameSuffix;
        this.academicTitle=academicTitle;
        this.nobilityTitle=nobilityTitle;
        this.nameOnTicket=nameOnTicket;
        this.oneId=oneId;
        this.password=password;
        this.allInOnePermission=allInOnePermission;
        this.language=language;
        this.enrollmentSourceCode = enrollmentSourceCode;
        this.dateOfBirth = dateOfBirth;
        this.bpVersion=bpVersion;
        this.contactPoints = contactPoints;
        this.context = context;
        this.day = day;
        this.month = month;
        this.year = year;
        this.number = number;
        this.title = title;
        this.prefferdLanguage = prefferdLanguage;
        this.otherTelephoneNumbers = otherTelephoneNumbers;
    }
//    public ArrayList<EnrolmentContactPoints> createContactPointsforEnrolment() {
//        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
//        BasicUserEnrolmentContactPointPost basicUserEnrolmentContactPointPost=new BasicUserEnrolmentContactPointPost("PRIVATE","Post",true,"DE","Frankfurt","60549","Unterschweinstiege 8","false" );
//        BasicUserEnrolmentContactPointsEmail basicUserEnrolmentContactPointsEmail=new BasicUserEnrolmentContactPointsEmail("PRIVATE","Email",true,globalFunctions.generateRandomString( 10 )+"@yobmail.com");
//        enrolmentContactPoints.add( basicUserEnrolmentContactPointPost);
//        enrolmentContactPoints.add( basicUserEnrolmentContactPointsEmail);
//        return enrolmentContactPoints;
//    }

    public BasicUserEnrolmentContactPointPost createBasicUserEnrolmentContactPointPost() {
        ArrayList<BasicUserEnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
//        EnrolmentContactPointsPost enrolmentContactPointPost = new EnrolmentContactPointsPost( "PRIVATE", "Post", true,"DE", "Frankfurt", "60549", "Unterschweinstiege 9");
          BasicUserEnrolmentContactPointPost basicUserEnrolmentContactPointPost=new BasicUserEnrolmentContactPointPost("Post","Frankfurt","DE",false,true,"Teststreet 2","PRIVATE","60549" );
        return basicUserEnrolmentContactPointPost;
    }
//
    public BasicUserEnrolmentContactPointsEmail createBasicUserEnrolmentContactPointsEmail() {
        ArrayList<BasicUserEnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>();
        BasicUserEnrolmentContactPointsEmail basicUserEnrolmentContactPointsEmail = new BasicUserEnrolmentContactPointsEmail("PRIVATE", "Email", true, getFirstName() + "@yopmail.com");
//        EnrolmentContactPointsEmail enrolmentContactPointEmail = new EnrolmentContactPointsEmail( "PRIVATE", "Email", true, globalFunctions.generateRandomString( 10 )+"@yopmail.com" );
        return basicUserEnrolmentContactPointsEmail;
//    }
//
    }
    public EnrolmentContext createTenantForEnrolment(String tenantid) {
        context = new EnrolmentContext();
        context.setTenantId(tenantid);
        return context;
    }

    public EnrolmentContactPointsPhone createBasicUserContactPointPhone() {
        ArrayList<BasicUserEnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>();
        EnrolmentContactPointsPhone basicUserEnrolmentContactPointPhone = new EnrolmentContactPointsPhone("PRIVATE", "Mobile", true);
        return basicUserEnrolmentContactPointPhone;
    }
}
