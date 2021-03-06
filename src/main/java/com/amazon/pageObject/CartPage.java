package com.amazon.pageObject;

import com.amazon.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[@data-name='Subtotals']")
    public WebElement subtotalFiled;

    @FindBy(xpath = "//span[@class='a-size-medium sc-product-title']")
    public WebElement productName;

    public CartPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public String getProductName(){
        return productName.getText();
    }

    public String getSubtotalText(){
        return subtotalFiled.getText();
    }
}
