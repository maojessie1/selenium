package java20190818;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumDriver {
    private WebDriver driver;
    SeleniumDriver(){
        this.initialDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void initialDriver() {
        if ("firefox".equals(Config.browser)){
            driver=new FirefoxDriver();
        }else if ("ie".equals(Config.browser)){
            driver = new InternetExplorerDriver();
        }else {
            System.out.println("´íÎóµÄä¯ÀÀÆ÷");
        }
    }
}
