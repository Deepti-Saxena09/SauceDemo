package com.saucedemo.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.ProductsPage;

public class LoginPageTest extends TestBase {

	// This Test Script file includes all the test cases related to 'Login' flow.

	public LoginPageTest() {
		super();
	}

	LoginPage loginpage;
	ProductsPage productspage;

	@BeforeMethod
	// Pre-condition setup
	public void setUp() {

		Initialization();

		loginpage = new LoginPage();

	}

	@DataProvider(name = "testData")
	public Object[][] tData() {
		// created an object array which has stored username and password.
		return new Object[][] { { "standard_user", "secret_sauce" }, { "locked_out_user", "secret_sauce" },
				{ "problem_user", "secret_sauce" }, { "performance_glitch_user", "secret_sauce" },
				{ "error_user", "secret_sauce" }, { "visual_user", "secret_sauce" } };
	}

	@Test(priority = 1)
	public void emptyCredentialsLoginTest() {
		// Verify user is unable to login without entering username and password.
		// Validating the error message for the same.
		String error_message_for_empty_creds = loginpage.emptyFieldErrorMessage();
		Assert.assertEquals(error_message_for_empty_creds, "Epic sadface: Username is required");
	}

	@Test(priority = 2)
	public void invalidCredentialsLoginTest() {
		// Verify invalid username and password are not able to login. Validating the
		// error message for the same.
		loginpage.enterInvalidUsernameAndPassword();
		Assert.assertEquals((loginpage.emptyFieldErrorMessage()),
				"Epic sadface: Username and password do not match any user in this service");
	}

	@Test(priority = 3, dataProvider = "testData")
	public void validLoginTestUsingTestData(String username, String password) {
		// Verify valid set of username and password are able to login.
		loginpage.username.sendKeys(username);
		loginpage.password.sendKeys(password);
		loginpage.clickLoginButton();
		productspage = loginpage.checkProductPageNavigationOnCorrectLogin();

	}

	@AfterMethod()
	public void tearDown() {
		// closing the browser window.

		driver.quit();
	}

}
