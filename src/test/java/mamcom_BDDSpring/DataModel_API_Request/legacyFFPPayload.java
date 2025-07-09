package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.GlobalFunctions.GlobalFunctions;
import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@PageObjects
public class legacyFFPPayload {

    @Autowired
    private GlobalFunctions globalFunctions;





    public  String LegacyFFPEnrolement(){
        String firstname =globalFunctions.generateRandomString( 10 );
        return "{\n    " +
                "\"dateOfBirth\": \"1990-09-01\",\n  " +
                "  \"language\": \"D\",\n  " +
                "  \"firstName\": \""+firstname+"\",\n" +
                "  \"middleName\":\"klkl\",\n    " +
                "\"lastName\": \"USER\",\n  " +
                "  \"academicTitle\": \"Dr.\",\n " +
                "   \"nobilityTitle\": \"Tesn8908\",\n  " +
                "  \"gender\": \"MALE\",\n   " +
                " \"contactPoints\": [\n " +
                "       {\n            " +
                "\"usage\": \"PRIVATE\",\n        " +
                "    \"channel\": \"Post\",\n         " +
                "   \"standard\": true,\n          " +
                "  \"country\": \"HR\",\n         " +
                "   \"city\": \"München\",\n       " +
                "     \"zipCode\":\"52028\"\n       " +
                " },\n    " +
                "    {\n      " +
                "      \"usage\": \"PRIVATE\",\n     " +
                "       \"channel\": \"Post\",\n      " +
                "      \"standard\": false,\n          " +
                "  \"country\": \"PL\",\n        " +
                "    \"city\": \"München\",\n       " +
                "     \"zipCode\":\"53-783\"\n     " +
                "   },\n   " +
                "     {\n       " +
                " \"usage\": \"PRIVATE\",\n" +
                "        \"channel\": \"Mobile\",\n    " +
                "    \"internationalDialingPrefix\": \"+49\",\n " +
                "       \"areaCode\": \"151\",\n     " +
                "   \"localNumber\": \"4511898909\",\n  " +
                "      \"standard\": true,\n     " +
                "   \"bounced\": false\n    }\n   " +
                " ],\n " +
                "   \"enrollmentSourceCode\": \"M0383\",\n  " +
                "  \"allInOnePermission\": true\n   " +
                " \n} ";

    }
}
