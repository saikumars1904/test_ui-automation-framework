package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BrowserUtility {

    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("(//a[@title='Proceed to checkout'])[last()]");
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmAddressPage goToConfirmAddressPage(){
        clickOn(PROCEED_TO_CHECKOUT_BUTTON);
        return new ConfirmAddressPage(getDriver());
    }
}
