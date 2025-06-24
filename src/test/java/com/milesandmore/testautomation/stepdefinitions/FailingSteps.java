package com.milesandmore.testautomation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.milesandmore.testautomation.stepdefinitions.hooks.Hooks; // Import your Hooks class
import org.junit.jupiter.api.Assertions; // Import JUnit Assertions for deliberate failure

public class FailingSteps {

    // You can use the WebDriver from your Hooks class
    private WebDriver driver = Hooks.driver;

    @Given("the user is on {string}")
    public void theUserIsOn(String url) {
        if (driver != null) {
            System.out.println("Navigating to: " + url);
            driver.get(url);
            // Add a small wait to ensure page loads before next step, if needed
            try {
                Thread.sleep(1000); // Wait for 1 second, for demonstration
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted during sleep: " + e.getMessage());
            }
        } else {
            System.err.println("WebDriver is null in Given step.");
            Assertions.fail("WebDriver was not initialized."); // Fail if driver is null
        }
    }

    @Then("the system should report a deliberate failure")
    public void theSystemShouldReportADeliberateFailure() {
        System.out.println("Intentionally failing this test case to verify screenshot and log attachment.");
        // This assertion will always fail, as 'true' is not 'false'
        Assertions.assertFalse(true, "This is a deliberate failure for demonstration purposes.");
    }
}
