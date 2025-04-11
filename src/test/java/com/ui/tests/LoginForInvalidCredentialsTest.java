package com.ui.tests;

import com.ui.listeners.TestListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Listeners({TestListeners.class})
public class LoginForInvalidCredentialsTest extends TestBase{
	private static final String INVALID_EMAIL_ADDRESS = "akash@test.com";
	private static final String INVALID_PASSWORD = "Qwerty1234!";
	@Test(description = "Verify if the proper error message is shown when they enter invalid credentials", groups = {"e2e", "sanity"})
	public void loginTestInvalidUser() {
		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD).getErrorMessage(),"Authentication failed.");
	}

}
