package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;
import mamcom_BDDSpring.GlobalFunctions.GlobalFunctions;
import mamcom_BDDSpring.annotations.PageObjects;
import org.springframework.beans.factory.annotation.Autowired;
@Data
@PageObjects
public class udhPayload{
    @Autowired
    private GlobalFunctions globalFunctions;



    public static String email;



    public String udhEnrolement(){
        String firstname =globalFunctions.generateRandomString( 10 );
        email =firstname+"@yopmail.com";



       return "{\n" +
               "   \"initialPassword\":\"Test@1234\",\n" +
             "   \"userName\":\""+email+"\",\n" +
               "   \"profile\":{\n" +
               "      \"generalDetails\":{\n" +
               "         \"action\":\"INSERT\",\n" +
               "         \"firstName\":\""+firstname+"\",\n" +
               "         \"lastName\":\"Testuser\",\n" +
               "         \"dateOfBirth\":\"2003-01-01\",\n" +
               "         \"language\":{\n" +
               "            \"catalogueName\":\"LANGUAGE\",\n" +
               "            \"value\":\"EN\"\n" +
               "         },\n" +
               "         \"gender\":{\n" +
               "            \"value\":\"MALE\"\n" +
               "         }\n" +
               "      },\n" +
               "      \"postalAddresses\":[\n" +
               "         {\n" +
               "            \"action\":\"INSERT\",\n" +
               "            \"addressType\":{\n" +
               "               \"value\":\"BUSINESS\"\n" +
               "            },\n" +
               "            \"country\":{\n" +
               "               \"value\":\"US\"\n" +
               "            }\n" +
               "         }\n" +
               "      ]\n" +
               "   }\n" +
               "   \n" +
               "}" ;
    }
}
