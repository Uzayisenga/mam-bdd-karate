package com.milesandmore.testautomation.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty," +
        "html:target/cucumber-reports/html/report.html," +
        "json:target/cucumber-reports/json/cucumber.json," +
        "junit:target/cucumber-reports/junit/cucumber.xml")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.milesandmore.testautomation.stepdefinitions")
public class KarateRunnerTest {
}