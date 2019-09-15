package java20190818;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    private WebDriver driver;
    public ScreenShot(WebDriver driver){
        this.driver = driver;
    }
    public void takeScreenShot(String screenPath){
        try {
            File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotAs,new File(screenPath));
            System.out.println("Screen shot filesPath: "+screenPath);
        } catch (IOException e) {
            System.out.println("Screen shot error: "+screenPath);
        }
    }
    public void takeScreenShot(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        long time = new Date().getTime();
        String format = df.format(time);
        String screenName = format+".jpg";
        File file = new File("output/snapshot");
        if (!file.exists()) {
            file.mkdirs();
        }
        String screenPath = file.getAbsolutePath()+"\\"+screenName;
        this.takeScreenShot(screenPath);
    }
}
