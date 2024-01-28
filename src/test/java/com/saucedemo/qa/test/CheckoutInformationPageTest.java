package com.saucedemo.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CartPage;
import com.saucedemo.qa.pages.CheckoutInformationPage;
import com.saucedemo.qa.pages.CheckoutOverviewPage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.ProductsPage;

public class CheckoutInformationPageTest extends TestBase {
	// This includes all the test cases related to 'Checkout: Information' screen

	LoginPage loginpage;
	ProductsPage productspage;
	CartPage cartpage;
	CheckoutInformationPage checkoutinformationpage;
	CheckoutOverviewPage checkoutoverviewpage;

	@BeforeMethod
	public void setUp() {

		Initialization();

		loginpage = new LoginPage();
		productspage = new ProductsPage();
		cartpage = new CartPage();
		loginpage.enterValidUsername();
		loginpage.enterValidPassword();
		loginpage.clickLoginButton();
		productspage.clickFirstAddtocartButton();
		productspage.clickonCart();
		checkoutinformationpage = cartpage.clickCheckoutButton();

	}

	@Test(priority = 1)
	public void checkPageTitle() {
		// Validating the page title
		Assert.assertEquals((checkoutinformationpage.checkPageTitle()), "Checkout: Your Information");
	}

	@Test(priority = 2)
	public void checkMandatoryFields() {
		// Validating the error message on moving ahead without submitting data.
		Assert.assertEquals((checkoutinformationpage.checkMandtoryFields()), "Error: First Name is required");
	}

	@Test(priority = 3)
	public void checkContinueFunctionality() {
		// entering data.
		// click on continue.
		checkoutinformationpage.enterData();
		checkoutoverviewpage = checkoutinformationpage.clickContinue();

	}

	@AfterMethod()
	public void tearDown() {
		// closing browser.

		driver.quit();
	}

}
