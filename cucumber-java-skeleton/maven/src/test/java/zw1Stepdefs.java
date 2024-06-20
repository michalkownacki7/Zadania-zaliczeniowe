import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.SortedSet;

public class zw1Stepdefs {
    public WebDriver driver;
    WebDriverWait wait;

    @Before
    public void iOpenWebBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }

//    @After
//    public void closeBrowser() {
//        driver.quit();
//    }

    @Given("I go to the login page")
    public void iGoToTheLoginPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?");
        WebElement element = driver.findElement(By.cssSelector("a[title='Log in to your customer account']"));
        element.click();
    }


    @When("I enter {string} as email")
    public void iEnterAsEmail(String email) {
        WebElement element = driver.findElement(By.cssSelector("input[id=field-email]"));
        element.sendKeys(email);
    }

    @And("I enter {string} as password")
    public void iEnterAsPassword(String password) {
        WebElement element = driver.findElement(By.cssSelector("input[id=field-password]"));
        element.sendKeys(password);
    }


    @And("I click on Sign In button")
    public void iClickOnSignInButton() {
        WebElement element = driver.findElement(By.cssSelector("button[id=submit-login]"));
        element.click();
    }


    @Then("I am logged in")
    public void iAmLoggedIn() {
        WebElement element = driver.findElement(By.cssSelector("header[class=page-header]"));
        String expectedText = "Your account";
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @When("I click Addresses")
    public void iClickAddresses() {
        WebElement element = driver.findElement(By.cssSelector("a[id=addresses-link]"));
        element.click();
    }

    @And("I click Create new address")
    public void iClickCreateNewAddress() {
        WebElement element = driver.findElement(By.cssSelector("a[data-link-action=add-address]"));
        element.click();
    }

    @Then("I am in New Address form")
    public void iAmInNewAddressForm() {
        WebElement element = driver.findElement(By.cssSelector("header[class=page-header]"));
        String expectedText = "New address";
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }


    @When("I type {string}")
    public void iType(String alias) {
        WebElement element = driver.findElement(By.cssSelector("input[id=field-alias]"));
        element.sendKeys(alias);
    }


    @And("I type {string} in Address field")
    public void iTypeInAddressField(String address) {
        WebElement element = driver.findElement(By.cssSelector("input[id=field-address1]"));
        element.sendKeys(address);
    }

    @And("I type {string} in City field")
    public void iTypeInCityField(String city) {
        WebElement element = driver.findElement(By.cssSelector("input[id=field-city]"));
        element.sendKeys(city);
    }

    @And("I type {string} in Postal Code field")
    public void iTypeInPostalCodeField(String postalCode) {
        WebElement element = driver.findElement(By.cssSelector("input[id=field-postcode]"));
        element.sendKeys(postalCode);
    }

    @And("I choose {string} in Country field")
    public void iChooseInCountryField(String value) {
        WebElement element = driver.findElement(By.cssSelector("select[id=field-id_country]"));
        Select select = new Select(element);
        select.selectByValue(value);
    }


    @And("I type {string} in Phone field")
    public void iTypeInPhoneField(String phone) {
        WebElement element = driver.findElement(By.cssSelector("input[id=field-phone]"));
        element.sendKeys(phone);
    }

    @And("I click Save button")
    public void iClickSaveButton() {
        WebElement element = driver.findElement(By.cssSelector("button[type=submit]"));
        element.click();
    }

    @Then("I added Address")
    public void iAddedAddress() {
        wait.until(ExpectedConditions.urlContains("controller=addresses"));
    }

    @And("I check if address is correct")
    public void iCheckIfAddressIsCorrect() {
        List<WebElement> elements = driver.findElements(By.cssSelector("div[class=address-body]"));
        WebElement element = elements.get(elements.size() - 1);
        String actualText = element.getText();
        String expectedAlias = "tester";
        String expectedAddress = "Testowa 3";
        String expectedCity = "Testopolis";
        String expectedPostalCode = "12-34";
        String expectedCountry = "United Kingdom";
        String expectedPhone = "911991992";
        Assert.assertTrue(actualText.contains(expectedAlias));
        Assert.assertTrue(actualText.contains(expectedAddress));
        Assert.assertTrue(actualText.contains(expectedCity));
        Assert.assertTrue(actualText.contains(expectedPostalCode));
        Assert.assertTrue(actualText.contains(expectedCountry));
        Assert.assertTrue(actualText.contains(expectedPhone));
//        System.out.println(actualText);
    }


    @When("I click delete button")
    public void iClickDeleteButton() {
        List<WebElement> elements = driver.findElements(By.cssSelector("a[data-link-action=delete-address]"));
        WebElement element  = elements.get(elements.size() - 1);
        element.click();
    }


    @Then("I deleted address")
    public void iDeletedAddress() {
        WebElement element =  driver.findElement(By.cssSelector("article[class='alert alert-success']"));;
        String deletionCheck = element.getText();
        String expectedText = "Address successfully deleted!";
        Assert.assertTrue(deletionCheck.contains(expectedText));
    }
}







