package com.ui.pages;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BrowserUtility;
import org.openqa.selenium.WebDriver;

import static com.constants.Env.QA;
import static com.utility.JSONUtility.readJSON;
import static com.utility.PropertiesUtil.readProperty;

public  final class HomePage extends BrowserUtility{

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(WebDriver driver) {
		super(driver);
		//goToWebsite(readProperty(QA,"URL"));
		goToWebsite(readJSON(QA).getUrl());
		logger.info("naviagetd to website {}",readJSON(QA).getUrl());
	}
	public HomePage(Browser browserName,boolean headless) {
		super(browserName,headless);
		//goToWebsite(readProperty(QA,"URL"));
		goToWebsite(readJSON(QA).getUrl());
		logger.info("naviagetd to website {}",readJSON(QA).getUrl());
	}

	public LoginPage goToLoginPage() {
		logger.info("Trying to perform click on sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
}
