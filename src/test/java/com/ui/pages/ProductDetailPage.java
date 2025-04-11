package com.ui.pages;

import com.constants.Size;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BrowserUtility {


    private static final By SIZE_DROP_DOWN_LOCATOR = By.id("group_1");
    private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@name='Submit']/span");
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage changeSize(Size size){
        selectFromDropDown(SIZE_DROP_DOWN_LOCATOR,size.toString());
        return new ProductDetailPage(getDriver());
    }

    public ProductDetailPage addToCart(){
        clickOn(ADD_TO_CART_BUTTON_LOCATOR);
        return this;
    }

    public ShoppingCartPage proceedCheckOutPage(){
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new ShoppingCartPage(getDriver());
    }

}
