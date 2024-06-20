package Pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SweaterPage {
    WebDriver driver;
    WebDriverWait wait;

    public SweaterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void checkDiscount(String expectedDiscount) {
        WebElement element = driver.findElement(By.cssSelector("span[class=\"discount discount-percentage\"]"));
        String actualDiscount = element.getText();
        Assert.assertTrue(actualDiscount.contains(expectedDiscount));
    }

    public void selectSize(String size) {
        WebElement element = driver.findElement(By.cssSelector("select[aria-label=Size]"));
        Select select = new Select(element);
        select.selectByVisibleText(size);
    }

    public void selectNumberOfSweaters(int number) {
        WebElement element = driver.findElement(By.id("quantity_wanted"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value='" + number + "';", element);
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        element.click();
//        element.clear();
//        element.sendKeys(number);


    }

    public void addToCart() {
        WebElement element = driver.findElement(By.cssSelector("div[class=add]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void proceedToCart() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

//        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=cart&action=show");
    }

    public void proceedToCheckout(){
        WebElement element = driver.findElement(By.cssSelector("a[href=https://mystore-testlab.coderslab.pl/index.php?controller=order]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
