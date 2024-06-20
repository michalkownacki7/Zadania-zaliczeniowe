package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToLoginPage(){
        WebElement element = driver.findElement(By.cssSelector("a[title='Log in to your customer account']"));
        element.click();
    }

    public void logIntoAccount(){
        WebElement element = driver.findElement(By.cssSelector("input[id=field-email]"));
        element.sendKeys("test992@test.com");
        element= driver.findElement(By.cssSelector("input[id=field-password]"));
        element.sendKeys("test123");
        element= driver.findElement(By.cssSelector("button[id=submit-login]"));
        element.click();
    }
}
