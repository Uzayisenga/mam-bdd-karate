package com.milesandmore.testautomation.stepdefinitions.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Detect CI or local environment
        boolean isCI = System.getenv("CI") != null || System.getenv("JENKINS_HOME") != null;

        if (isCI) {
            options.addArguments("--headless"); // Use headless only in CI
            options.addArguments("--disable-gpu");
        }

        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-software-rasterizer");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        try {
            driver = new ChromeDriver(options);
            System.out.println("✅ ChromeDriver initialized successfully.");
        } catch (Exception e) {
            System.err.println("❌ Failed to initialize ChromeDriver: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Chrome driver initialization failed", e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            if (scenario.isFailed()) {
                try {
                    if (driver instanceof TakesScreenshot) {
                        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        scenario.attach(screenshot, "image/png", "Screenshot");
                        System.out.println("✅ Screenshot attached for failed scenario: " + scenario.getName());
                    } else {
                        System.err.println("⚠️ WebDriver does not support screenshots.");
                    }
                } catch (Exception e) {
                    System.err.println("❌ Failed to attach screenshot: " + e.getMessage());
                }
            }

            try {
                driver.quit();
                System.out.println("🧹 WebDriver session closed.");
            } catch (Exception e) {
                System.err.println("⚠️ Error closing WebDriver: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }
}
