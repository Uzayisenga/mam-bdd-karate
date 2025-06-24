package com.milesandmore.testautomation.runners;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource; // THIS IS THE KEY CHANGE
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
// Removed: import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME; // No longer needed for specific tag filtering

@Suite
@IncludeEngines("cucumber")
// Corrected: Use SelectClasspathResource to find feature files as classpath resources
@SelectClasspathResource("features") // Ensure this points to your 'features' folder in src/test/resources
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumber-report/cucumber.json") // Standardized JSON report path
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.milesandmore.testautomation.stepdefinitions") // Correct package for your step definitions
// Removed: @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@failingTest") // Removed filter to run all tests
public class KarateRunnerTest {

}
