package com.milesandmore.testautomation.runners;

import com.intuit.karate.junit5.Karate;

public class KarateRunnerTest {

    @Karate.Test
    Karate runApprovedTests() {
        // Since Jenkins already downloads only approved tests from Zephyr,
        // we don't need to filter by tags - just run all downloaded features
        return Karate.run("classpath:features")  // This tells Karate to look in src/test/resources/features
                .outputCucumberJson(true);       // For Zephyr upload
    }

    // Alternative approach if you want to keep tag filtering
    @Karate.Test
    Karate runApprovedTestsWithTags() {
        return Karate.run("classpath:features")
                .tags("@Approved")               // Only if your feature files have this tag
                .outputCucumberJson(true);
    }
}