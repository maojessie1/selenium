package java20190818;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SetBrowser {

    public static void test1(){
        System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");

      /*  WebDriver driver = new FirefoxDriver();
        WebDriver driver1 = new InternetExplorerDriver();
        WebDriver driver2 = new ChromeDriver();
        WebDriver driver3 = new SafariDriver();
        WebDriver driver4 = new OperaDriver();
        RemoteWebElement remoteWebElement = new RemoteWebElement();
        WebElement element = remoteWebElement.findElement(By.xpath(""));*/
    }

  /*   public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        //WebDriver driver5 = new EventFiringWebDriver(new FirefoxDriver()).register(new LogEventListener());
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver2 = new ChromeDriver();
*/

     /*   System.setProperty("webdriver.ie.driver","C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe");
        WebDriver driver1 = new InternetExplorerDriver();
        //driver1.navigate().to("http://www.baidu.com");
        driver1.get("http://www.baidu.com");

        ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile firefoxProfile = profilesIni.getProfile("default");
        WebDriver driver1 = new FirefoxDriver(firefoxProfile);
        driver1.get("http://www.baidu.com");*/
    }

