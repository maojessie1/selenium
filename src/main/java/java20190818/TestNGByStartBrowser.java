package java20190818;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGByStartBrowser {

    private WebDriver driver;

    /*
    private WebDriver driver;
    @BeforeMethod
    public void startWebDriver(){
        SetBrowser.test1();
        driver = new FirefoxDriver();
        driver.navigate().to("file:///C:/Users/123/Desktop/demo.html");
        driver.manage().window().maximize();
        System.out.println("startBrowser �ɹ�");
    }*/

    @BeforeMethod
    public void startBrowser(){
        SetBrowser.test1();
        SeleniumDriver sd = new SeleniumDriver();
        driver = sd.getDriver();
        driver.navigate().to("file:///C:/Users/123/Desktop/demo.html");
        System.out.println("startBrowser�ɹ�");
    }
    @Test
    public void test(){
        String str="12";
        ScreenShot ss = new ScreenShot(driver);
        ss.takeScreenShot();
        driver.findElement(By.xpath(".//*[@id='user']")).sendKeys(str);
        ss.takeScreenShot();
        System.out.println("sendKeys�ɹ�");
        Log.logWarn("this is warn");
    }
    @Test
    public void test1(){
        ScreenShot ss = new ScreenShot(driver);
        ss.takeScreenShot();
        Assert.assertEquals(1,2,"abcd");
        driver.findElement(By.xpath(".//*[@id='link']/a")).click();
        ss.takeScreenShot();
        driver.navigate().back();
        ss.takeScreenShot();
        System.out.println("���ӵ���ɹ�");
        Assertion.verifyEquals(1,2);
        Assert.assertTrue(Assertion.flag);
        Log.logInfo("����log this is log");
    }

    @Test
    public void test3(){
        PageDemo pd = new PageDemo(driver);
        pd.input();
    }

    @AfterMethod
    public void quit(){
        driver.close();
        System.out.println("close�ɹ�");
        driver.quit();
        System.out.println("quit�ɹ�");
    }

}
