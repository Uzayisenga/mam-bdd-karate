package mamcom_BDDSpring.DataModel_API_Request;

import mamcom_BDDSpring.GlobalFunctions.GlobalFunctions;

public class Payload {

    private static GlobalFunctions globalFunctions;
    public  static String email=  globalFunctions.generateRandomString( 10 );
    public static String UDHEnrolement(){
        return "{\n" +
                "   \"initialPassword\":\"Test@1234\",\n" +
                "   \"userName\":email,\n" +
                "   \"profile\":{\n" +
                "      \"generalDetails\":{\n" +
                "         \"action\":\"INSERT\",\n" +
                "         \"firstName\":\"Alpha123\",\n" +
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
                "}";

    }
}
