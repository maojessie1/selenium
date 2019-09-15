package java20190908002;

import java20190818.ScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageDemo extends Page {
    PageDemo(WebDriver driver) {
        super(driver);
    }

    public static By input = By.id("user");

    public void input(){
        WebElement element = this.getElement(input);
        Screenshot ss = new Screenshot(driver);
        ss.takeScreenShot();
        element.sendKeys("abcd");
        ss.takeScreenShot();
    }
}
