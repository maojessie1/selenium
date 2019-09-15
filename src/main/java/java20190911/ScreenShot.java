package java20190911;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.apache.commons.io.FileUtils.*;

public class ScreenShot {
    WebDriver driver;
    public ScreenShot(WebDriver driver){
        this.driver =driver;
    }

    private void takeScreenShot(String screenPath){
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile,new File(screenPath));
        } catch (IOException e) {
            System.out.println("Screen shot error: "+screenPath);
        }

    }
    public void takeScreenshot(){
        String screenName = String.valueOf(new Date().getTime()) +".jpg";
        File dir = new File("test-out/snapshot");
        if(!dir.exists())
            dir.mkdirs();
        String screenPath = dir.getAbsolutePath()+ "/" +screenName;
        this.takeScreenShot(screenPath);
    }
}
