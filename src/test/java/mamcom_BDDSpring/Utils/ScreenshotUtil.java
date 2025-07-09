package mamcom_BDDSpring.Utils;

import mamcom_BDDSpring.annotations.LazyComponent;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@LazyComponent
public class ScreenshotUtil {

    @Autowired
    private ApplicationContext ctsx;

    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenshot(String testName) throws IOException {
        File source=this.ctsx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(source,this.path.resolve(testName+".png").toFile());
    }

    public byte[] getScreenshot(){
        return this.ctsx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}
