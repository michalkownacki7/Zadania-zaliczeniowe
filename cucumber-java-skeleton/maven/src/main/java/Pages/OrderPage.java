package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    WebDriver driver;

    public OrderPage (WebDriver driver){
        this.driver = driver;
    }

    public void takeScreenshoot(){
        WebElement element = driver.findElement(By.cssSelector("class='page-content page-order-confirmation card'"));
        element.getScreenshotAs(OutputType.FILE);
    }
}
