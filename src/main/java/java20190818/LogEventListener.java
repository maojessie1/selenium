package java20190818;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class LogEventListener implements WebDriverEventListener {
    private Log log = LogFactory.getLog(this.getClass());
    String url="http://www.baidu.com";
    private By lastFindBy;
    private String originalValue;
    private WebDriver driver;


    public LogEventListener() {
        this.log = log;
        this.url = url;
        this.lastFindBy = lastFindBy;
        this.originalValue = originalValue;
        this.driver = driver;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public By getLastFindBy() {
        return lastFindBy;
    }

    public void setLastFindBy(By lastFindBy) {
        this.lastFindBy = lastFindBy;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver selenium) {//在导航之前
        log.info("WebDriver navigating to:'"+url+"'");
    }

    @Override
    public void afterNavigateTo(String s, WebDriver selenium) {

    }

    @Override
    public void beforeNavigateBack(WebDriver selenium) {

    }

    @Override
    public void afterNavigateBack(WebDriver selenium) {

    }

    @Override
    public void beforeNavigateForward(WebDriver selenium) {

    }

    @Override
    public void afterNavigateForward(WebDriver selenium) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver selenium) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver selenium) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver selenium) {
        lastFindBy = by;
        //找东西前等三秒wait 3 second for every find by
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver selenium) {
        String locator = element.toString().split("->")[1];
        log.info("webdriver clicking on:"+locator.substring(0,locator.length()-1));
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver selenium, CharSequence[] charSequences) {
        originalValue = element.getAttribute("value");
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver selenium, CharSequence[] charSequences) {
        log.info("WebDriver changing value in element found "+ lastFindBy+"from'"+originalValue+"'to'"+element.getAttribute("value")+"'");
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable error, WebDriver selenium) {
        if (error.getClass().equals(NoSuchElementException.class)){
            log.error("WebDriver error: Element not found"+lastFindBy);
        }else {
            log.error("WebDriver error:",error);
        }
    }
}
