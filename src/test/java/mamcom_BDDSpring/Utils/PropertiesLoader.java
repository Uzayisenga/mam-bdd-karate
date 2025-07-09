package mamcom_BDDSpring.Utils;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

import java.util.Properties;
@Data
@PageObjects
public class PropertiesLoader {

    private static String env=System.getProperty("env");
    private static final String DEFAULT_ENV="uat1";
    private static Properties properties;

    static {
        if(env==null){
            env=DEFAULT_ENV;
        }
//
//        try {
//            properties=new Properties();
//            InputStream inputStream=PropertiesLoader.class.getClassLoader().getResourceAsStream("application-"+env+".properties");
//            properties.load(inputStream);
//        } catch (IOException e) {
//            throw new RuntimeException("Unable to load"+e.getCause());
//        }
    }
//
//    public static String getProperty(String url){
//         properties.getProperty(url);
//        return url;
//    }
}
