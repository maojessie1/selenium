package java20190908002;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Screenshot {
    private WebDriver driver;
    Screenshot(WebDriver driver){
        this.driver = driver;
    }

    private void takeScreenShot(String screenPath){
        try {
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile,new File(screenPath));
        } catch (IOException e) {
            System.out.println("Screen shot error :"+screenPath);
        }
    }

    public void takeScreenShot(){
        String screenName = String.valueOf(new Date().getTime())+".jpg";
        File dir = new File("test-out/snapshot");
        if (!dir.exists())
        {
            dir.mkdirs();
        }
        String screenPath = dir.getAbsolutePath()+"/"+screenName;
        this.takeScreenShot(screenPath);
    }
}
