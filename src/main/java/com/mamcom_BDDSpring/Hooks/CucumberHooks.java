//package com.mamcom_BDDSpring.Hooks;
//
//import com.mamcom_BDDSpring.Utils.ScreenshotUtil;
//import com.mamcom_BDDSpring.annotations.BeanScope;
//import com.mamcom_BDDSpring.annotations.LazyAutowired;
//import com.mamcom_BDDSpring.annotations.LazyConfiguration;
//import com.mamcom_BDDSpring.config.PropertyFile;
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.apache.commons.io.FileUtils;
//import org.junit.AfterClass;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.PageLoadStrategy;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.Augmenter;
//import org.openqa.selenium.support.PageFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Primary;
//import org.springframework.util.FileCopyUtils;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import javax.annotation.PostConstruct;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//
//
//public class CucumberHooks {
//
//    @LazyAutowired
//    private ScreenshotUtil screenshotUtil;
//
//    @LazyAutowired
//    private ApplicationContext applicationContext;
//
//    @LazyAutowired
//    private PropertyFile propertyFile;
//
//    @LazyAutowired
//    private WebDriver driver;
//
//
//
//
//
//    @Value("${screenshot.path}")
//    private Path path;
//
//    @AfterStep
//    public void afterStep(Scenario scenario) throws IOException, InterruptedException {
//        if(scenario.isFailed()){
//        System.out.println("After test");
//       scenario.attach(this.screenshotUtil.getScreenshot(),"image/png", scenario.getName());
//    }}
//
//
////    @After
////    public void afterScenario(){
////        this.applicationContext.getBean(WebDriver.class).quit();
////    }
//
////    @BeforeEach
////    public void setup(){
////
////    }
////
////    @AfterEach
////    public void teardown(){
////        this.applicationContext
////                .getBean(WebDriver.class)
////                .quit();
////    }
//
//
//
//
//}
