package com.milesandmore.testautomation.runners;

// Ensure these imports are correct for your JUnit Platform / Cucumber setup
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME; // Added for tag filtering

@Suite
@IncludeEngines("cucumber")
// Corrected: Use SelectClasspathResource to find feature files as classpath resources
@SelectClasspathResource("features") // Ensure this points to your 'features' folder in src/test/resources
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
// Standardized JSON report output path to 'target/cucumber-report/cucumber.json'
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumber-report/cucumber.json")
// Standardized HTML report path for consistency, placing it in the same 'target/cucumber-report' directory.
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:target/cucumber-report/cucumber.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.milesandmore.testautomation.stepdefinitions") // Correct package for your step definitions
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@failingTest") // Added to run only scenarios with @failingTest tag
public class KarateRunnerTest {
    // This class remains empty. Cucumber will discover and run tests based on annotations.
}
