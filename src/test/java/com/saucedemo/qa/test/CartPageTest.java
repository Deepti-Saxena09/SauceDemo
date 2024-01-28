package com.saucedemo.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CartPage;
import com.saucedemo.qa.pages.CheckoutInformationPage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.ProductsPage;

public class CartPageTest extends TestBase {
// This includes all the test cases related to Your Cart screen.

	LoginPage loginpage;
	ProductsPage productspage;
	CartPage cartpage;
	CheckoutInformationPage checkoutinformationpage;

	@BeforeMethod
	public void setUp() {

		Initialization();

		loginpage = new LoginPage();
		productspage = new ProductsPage();
		loginpage.enterValidUsername();
		loginpage.enterValidPassword();
		loginpage.clickLoginButton();
		productspage.clickFirstAddtocartButton();
		cartpage = productspage.clickonCart();

	}

	@Test(priority = 1)
	public void checkCartPageDetails() {
		// Validating the count of items present in page
		Assert.assertEquals(cartpage.checkPageTitle(), "Your Cart");
		Assert.assertEquals((cartpage.checkTotalItemsInCart()), 1);

	}

	@Test(priority = 2)
	public void checkRemoveFunctionalityFomCartPage() {
		// Checking Remove button flow.
		cartpage.clickOnRemove();
		Assert.assertEquals((cartpage.checkItemAfterRemoval()), false);
	}

	@Test(priority = 3)
	public void checkContinueShopping() {
		// Adding one item to cart and clicking on checkout button
		cartpage.clickContinueShopping();
		productspage.clickFirstAddtocartButton();
		productspage.clickonCart();
		checkoutinformationpage = cartpage.clickCheckoutButton();
	}

	@AfterMethod
	public void tearDown() {
		// Closing the browser
		driver.quit();
	}
}
