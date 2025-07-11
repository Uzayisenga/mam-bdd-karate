package com.milesandmore.testautomation.stepdefinitions;

import com.milesandmore.testautomation.stepdefinitions.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
//import com.milesandmore.testautomation.stepdefinitions.hooks;
import org.junit.jupiter.api.Assertions;

public class FailingSteps {

    @Given("the user is on {string}")
    public void theUserIsOn(String url) {
        System.out.println("Hooks class: " + Hooks.class.getName());
        System.out.println("Hooks.driver value: " + Hooks.driver);

        WebDriver driver = Hooks.driver;

        if (driver != null) {
            System.out.println("Navigating to: " + url);
            driver.get(url);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted during sleep: " + e.getMessage());
            }
        } else {
            System.err.println("WebDriver is null in Given step.");
            Assertions.fail("WebDriver was not initialized.");
        }
    }

    @Then("the system should report a deliberate failure")
    public void theSystemShouldReportADeliberateFailure() {
        System.out.println("Intentionally failing this test case to verify screenshot and log attachment.");
        Assertions.assertFalse(false, "This is a deliberate failure for demonstration purposes.");
    }
}
