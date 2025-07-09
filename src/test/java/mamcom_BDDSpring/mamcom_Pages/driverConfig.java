package mamcom_BDDSpring.mamcom_Pages;


import mamcom_BDDSpring.annotations.BeanScope;
import mamcom_BDDSpring.annotations.LazyAutowired;
import mamcom_BDDSpring.annotations.LazyConfiguration;
import mamcom_BDDSpring.config.PropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.time.Duration;

@LazyConfiguration
public class driverConfig {


    @LazyAutowired
    private PropertyFile propertyFile;

    @LazyAutowired
    private WebDriver driver;


    @BeanScope
    @ConditionalOnProperty(name="browser", havingValue= "chrome")
    public WebDriver chromeWebDriver() throws InterruptedException {

        ChromeOptions options=new ChromeOptions();

        if(SystemUtils.IS_OS_LINUX) {
            ///Jenkins Server Setup:
            System.setProperty("webdriver.chrome.driver", System.getenv("CHROMEDRIVER_HOME"));
            System.setProperty("java.awt.headless", "true");
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);

            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // disable GPU Features
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model
            options.addArguments("--headless=new"); // Use new implementation from Chrome Headless
            options.addArguments("--enable-logging=stderr"); // Set logging channel
            options.addArguments("--v=2"); // 
            options.addArguments("--disable-sync"); // 
            options.addArguments("--password-store=basic"); // 
            options.addArguments("--disable-features=dbus,MediaRouter"); // 
        } else {
            //System.setProperty("webdriver.chrome.driver", propertyFile.getChromedriverpath());
            System.setProperty("java.awt.headless", "false");
        }

        WebDriverManager.chromedriver().setup();

        
//        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//        options.addExtensions(new File("C:\\proxy\\CrxExtension.crx"));
       return new ChromeDriver(options);

    }

    @BeanScope
    @ConditionalOnProperty(name="browser", havingValue= "edge")
    public WebDriver EdgeDriver(){
//        System.setProperty("webdriver.edge.driver", propertyFile.getEdgedriverpath());
        WebDriverManager.edgedriver().setup();
        EdgeOptions options  = new EdgeOptions();

//        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return new EdgeDriver(options);
    }



    @BeanScope
    public WebDriverWait driverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(propertyFile.getTimeout()));
    }


    @BeanScope
    public String getReportConfigPath(){
        String reportConfigPath = propertyFile.getReportConfigPath();
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}
