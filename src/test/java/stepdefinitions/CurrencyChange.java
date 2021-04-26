package stepdefinitions;

import com.amazon.utils.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CurrencyChange {

    WebDriver driver;
    PropertyManager propertyManager;
    PageManager pageManager;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        propertyManager = new PropertyManager();
        pageManager = new PageManager(driver, propertyManager);
    }

    @Given("^User is on Amazon main page$")
    public void userIsOnWebpagePage() {
        pageManager
                .homePage
                .open()
                .dontChangeCountryIfRequired();
    }

    @When("^User goes to settings page$")
    public void userGoesToChangeCurrencyPage(){
        pageManager.homePage.goToSettings();
    }

    @When("User change currency to: {string}")
    public void userChangeCurrencyToCurrency(String currency) {
        pageManager.settingsPage.selectCurrency(PropertyManager.getProperty(currency));
    }

    @Then("User sees message: {string}")
    public void userSeesMessageMessage(String message) {
        Assert.assertEquals(pageManager.settingsPage.getCurrencyNote(), PropertyManager.getProperty(message));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @When("User change language to: {string}")
    public void userChangeLanguageToLanguage(String language) {
        pageManager.settingsPage.changeLanguageTo(language);
    }

    @Then("User sees {string} in {string}")
    public void userSeesMessageInLanguage(String message, String language) {
        String languageSettingsMsg = pageManager.settingsPage.getLanguageSettingsMessage();
        String expectedMsg = PropertyManager.getProperty(message);
        Assert.assertEquals(languageSettingsMsg, expectedMsg);
    }

    @Then("Translation {string} is also in {string}")
    public void translationIsAlsoInLanguage(String translation, String language) {
        String translationText = pageManager.settingsPage.getTranslationText();
        String expectedTranslationText = PropertyManager.getProperty(translation);
        Assert.assertEquals(translationText, expectedTranslationText);
    }
}
