package com.saucedemo.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CartPage;
import com.saucedemo.qa.pages.CheckoutCompletePage;
import com.saucedemo.qa.pages.CheckoutInformationPage;
import com.saucedemo.qa.pages.CheckoutOverviewPage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.ProductsPage;

public class CheckoutCompletePageTest extends TestBase {
	// This includes all the test cases related to 'Checkout: Complete' page.

	LoginPage loginpage;
	ProductsPage productspage;
	CartPage cartpage;
	CheckoutInformationPage checkoutinformationpage;
	CheckoutOverviewPage checkoutoverviewpage;
	CheckoutCompletePage checkoutcompletepage;

	@BeforeMethod
	public void setUp() {

		Initialization();

		loginpage = new LoginPage();
		productspage = new ProductsPage();
		cartpage = new CartPage();
		checkoutinformationpage = new CheckoutInformationPage();
		checkoutoverviewpage = new CheckoutOverviewPage();
		loginpage.enterValidUsername();
		loginpage.enterValidPassword();
		loginpage.clickLoginButton();
		productspage.clickFirstAddtocartButton();
		productspage.clickonCart();
		cartpage.clickCheckoutButton();
		checkoutinformationpage.enterData();
		checkoutinformationpage.clickContinue();
		checkoutcompletepage = checkoutoverviewpage.clickFinish();

	}

	@Test(priority = 1)
	public void checkPageTitle() {
		// Validating the page title.
		Assert.assertEquals((checkoutcompletepage.getPageTitle()), "Checkout: Complete!");
	}

	@Test(priority = 2)
	public void checkThankYouMessage() {
		// Validating Thank You Message.
		Assert.assertEquals((checkoutcompletepage.getOrderConfirmation()), "Thank you for your order!");
	}

	@Test(priority = 3)
	public void checkBackToHome() {
		// Clicking on Back to Home button.
		checkoutcompletepage.clickBackToHome();
		Assert.assertEquals((checkoutcompletepage.getPageTitle()), "Products");
	}

	@AfterMethod()
	public void tearDown() {
		// Closing browser.

		driver.quit();
	}

}
