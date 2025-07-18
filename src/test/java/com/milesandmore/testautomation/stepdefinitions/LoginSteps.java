package com.milesandmore.testautomation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.milesandmore.testautomation.stepdefinitions.hooks.Hooks; // Import your Hooks class

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginSteps {

    // WebDriver instance from Hooks
    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriverWait
    public LoginSteps() {
        // Ensure driver is not null before initializing WebDriverWait
        if (driver != null) {
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased wait time for robustness
        } else {
            // This should ideally not happen if Hooks.setup() runs correctly before scenarios
            System.err.println("WebDriver is null in LoginSteps constructor. Ensure Hooks.setup() is executed.");
        }
    }

    @Given("User launch MAM page")
    public void user_launch_mam_page() {
        if (driver == null) {
            // Re-initialize driver if it's null (e.g., if running a single scenario outside a full suite)
            // In a typical Cucumber setup with Hooks, this shouldn't be necessary.
            // This is a fallback.
            Hooks hooks = new Hooks();
            hooks.setup();
            driver = Hooks.driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
        System.out.println("Navigating to MAM page...");
        // Replace with your actual MAM page URL
        driver.get("https://www-uat1.miles-and-more.com/de/en.html"); // Example URL, adjust as needed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body"))); // Wait for page to load
        System.out.println("MAM page launched.");
    }

    @Given("User clicks on Login button")
    public void user_clicks_on_login_button() {
        System.out.println("Clicking on Login button...");
        // Replace with actual locator for your Login button
        By loginButton = By.xpath("//a[contains(@href, 'login.html') and contains(text(), 'Login')]");
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        System.out.println("Login button clicked.");
    }

    @Given("User clicks on Login with email address")
    public void user_clicks_on_login_with_email_address() {
        System.out.println("Clicking on 'Login with email address'...");
        // Replace with actual locator for "Login with email address" if it's a separate button/link
        // This step might be redundant if the previous "Login button" directly leads to email login form.
        // Adjust based on your actual application flow.
        // Example: By.id("loginWithEmailLink")
        // No action for now, assuming previous step leads directly to email/password fields.
        System.out.println("'Login with email address' step handled (might be implicit).");
    }

    @Given("User enter email address & password")
    public void user_enter_email_address_password(DataTable dataTable) {
        System.out.println("Entering email and password...");
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String email = data.get(0).get("Email Address");
        String password = data.get(0).get("Password");

        // Replace with actual locators for email and password fields
        By emailField = By.id("email"); // Example ID, adjust as needed
        By passwordField = By.id("password"); // Example ID, adjust as needed

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        System.out.println("Email and password entered.");
    }

    @Given("clicks on Login button")
    public void clicks_on_login_button() {
        System.out.println("Clicking on final Login button...");
        // This might be the submit button on the login form
        By submitLoginButton = By.id("loginSubmit"); // Example ID, adjust as needed
        wait.until(ExpectedConditions.elementToBeClickable(submitLoginButton)).click();
        System.out.println("Final Login button clicked.");
    }

    @Given("User clicks on Spend Miles button")
    public void user_clicks_on_spend_miles_button() {
        System.out.println("Clicking on 'Spend Miles' button...");
        // Replace with actual locator for Spend Miles button
        By spendMilesButton = By.xpath("//a[contains(text(), 'Spend Miles')]"); // Example XPath
        wait.until(ExpectedConditions.elementToBeClickable(spendMilesButton)).click();
        System.out.println("'Spend Miles' button clicked.");
    }

    @Given("User clicks on Hotels button")
    public void user_clicks_on_hotels_button() {
        System.out.println("Clicking on 'Hotels' button...");
        // Replace with actual locator for Hotels button
        By hotelsButton = By.xpath("//a[contains(text(), 'Hotels')]"); // Example XPath
        wait.until(ExpectedConditions.elementToBeClickable(hotelsButton)).click();
        System.out.println("'Hotels' button clicked.");
    }

    @Given("User enters destination in hotels page")
    public void user_enters_destination_in_hotels_page() {
        System.out.println("Entering destination in hotels page...");
        // Replace with actual locator for destination input field and a sample destination
        By destinationInput = By.id("destinationInput"); // Example ID
        String destination = "New York"; // Example destination
        wait.until(ExpectedConditions.visibilityOfElementLocated(destinationInput)).sendKeys(destination);
        System.out.println("Destination entered: " + destination);
    }

    @Given("User add the adult")
    public void user_add_the_adult() {
        System.out.println("Adding adult(s)...");
        // Replace with actual locator for adding adults (e.g., a plus button or dropdown)
        // This is a placeholder, you'll need to implement the actual interaction
        By addAdultButton = By.id("addAdult"); // Example ID
        wait.until(ExpectedConditions.elementToBeClickable(addAdultButton)).click();
        System.out.println("Adult added.");
    }

    @Given("User clicks on search for hotel button")
    public void user_clicks_on_search_for_hotel_button() {
        System.out.println("Clicking on 'Search for hotel' button...");
        // Replace with actual locator for search button
        By searchHotelButton = By.id("searchHotelButton"); // Example ID
        wait.until(ExpectedConditions.elementToBeClickable(searchHotelButton)).click();
        System.out.println("'Search for hotel' button clicked.");
    }

    // You will need to add more step definitions here for other undefined steps
    // that appear in your Cucumber reports, such as:
    // @Given("User verify Miles and More logo in header")
    // @Given("User verify Earn miles...")
    // etc.
}
