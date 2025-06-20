package com.milesandmore.testautomation.stepdefinitions.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

// Import WebDriverManager
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        // --- WebDriverManager handles downloading and setting the path ---
        WebDriverManager.chromedriver().setup(); // This line replaces System.setProperty() and manual download

        ChromeOptions options = new ChromeOptions();

        // Essential arguments for headless execution and containerized environments
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-web-security");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-background-timer-throttling");
        options.addArguments("--disable-backgrounding-occluded-windows");
        options.addArguments("--disable-renderer-backgrounding");
        options.addArguments("--disable-background-networking");
        options.addArguments("--disable-ipc-flooding-protection");
        options.addArguments("--start-maximized"); // Maximize is for visible browser, but often harmless in headless

        try {
            driver = new ChromeDriver(options);
        } catch (Exception e) {
            System.err.println("Failed to initialize ChromeDriver: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Chrome driver initialization failed", e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            // Take screenshot for failed scenarios
            if (scenario.isFailed()) {
                try {
                    if (driver instanceof TakesScreenshot) {
                        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        scenario.attach(screenshot, "image/png", "Screenshot");
                        System.out.println("✅ Screenshot attached successfully for failed scenario: " + scenario.getName());
                    } else {
                        System.err.println("❌ Driver instance does not support taking screenshots.");
                    }
                } catch (Exception e) {
                    System.err.println("❌ Failed to attach screenshot: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error closing driver: " + e.getMessage());
            }
        }
    }
}