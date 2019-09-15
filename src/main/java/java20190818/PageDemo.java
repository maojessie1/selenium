package java20190818;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageDemo extends Page {


    public static By input = By.id("user");

    public PageDemo(WebDriver driver) {

        super(driver);
    }

    public void input(){
        WebElement element = this.getElement(input);
        element.sendKeys("abcd");
    }
}
