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

public class CheckoutOverviewPageTest extends TestBase {
	// This includes all the test cases related to 'Checkout : Overview' page.

	LoginPage loginpage;
	ProductsPage productspage;
	CartPage cartpage;
	CheckoutInformationPage checkoutinformationpage;
	CheckoutOverviewPage checkoutoverviewpage;
	CheckoutCompletePage checkoutcompletepage;
	public double tax = 2.40;

	@BeforeMethod
	public void setUp() {

		Initialization();

		loginpage = new LoginPage();
		productspage = new ProductsPage();
		cartpage = new CartPage();
		checkoutinformationpage = new CheckoutInformationPage();
		loginpage.enterValidUsername();
		loginpage.enterValidPassword();
		loginpage.clickLoginButton();
		productspage.clickFirstAddtocartButton();
		productspage.clickonCart();
		cartpage.clickCheckoutButton();
		checkoutinformationpage.enterData();
		checkoutoverviewpage = checkoutinformationpage.clickContinue();

	}

	@Test(priority = 1)
	public void checkCorrectItemPresent() {
		// Validating the correct item is present on screen which were added by the user
		// before.
		Assert.assertEquals((checkoutoverviewpage.getItemName()), (cartpage.checkItemName()));
		Assert.assertEquals((checkoutoverviewpage.getItemPrice()), (cartpage.checkItemPrice()));
	}

	@Test(priority = 2)
	public void checkPaymentAndShippingInfo() {
		// validating payment information and shipping information details.
		Assert.assertEquals((checkoutoverviewpage.getPaymentInformation()), "SauceCard #31337");
		Assert.assertEquals((checkoutoverviewpage.getShippingInformation()), "Free Pony Express Delivery!");
	}

	@Test(priority = 3)

	public void checkTotalPrice() {
		// validating the 'total' value is correct.
		double itemPrice = Double.parseDouble((checkoutoverviewpage.getItemPrice()).replace("$", ""));
		double totalPrice = itemPrice + tax;
		Assert.assertEquals(totalPrice, 32.39);

	}

	@Test(priority = 4)
	public void checkFinish() {
		// clicking on finish and moving to next page.
		checkoutcompletepage = checkoutoverviewpage.clickFinish();

	}

	@AfterMethod()
	public void tearDown() {
		// closing the browser.

		driver.quit();
	}

}
