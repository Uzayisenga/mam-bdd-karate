package com.mamcom_BDDSpring.Utils;

import com.mamcom_BDDSpring.annotations.BeanScope;
import com.mamcom_BDDSpring.annotations.LazyAutowired;
import com.mamcom_BDDSpring.annotations.PageObjects;
import com.mamcom_BDDSpring.config.PropertyFile;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
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
