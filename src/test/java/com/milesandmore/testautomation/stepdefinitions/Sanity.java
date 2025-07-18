package com.milesandmore.testautomation.stepdefinitions;

import io.cucumber.java.en.Given;

public class Sanity {
    @Given("this is a test")
    public void this_is_a_test() {
        System.out.println("Sanity test is working ✅");
    }
}
