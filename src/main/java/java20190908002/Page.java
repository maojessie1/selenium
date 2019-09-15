package java20190908002;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    public WebDriver driver;

    Page(WebDriver driver){
        this.driver = driver;
    }

    public boolean waitToBeDisplayed(final By key){
        Boolean waitDisplayed=(new WebDriverWait(driver,Config.waitTime)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(key).isDisplayed();
            }
        });
        return waitDisplayed;
    }

    protected WebElement getElement(By key){
        WebElement element = null;
        if (this.waitToBeDisplayed(key)){
            element = driver.findElement(key);
        }
        return element;
    }
}
