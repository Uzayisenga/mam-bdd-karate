package mamcom_BDDSpring.dataProvider;

//import com.mamcom_BDDSpring.DataModel_API_Request.*;
import mamcom_BDDSpring.DataModel_API_Request.EnrolmentContactPoints;
import mamcom_BDDSpring.DataModel_API_Request.EnrolmentContext;
import mamcom_BDDSpring.GlobalFunctions.GlobalFunctions;
import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Data
@PageObjects
public class SampleSecound {

    @Autowired
    private GlobalFunctions globalFunctions;

    private String mail;
    private String language;
    private String firstName;
    private String lastName;
    private String gender;
    private ArrayList<SanpleClass> aliases = new ArrayList<>(  );
    private ArrayList<EnrolmentContactPoints> contactPoints = new ArrayList<>(  );
    private EnrolmentContext context =new EnrolmentContext("D", "DE", "LH");
    private String enrollmentSourceCode;

    public SampleSecound() {
    }

    public SampleSecound(String dateOfBirth, String language,String firstName, String lastName, String gender,
                     ArrayList<SanpleClass> aliases, ArrayList<EnrolmentContactPoints> contactPoints,EnrolmentContext context,
                     String enrollmentSourceCode) {
//        this.dateOfBirth = dateOfBirth;
        this.language = language;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.aliases = aliases;
        this.contactPoints = contactPoints;
        this.context = context;
        this.enrollmentSourceCode = enrollmentSourceCode;
    }

    public ArrayList<SanpleClass> createAliasesForEnrolment(String mail){
        ArrayList<SanpleClass> sanpleClass = new ArrayList<SanpleClass>();
        sanpleClass.add(new SanpleClass(mail));
        return sanpleClass;
    }


}
