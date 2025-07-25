package com.milesandmore.testautomation.runners;


import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

class DownloadRunner {
    @Karate.Test
    Karate download() {
        return Karate.run("classpath:features/karate-workaround.feature")
                .relativeTo(getClass())
                .systemProperty("jiraBaseUrl", "https://api.zephyrscale.smartbear.com/v2")
                .systemProperty("projectKey", "SCRUM")
                .systemProperty("approvalStatus", "Approved")
                .systemProperty("featuresDir", "src/test/resources/features")
                .systemProperty("token", System.getenv("ZEPHYR_TOKEN"));
    }
}

