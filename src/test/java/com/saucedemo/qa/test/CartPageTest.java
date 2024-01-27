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
	
	@Test(priority=1)
	public void checkCartPageDetails() {
		Assert.assertEquals(cartpage.checkPageTitle(),"Your Cart");
		Assert.assertEquals((cartpage.checkTotalItemsInCart()), 1);
				
	}
	
	@Test(priority=2)
	public void checkRemoveFunctionalityFomCartPage() {
		cartpage.clickOnRemove();
		Assert.assertEquals((cartpage.checkItemAfterRemoval()), false);	
	}
	
	@Test(priority=3)
	public void checkContinueShopping() {
		cartpage.clickContinueShopping();
		productspage.clickFirstAddtocartButton();
		productspage.clickonCart();
		checkoutinformationpage=cartpage.clickCheckoutButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
