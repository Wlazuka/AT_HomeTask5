package com.amazon.pageObject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//a[@id='a-autoid-2-announce']")
    public static WebElement hardCoverButton;

    @FindBy(xpath = "//select[@id='quantity']")
    public static WebElement quantityDrp;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public static WebElement adToCArtButton;

    @FindBy(xpath = "//span[@id='price']")
    public static WebElement price;

    public ProductDetailsPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public ProductDetailsPage chooseHardCover() {
        clickOnElement(hardCoverButton);
        return this;
    }

    public ProductDetailsPage setQuantity(int quantity) {
        wait.forElementToLoad(quantityDrp);
        selectFromDropdownByValue(quantityDrp, quantity);
        return this;
    }

    public ProductDetailsPage addToCart() {
        clickOnElement(adToCArtButton);
        return this;
    }

    public double getProductPrice(){
        return Double.parseDouble(price.getText());
    }

}
