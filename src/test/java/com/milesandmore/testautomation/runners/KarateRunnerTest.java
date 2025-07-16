package com.milesandmore.testautomation.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")  // folder inside src/test/resources
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.milesandmore.testautomation.stepdefinitions")
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty,json:target/cucumber/cucumber.json,html:target/cucumber/cucumber.html"
)

//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@failingTest")
public class KarateRunnerTest {
}
