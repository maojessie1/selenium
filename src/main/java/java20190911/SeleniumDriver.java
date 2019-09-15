package java20190911;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumDriver {
    private WebDriver driver;

    SeleniumDriver(){
        this.inital();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void inital() {
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
    }
}
