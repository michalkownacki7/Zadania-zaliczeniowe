package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    WebDriver driver;
    WebDriverWait wait;

    public AccountPage(WebDriver driver, WebDriverWait wait){
        this.driver =  driver;
        this.wait = wait;
    }

    public void goToClothes(){
        driver.get("https://mystore-testlab.coderslab.pl/index.php?id_category=3&controller=category");
    }


}
