package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

import java.util.ArrayList;

@Data
@PageObjects
public class EnrolmentPayloadForTravelIdUser {

    private String language;
    private String enrollmentSourceCode;
    private String oneId;
    private String password;
    private String gender;
    private String academicTitle;
    //
    private String title;
    private String street;
    //
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean allInOnePermission;
    private String bpVersion;
    //
    private String tenantId;
    private ArrayList<EnrolmentContactPointsForTravelidUser> contactPoints=new ArrayList<>();

    public EnrolmentPayloadForTravelIdUser() {
        System.out.println("Empty contractor ");
    }
    public EnrolmentPayloadForTravelIdUser(String language,String enrollmentSourceCode,String oneId,String password,
                              String gender,String academicTitle,String firstName,String lastName,String tenantId,String dateOfBirth,boolean allInOnePermission,String bpVersion,ArrayList<EnrolmentContactPointsForTravelidUser> contactpoints, String title, String street) {
        this.language = language;
        this.enrollmentSourceCode = enrollmentSourceCode;
        this.oneId = oneId;
        this.password = password;
        this.gender = gender;
        this.academicTitle = academicTitle;
        this.title=title;
        this.street =street;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth=dateOfBirth;
        this.allInOnePermission = allInOnePermission;
        this.bpVersion=bpVersion;
        this.tenantId = tenantId;
        this.contactPoints=contactPoints;

    }
    public ArrayList<EnrolmentContactPointsForTravelidUser> traveliduserContactsPoints(String chennal,String email,boolean standard,String usage){
        ArrayList<EnrolmentContactPointsForTravelidUser> contactPoints = new ArrayList<>();
        contactPoints.add(new EnrolmentContactPointsForTravelidUser(chennal,email,standard,usage));
        return contactPoints;
    }

}
