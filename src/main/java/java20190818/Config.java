package java20190818;

import org.openqa.selenium.WebDriver;

public class Config {
    public static String browser;
    public static int waitTime;

    static {
        ParseXml ps = new ParseXml("src\\main\\resources\\config.xml");
        waitTime=Integer.valueOf(ps.getElementText("/config/waitTime"));
        browser=ps.getElementText("/config/browser");
    }

    public static void main(String[] args) {
        SetBrowser.test1();
        SeleniumDriver driver = new SeleniumDriver();
        WebDriver driver1 = driver.getDriver();
        driver1.navigate().to("http://www.baidu.com");
    }
}
