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

public class CheckoutOverviewPageTest extends TestBase{
	
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
	
	@Test(priority=1)
	public void checkCorrectItemPresent() {
		Assert.assertEquals((checkoutoverviewpage.getItemName()), (cartpage.checkItemName()));
		Assert.assertEquals((checkoutoverviewpage.getItemPrice()), (cartpage.checkItemPrice()));
	}
	
	@Test(priority=2)
	public void checkPaymentAndShippingInfo() {
		Assert.assertEquals((checkoutoverviewpage.getPaymentInformation()), "SauceCard #31337");
		Assert.assertEquals((checkoutoverviewpage.getShippingInformation()), "Free Pony Express Delivery!");
	}
	
	@Test(priority=3)

	public void checkTotalPrice() {
		double itemPrice = Double.parseDouble((checkoutoverviewpage.getItemPrice()).replace("$", ""));
		double totalPrice = itemPrice + tax;
		Assert.assertEquals(totalPrice, 32.39);
		
		
	}
	
	@Test(priority=4)
	public void checkFinish() {
		checkoutcompletepage = checkoutoverviewpage.clickFinish();
		
	}
	
	@AfterMethod()
	public void tearDown() {
		
		driver.quit();
	}
	
}
