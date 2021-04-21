package com.amazon.stepdefinitions;

import com.amazon.pageObject.CurrencyChangePage;
import com.amazon.pageObject.HomePage;
import com.amazon.utils.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CurrencyChangeSteps {

    static final String CHROME_DRIVER_PATH = "drivers/chromedriver";
    static WebDriver driver;
    protected PropertyManager propertyManager;
    protected JavascriptExecutor js;
    protected HomePage homePage;
    protected CurrencyChangePage currencyChangePage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9225");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        js = (JavascriptExecutor) driver;
        propertyManager = new PropertyManager();
        homePage = new HomePage(driver, propertyManager);
        currencyChangePage = new CurrencyChangePage(driver, propertyManager);
    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }

    @Given("User is on Amazon main page")
    public void userIsOnWebpagePage() {
        homePage.open()
                .dontChangeCountryIfRequired();
    }

    @When("User goes to currency change page")
    public void userGoesToChangeCurrencyPage() {
        homePage.changeCurrency();
    }

    @And("User change currency to: {string}")
    public void userChangeCurrencyToCurrency(String currency) {
        currencyChangePage.selectCurrency(currency);
    }

    @Then("User sees message: {string}")
    public void userSeesMessageMessage(String message) {
        Assert.assertEquals(currencyChangePage.getCurrencyNote(), message);
    }
}
