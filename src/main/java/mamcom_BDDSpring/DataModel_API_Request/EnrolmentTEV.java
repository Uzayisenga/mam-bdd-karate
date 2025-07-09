package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

import java.util.ArrayList;

@Data
@PageObjects
public class EnrolmentTEV<enrolmentPayload> {
////    @Autowired
////    private GlobalFunctions globalFunctions;
//
////    @LazyAutowired
////    private GlobalFunctions globalFunctions;
//
//
//    @Autowired
//    private String lastLang;
//    private String lastValidCountry;
//    EnrolmentPayload enrolmentPayload= new EnrolmentPayload();
////    private ArrayList<EnrolmentPayload> enrolmentPayload= new ArrayList<EnrolmentPayload>();
////    private ArrayList<EnrolmentAliasesTEV> aliases=new ArrayList<>();
//
//    private String firstName;
//    private String lastName;
//    private String gender;
//    private String dateOfBirth;
//    private String language;
//
//
//
//    private ArrayList<EnrolmentContactPoints> contactPoints = new ArrayList<>(  );
//    private EnrolmentContext context;
//    private String enrollmentSourceCode;
////    private Object Aliases;
//
//    public EnrolmentTEV() {
//    }
//
//    public EnrolmentTEV(String lastLang,String lastValidCountry, String dateOfBirth, String language,String firstName, String lastName, String gender,
//                        EnrolmentPayload enrolmentPayload,ArrayList<EnrolmentContactPoints> contactPoints,EnrolmentContext context,
//                     String enrollmentSourceCode)
//    {
//        this.lastLang = lastLang;
//        this.lastValidCountry =lastValidCountry;
//        this.dateOfBirth = dateOfBirth;
//        this.language = language;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.gender = gender;
////        this.aliases = aliases;
//        this.enrolmentPayload = enrolmentPayload;
//        this.contactPoints = contactPoints;
//        this.context = context;
//        this.enrollmentSourceCode = enrollmentSourceCode;
//    }
//    public ArrayList<EnrolmentAliasesTEV> createAliasesForEnrolment(String randomText){
//        ArrayList<EnrolmentAliasesTEV> enrolmentPayloads = new ArrayList<EnrolmentAliasesTEV>();
////        enrolmentPayloads.add(new EnrolmentAliasesTEV(randomText));
//        return enrolmentPayloads;
//    }
//    public ArrayList<EnrolmentPayload> createAliasesForEmailEnrolment(){
//        ArrayList<EnrolmentPayload> enrolmentPayloads = new ArrayList<EnrolmentPayload>();
////        enrolmentPayloads.add(new EnrolmentPayload("ererer56@yopmail.com"));
//        return enrolmentPayloads;
//    }
//    public ArrayList<EnrolmentContactPoints> createContactPointsforEnrolment() {
//        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
//        EnrolmentContactPointsPost enrolmentContactPointsPost = new EnrolmentContactPointsPost( "PRIVATE", "Post", true,"UK", "Frankfurt", "60549", "Unterschweinstiege 8");
//        EnrolmentContactPointsPhoneTEV enrolmentContactPointsPhoneTEV = new EnrolmentContactPointsPhoneTEV( "PRIVATE", "Mobile", true) ;
//        EnrolmentContactPointsEmailTEV enrolmentContactPointsEmailTEV = new EnrolmentContactPointsEmailTEV( "PRIVATE", "Email", true, "ertete"+"@yobmail.com" );
//        enrolmentContactPoints.add( enrolmentContactPointsPost);
//        enrolmentContactPoints.add( enrolmentContactPointsEmailTEV);
//        enrolmentContactPoints.add( enrolmentContactPointsPhoneTEV);
//        return enrolmentContactPoints;
//    }
//
//    public EnrolmentContactPointsPost createContactPointPostForEnrolment() {
//        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
//        EnrolmentContactPointsPost enrolmentContactPointPost = new EnrolmentContactPointsPost( "PRIVATE", "Post", true,"DE", "Frankfurt", "60549", "Unterschweinstiege 9");
//        return enrolmentContactPointPost;
//    }
//
//    public EnrolmentContactPointsEmail createContactPointEmailForEnrolment() {
//        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
//        EnrolmentContactPointsEmail enrolmentContactPointEmail = new EnrolmentContactPointsEmail( "PRIVATE", "Email", true,"trst445"+"@yopmail.com" );
//        return enrolmentContactPointEmail;
//    }
//
//    public EnrolmentContactPointsPhone createContactPointPhoneForEnrolment() {
//        ArrayList<EnrolmentContactPoints> enrolmentContactPoints = new ArrayList<>(  );
//        EnrolmentContactPointsPhone enrolmentContactPointPhone = new EnrolmentContactPointsPhone( "PRIVATE", "Mobile", true) ;
//        return enrolmentContactPointPhone;
//    }
//
//    public EnrolmentContext createTenantForEnrolment(String tenant){
//        context = new EnrolmentContext();
//        context.setTenantId(tenant);
//        return context;
//    }
//============================================================================================================

//    @Autowired
//    private EnrolmentPayload enrolmentPayload;



    private String lastLang;
    private String lastValidCountry;
    private EnrolmentPayload enrolmentPayload;
    private ArrayList<EnrolmentAliasesTEV> aliases = new ArrayList<>(  );
    private ArrayList<EnrolmentContactPointsTEV> contactPoints = new ArrayList<>( );
//    enrolmentPayload= new EnrolmentPayload();
    private String dateOfBirth;
    private String enrollmentSourceCode;
    private String firstName;
    private String lastName;
    private String language;
    private String gender;
    private String allInOnePermission;

    public EnrolmentTEV() {
    }
    public EnrolmentTEV(String lastLang,String lastValidCountry,ArrayList<EnrolmentAliasesTEV> aliases,ArrayList<EnrolmentContactPointsTEV> contactPoints,String dateOfBirth,
                     String enrollmentSourceCode, String firstName, String lastName,String language, String gender, String allInOnePermission) {

        this.lastLang=lastLang;
        this.lastValidCountry=lastValidCountry;
//        this.enrolmentPayload=enrolmentPayload;
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
//        public ArrayList<EnrolmentAliasesTEV> createAliasesForEnrolment(String aliaseName){
//
//        ArrayList<EnrolmentAliasesTEV> enrolmentAliases = new ArrayList<EnrolmentAliasesTEV>();
//        enrolmentAliases.add(new EnrolmentAliasesTEV(aliaseName));
//
//            enrolmentPayload =new EnrolmentPayload();
////            enrolmentPayload.getAliases();
//        return enrolmentAliases;
//    }

    public EnrolmentContactPointsPostTEV createContactPointPostForEnrolment() {

        ArrayList<EnrolmentContactPointsTEV> enrolmentContactPoints = new ArrayList<>(  );
        EnrolmentContactPointsPostTEV enrolmentContactPointsPostTEV = new EnrolmentContactPointsPostTEV( "PRIVATE", "Post", true,"UK", "Frankfurt", "60549", "Unterschweinstiege 8");
        enrolmentPayload =new EnrolmentPayload();

        return enrolmentContactPointsPostTEV;
    }

    public EnrolmentContactPointsEmailTEV createContactPointEmailForEnrolment(String email) {

        ArrayList<EnrolmentContactPointsTEV> enrolmentContactPoints = new ArrayList<>(  );
        EnrolmentContactPointsEmailTEV enrolmentContactPointsEmailTEV = new EnrolmentContactPointsEmailTEV( "PRIVATE", "Post", email,true);
        enrolmentPayload =new EnrolmentPayload();
//        enrolmentPayload.getContactPoints();
        return enrolmentContactPointsEmailTEV;
    }

    public EnrolmentContactPointsPhoneTEV createContactPointPhoneForEnrolment(String internationalDialingPrefix, String localNumber) {

        ArrayList<EnrolmentContactPointsTEV> enrolmentContactPoints = new ArrayList<>(  );
        EnrolmentContactPointsPhoneTEV enrolmentContactPointPhone = new EnrolmentContactPointsPhoneTEV( "PRIVATE", "Mobile", internationalDialingPrefix,localNumber,true) ;
        enrolmentPayload =new EnrolmentPayload();
//        enrolmentPayload.getContactPoints();
        return enrolmentContactPointPhone;
    }

}
