package com.milesandmore.testautomation.stepdefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before; // <-- this was missing
import io.cucumber.java.Scenario;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.OutputType; // <-- this was missing
import org.openqa.selenium.TakesScreenshot; // <-- this was missing
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        driver.quit();
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Screenshot");
            } catch (Exception e) {
                System.err.println("❌ Failed to attach screenshot: " + e.getMessage());
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
