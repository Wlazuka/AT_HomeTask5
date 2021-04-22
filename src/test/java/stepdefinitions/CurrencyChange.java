package stepdefinitions;


import com.amazon.utils.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CurrencyChange {

    WebDriver driver;
    PropertyManager propertyManager;
    PageManager pageManager;


    @BeforeClass
    public void setup() {
        driver = DriverManager.getDriver();
        propertyManager = new PropertyManager();
        pageManager = new PageManager(driver, propertyManager);
    }


    @Given("^User is on Amazon main page$")
    public void userIsOnWebpagePage() {
        driver.get("www.google.com");
        //        homePage.open()
//                .dontChangeCountryIfRequired();
    }

    @When("^User goes to currency change page$")
    public void userGoesToChangeCurrencyPage(){
        pageManager.homePage.changeCurrency();
    }


    @And("User change currency to: {string}")
    public void userChangeCurrencyToCurrency(String currency) {
        pageManager.currencyChangePage.selectCurrency(currency);

    }

    @Then("User sees message: {string}")
    public void userSeesMessageMessage(String message) {
        Assert.assertEquals(pageManager.currencyChangePage.getCurrencyNote(), message);

    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }
}
