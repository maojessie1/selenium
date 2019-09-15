package java20190908001;

import java20190818.Assertion;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * ≈‰÷√‰Ø¿¿∆˜
 */
public class StepOne {
    static SeleniumDriver d;
    static WebDriver driver;

    @BeforeClass
    public static void startBrowser() {
        SetP.setP();
        d = new SeleniumDriver();
        driver = d.getDriver();
//        driver.navigate().to("https://www.baidu.com");
        driver.navigate().to("file:///C:/Users/123/Desktop/demo1.html");
        driver.manage().timeouts().setScriptTimeout(Config.waitTime, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public static void testinput() {
        AssertionDemo.verifyEquals("1", "1", "jflkdajfdlksa;");

//        Log.logError("testerror");
        DemoPage dp = new DemoPage(driver);
        ScreenShot ss = new ScreenShot(driver);
        ss.takeScreenshot();
        Log.logInfo("testinfo");
        dp.input();
        Assertion.verifyEquals("2", "2");
        ss.takeScreenshot();
        Log.logWarn("testwarn");
    }

    @AfterClass
    public void testEnd() {
        driver.close();
        driver.quit();
    }

    public static void main(String[] args) {
        StepOne.startBrowser();
        ParseXml px = new ParseXml("src\\main\\resources\\config.xml");
        boolean exist = px.isExist("/config/waitTime");
        System.out.println(exist);
        StepOne.testinput();
    }

}
