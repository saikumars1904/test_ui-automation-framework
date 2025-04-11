package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BrowserUtility {
    private static final By ORDER_CONFIRMATION_SUCCESS_MESSAGE_LOCATOR =By.xpath("//p[contains(@class,'alert-succes')]");
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String orderSuccessMessage(){
        String message = getVisibleText(ORDER_CONFIRMATION_SUCCESS_MESSAGE_LOCATOR);
        return message;
    }
}
