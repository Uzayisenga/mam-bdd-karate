package com.milesandmore.testautomation.stepdefinitions;

import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

public class LoginSteps {
    @Given("the user is on the login page")
    public void userOnLoginPage() {
        System.out.println("User navigates to login page");
    }

    @When("they enter valid credentials")
    public void enterValidCredentials() {
        System.out.println("User enters valid username and password");
    }

    @Then("they should be redirected to the dashboard")
    public void redirectedToDashboard() {
        System.out.println("User is redirected to the dashboard");
    }

    @Given("the user is on the login page and fail")
    public void userOnLoginFailPage() {
        System.out.println("User fail to login page");
        assertThat(true).isFalse(); // Simulating a failure for demonstration



    }
    @Given("the wrong user is on the login page")
    public void the_wrong_user_is_on_the_login_page() {
        System.out.println("the wrong user is on the login page");
    }
    @Given("url {string}")
    public void url(String string) {
        System.out.println("the wrong user is on the login page");
    }
    @Given("print {string}")
    public void print(String string) {
        System.out.println("the wrong user is on the login page");
    }
    @Given("def message = {string}")
    public void def_message(String string) {
        System.out.println("the wrong user is on the login page");
    }
    @Given("match message == {string}")
    public void match_message(String string) {
        System.out.println("the wrong user is on the login page");
    }



}
