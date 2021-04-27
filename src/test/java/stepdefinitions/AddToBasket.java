package stepdefinitions;

import com.amazon.utils.DriverManager;
import com.amazon.utils.PageManager;
import com.amazon.utils.PropertyManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AddToBasket {

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

    @Given("the book {string} is available in shop")
    public void theBookTitleIsAvailableInShop(String item) {
        pageManager
                .homePage
                .open()
                .dontChangeCountryIfRequired()
                .searchProduct(item);
        Assert.assertTrue(pageManager.searchResultsPage.getPageSource().contains(item));
        pageManager
                .searchResultsPage
                .chooseFirstResult();
    }

    @Given("user has added {int} book\\(s) to shopping cart")
    public void user_has_added_book_s_to_shopping_cart(int quantity) {
        pageManager
                .productDetailsPage
                .chooseHardCover()
                .setQuantity(quantity)
                .addToCart();
    }

    @When("user checks out the shopping cart")
    public void useChecksOutTheShoppingCart() {
        pageManager.subTotalPage.goToCart();
    }

    @Then("the book {string} is listed in the final checkout")
    public void theBookIsListedInTheFinalCheckout(String name) {
        Assert.assertEquals(pageManager.cartPage.getProductName(), name);
    }

    @Then("the total price of the cart is ${double}")
    public void the_total_price_of_the_cart_is_$(double totalprice) {
        Assert.assertTrue(pageManager.cartPage.getSubtotalText().contains(String.valueOf(totalprice)));
    }
}
