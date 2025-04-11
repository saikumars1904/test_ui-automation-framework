package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage extends BrowserUtility {
    private static final By CONFIRM_MY_ORDER_LOCATOR = By.xpath("//p[@id='cart_navigation']/button");
    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    public OrderConfirmationPage goToOrderConfirmationPage(){
        clickOn(CONFIRM_MY_ORDER_LOCATOR);
        return new OrderConfirmationPage(getDriver());
    }
}
