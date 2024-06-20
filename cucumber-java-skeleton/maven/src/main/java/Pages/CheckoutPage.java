package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void confirmAddress(){
        List<WebElement> elements = driver.findElements(By.cssSelector("div[class=address]"));
        WebElement element = elements.get(elements.size() - 1);
        String actualText = element.getText();
        String expectedAddress = "Testowa 3";
        String expectedCity = "Testopolis";
        String expectedPostalCode = "12-34";
        String expectedCountry = "United Kingdom";
        String expectedPhone = "911991992";
        Assert.assertTrue(actualText.contains(expectedAddress));
        Assert.assertTrue(actualText.contains(expectedCity));
        Assert.assertTrue(actualText.contains(expectedPostalCode));
        Assert.assertTrue(actualText.contains(expectedCountry));
        Assert.assertTrue(actualText.contains(expectedPhone));
    }

    public void pressContinue(){
        WebElement element = driver.findElement(By.cssSelector("button[name=confirm-addresses]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void chooseDeliveryMethod(){
        WebElement element = driver.findElement(By.cssSelector("input[id=delivery_option_8]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void continueToPayment(){
        WebElement element = driver.findElement(By.cssSelector("button[name=confirmDeliveryOption]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void choosePaymentMethod(){
        WebElement element = driver.findElement(By.cssSelector("input[id=payment-option-1]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void termsOfServiceCheckbox(){
        WebElement element= driver.findElement(By.cssSelector("input[id=conditions_to_approve[terms-and-conditions]]"));
        element.click();
    }

    public void placeOrder(){
        WebElement element = driver.findElement(By.cssSelector("button[class='btn btn-primary center-block']"));
        element.click();
    }
}
