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
	
	//This Test Script file includes below test cases:
	//1. Verify valid set of username and password are able to login.
	//2. Verify invalid username and password are not able to login. Validating the error message for the same.
	//3. Verify user is unable to login without entering username and password. Validating the error message for the same.
	

	public LoginPageTest() {
		super();
	}
	
	LoginPage loginpage;
	ProductsPage productspage;
	
	@BeforeMethod
	public void setUp() {
		
		Initialization();
		
		loginpage = new LoginPage();
		
	}
	
	@DataProvider(name="testData")
	public Object[][] tData(){
		return new Object[][] 
		{
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
		};
	}
	
	@Test(priority=1)
	public void emptyCredentialsLoginTest() {
		String error_message_for_empty_creds = loginpage.emptyFieldErrorMessage();
		Assert.assertEquals(error_message_for_empty_creds, "Epic sadface: Username is required");
	}
	
	@Test(priority=2)
	public void invalidCredentialsLoginTest() {
		loginpage.enterInvalidUsernameAndPassword();
		Assert.assertEquals((loginpage.emptyFieldErrorMessage()), "Epic sadface: Username and password do not match any user in this service");
	}
	

	
	@Test(priority=3, dataProvider="testData")
	public void validLoginTestUsingTestData(String username, String password) {	
		loginpage.username.sendKeys(username);
		loginpage.password.sendKeys(password);
		loginpage.clickLoginButton();	
		productspage = loginpage.checkProductPageNavigationOnCorrectLogin();
		
	}
	
	
	@AfterMethod()
	public void tearDown() {
		
		driver.quit();
	}
	
	
}
