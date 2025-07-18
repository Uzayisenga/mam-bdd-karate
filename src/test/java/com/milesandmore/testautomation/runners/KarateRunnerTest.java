package com.milesandmore.testautomation.runners;

import com.intuit.karate.junit5.Karate;

public class KarateRunnerTest {

    @Karate.Test
    Karate runApprovedTests() {
        return Karate.run("classpath:features")  // This tells Karate to look in src/test/resources/features
                .tags("@Approved")               // If you want to filter by tag
                .outputCucumberJson(true);       // For Zephyr upload
    }
}
