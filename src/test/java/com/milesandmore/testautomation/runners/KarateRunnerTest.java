package com.milesandmore.testautomation.runners;

import com.intuit.karate.junit5.Karate;

public class KarateRunnerTest {

    @Karate.Test
    Karate runApprovedTests() {
        return Karate.run("classpath:features")
                .tags("@Approved")
                .outputCucumberJson(true);
    }
}
