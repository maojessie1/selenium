package java20190908001;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {
    private WebDriver driver;

    public SeleniumDriver(){
        this.initialDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    private void initialDriver() {
        if ("firefox".equals(Config.Browser)){
            driver = new FirefoxDriver();
        }else if ("ie".equals(Config.Browser)){
            driver = new InternetExplorerDriver();
        }else if ("chrome".equals(Config.Browser)){
            driver = new ChromeDriver();
        }else {
            System.out.println("´íÎóµÄä¯ÀÀÆ÷");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Config.waitTime, TimeUnit.SECONDS);
    }


}
