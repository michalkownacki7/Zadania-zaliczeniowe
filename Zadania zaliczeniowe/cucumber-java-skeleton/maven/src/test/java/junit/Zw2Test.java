package junit;

import Pages.AccountPage;
import Pages.ClothesPage;
import Pages.LoginPage;
import Pages.SweaterPage;
import io.cucumber.java.bs.A;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zw2Test {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    AccountPage accountPage;
    ClothesPage clothesPage;
    SweaterPage sweaterPage;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        wait = new WebDriverWait(driver, 10);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver, wait);
        clothesPage = new ClothesPage(driver, wait);
        sweaterPage = new SweaterPage(driver, wait);
    }

    @Test
    public void myStoreOder() {
        loginPage.goToLoginPage();
        loginPage.logIntoAccount();

        accountPage.goToClothes();

        clothesPage.chooseSweater();

        sweaterPage.checkDiscount("20%");
        sweaterPage.selectSize("L");
        sweaterPage.selectNumberOfSweaters("5");
//        sweaterPage.addToCart();
//        sweaterPage.proceedToCheckout();
    }

}
