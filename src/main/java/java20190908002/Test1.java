package java20190908002;

import java20190908001.SetP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {

    WebDriver driver;
    @BeforeClass
    public void startBrowser(){
        SetP.setP();
        SeleniumDriver sd = new SeleniumDriver();
        driver = sd.getDriver();
        driver.navigate().to("file:///C:/Users/123/Desktop/demo.html");

    }

    @Test
    public void test1(){
        PageDemo pd = new PageDemo(driver);
        pd.input();
    }



    @AfterClass
    public void endtest(){
        driver.close();
        driver.quit();
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        t.startBrowser();
    }
}
