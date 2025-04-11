package com.ui.tests;

import static org.testng.Assert.*;

import com.ui.dataproviders.LoginDataProvider;
import com.ui.listeners.MyRetryAnalyzer;
import com.ui.listeners.TestListeners;
import com.ui.pojos.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestListeners.class})
public class LoginTest extends TestBase{
	/**
	 * Test Method!!!
	 * 1. Test script small
	 * 2. You can not have loops, exceptions, conditional statements in the test scripts
	 * TestScripts ----> Test Steps
	 * 3. Reduce the use of local variables
	 * 4. Atleast one assertion
	 */
	@Test(description = "Verifies with the valid user is able to login into the application", groups = {"e2e", "sanity"},
	dataProvider = "LoginTestDataProvider", dataProviderClass = LoginDataProvider.class,enabled = false)
	public void loginTest(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(),"Akash Debnath");
	}

	@Test(enabled = false, description = "Verifies with the valid user is able to login into the application via csv", groups = {"e2e", "sanity"},
			dataProvider = "LoginTestCSVProvider", dataProviderClass = LoginDataProvider.class)
	public void loginCSVTest(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(),"Akash Debnath");
	}

	@Test(description = "Verifies with the valid user is able to login into the application via csv", groups = {"e2e", "sanity"},
			dataProvider = "LoginTestExcelProvider", dataProviderClass = LoginDataProvider.class,retryAnalyzer = MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(),"Akash Debnath");
	}



}
