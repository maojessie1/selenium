package java20190911;

import java20190908001.SetP;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        SetP.setP();
        SeleniumDriver sd = new SeleniumDriver();
        driver = sd.getDriver();
        driver.navigate().to("file:///C:/Users/123/Desktop/demo.html");
    }

    @Test
    public void test1(){
        PageDemo pd = new PageDemo(driver);
        ScreenShot ss = new ScreenShot(driver);
        ss.takeScreenshot();
        pd.input();
        ss.takeScreenshot();
    }

    @AfterMethod
    public void afterMethrod(){
        driver.close();
        driver.quit();
    }
}
