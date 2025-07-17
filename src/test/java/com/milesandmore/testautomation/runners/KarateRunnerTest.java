package com.milesandmore.testautomation.runners;

import com.intuit.karate.junit5.Karate;
import java.io.File;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import org.junit.jupiter.api.TestFactory;

import static com.intuit.karate.resource.ResourceUtils.findFeatureFiles;

public class KarateRunnerTest {

    @Karate.Test
    Karate testAllApproved() {
        return Karate.run("classpath:features").tags("@Approved").relativeTo(getClass());
    }

    Stream<Karate> runAllApprovedTests() {
        File featureDir = new File("src/test/resources/features");

        List<File> approvedFeatureFiles = findFeatureFiles(featureDir);

        return approvedFeatureFiles.stream()
                .map(file -> Karate.run(file.getPath())
                        .tags("@Approved")
                        .relativeTo(getClass()));
    }

    private List<File> findFeatureFiles(File dir) {
        return Stream.ofNullable(dir.listFiles())
                .flatMap(Stream::of)
                .filter(file -> file.isFile() && file.getName().endsWith(".feature"))
                .collect(Collectors.toList());
    }
}
