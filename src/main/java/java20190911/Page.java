package java20190911;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    private WebDriver driver;
    Page(WebDriver driver){
        this.driver = driver;
    }

    private boolean waitToByDisPalyed(final By key){
        boolean waitToBeDesplayed = new WebDriverWait(driver,Config.waitTime).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(key).isDisplayed();
            }
        });
        return waitToBeDesplayed;
    }

    protected WebElement getElment(By key){
        WebElement element = null;
        if (this.waitToByDisPalyed(key)){
            element = driver.findElement(key);
        }
        return element;
    }
}
