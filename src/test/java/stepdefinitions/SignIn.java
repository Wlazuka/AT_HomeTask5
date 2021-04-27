package stepdefinitions;

import com.amazon.utils.DriverManager;
import com.amazon.utils.PageManager;
import com.amazon.utils.PropertyManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class SignIn {

    WebDriver driver;
    PropertyManager propertyManager;
    PageManager pageManager;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        propertyManager = new PropertyManager();
        pageManager = new PageManager(driver, propertyManager);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }


    @Given("Goes to Sign in page")
    public void goesToSignInPage() {
        pageManager
                .homePage
                .open()
                .dontChangeCountryIfRequired()
                .signIn();
    }

    @When("user enters email and the correct password twice")
    public void userEntersEmailAndTheCorrectPasswordTwice(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String email = rows.get(0).get("email");
        String password = rows.get(0).get("password");
        pageManager
                .signInPage
                .enterEmail(email)
                .pressContinueButton()
                .enterPassword(password)
                .pressSingInButton()
                .enterPassword(password);
    }

    @But("dont fill CAPTCHA field")
    public void dontFillCAPTCHAField() {
        pageManager
                .signInPage
                .pressSingInButton();
    }

    @Then("user should see message")
    public void userShouldSeeMessage(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String message = rows.get(0).get("message");
        Assert.assertTrue(pageManager.signInPage.pageSource().contains(message));
    }

}
