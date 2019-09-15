package java20190818;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    public WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    private boolean waitToDisplayed(final By key){
        boolean flag = false;
        Boolean waitDisplayed = new WebDriverWait(driver,Config.waitTime).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(key).isDisplayed();
            }
        });
        return waitDisplayed;
    }

    public WebElement getElement(By key){
        WebElement element = null;
        if (this.waitToDisplayed(key)){
            element=driver.findElement(key);
        }
        return element;
    }




}
