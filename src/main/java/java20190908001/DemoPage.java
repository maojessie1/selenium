package java20190908001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoPage extends Page {

    private static By input = By.id("user");

    DemoPage(WebDriver driver) {
        super(driver);
    }

    public void input(){
        WebElement element = this.getElement(input);
        element.sendKeys("abcdfdasfafdasfdasdfasfafsafa");
    }

}
