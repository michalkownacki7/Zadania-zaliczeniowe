package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClothesPage {
    WebDriver driver;
    WebDriverWait wait;

    public ClothesPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void chooseSweater(){
        WebElement element = driver.findElement(By.cssSelector("a[href='https://prod-kurs.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s']"));
//        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
