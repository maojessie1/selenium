package java20190911;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageDemo extends Page{
    public static By input = By.id("user");
    PageDemo(WebDriver driver) {
        super(driver);
    }

    public void input(){

        WebElement element = this.getElment(input);
        Log.logWarn("111");
        element.sendKeys("addbewio");
    }
}
