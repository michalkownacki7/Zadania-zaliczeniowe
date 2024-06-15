package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SweaterPage {
    WebDriver driver;
    WebDriverWait wait;

    public SweaterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void checkDiscount(String expectedDiscount) {
        WebElement element = driver.findElement(By.cssSelector("span[class=\"discount discount-percentage\"]"));
        ;
        String actualDiscount = element.getText();
        Assert.assertTrue(actualDiscount.contains(expectedDiscount));
    }

    public void selectSize(String size) {
        WebElement element = driver.findElement(By.cssSelector("select[aria-label=Size]"));
        Select select = new Select(element);
        select.selectByVisibleText(size);
    }

    public void selectNumberOfSweaters(String number) {
        WebElement element = driver.findElement(By.cssSelector("input[name=qty]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(number);

    }

    public void addToCart(){
        WebElement element = driver.findElement(By.cssSelector("button[data-button-action=add-to-cart]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void proceedToCheckout(){
        WebElement element=  driver.findElement(By.cssSelector("a[href=\"//prod-kurs.coderslab.pl/index.php?controller=cart&action=show\"]"));
        element.click();
    }
}
