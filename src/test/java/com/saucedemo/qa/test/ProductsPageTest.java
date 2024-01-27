package com.saucedemo.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CartPage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.ProductsPage;

public class ProductsPageTest extends TestBase{
	
	public ProductsPageTest() {
		super();
	}
	
	LoginPage loginpage;
	ProductsPage productspage;
	CartPage cartpage;
	
	@BeforeMethod
	public void setUp() {
		
		Initialization();
		
		loginpage = new LoginPage();
		loginpage.enterValidUsername();
		loginpage.enterValidPassword();
		loginpage.clickLoginButton();
		productspage = loginpage.checkProductPageNavigationOnCorrectLogin();
		
		
	}
	
	@Test(priority=1)
	
	public void checkProductPageDetails() {
		Assert.assertEquals((productspage.checkProductsPageTitle()), "Products");
		Assert.assertEquals((productspage.checkProductPageLogoName()), "Swag Labs");
	}
	
	@Test(priority =2)
	public void checkTotalItemCount() {
		int item_count = productspage.checkItemCount();
		Assert.assertEquals(item_count, 6);
	}
	
	@Test(priority =3)
	public void checkItemDetail() {
		Assert.assertEquals((productspage.checkItemName()), "Sauce Labs Backpack");
		Assert.assertEquals((productspage.checkItemPrice()), "$29.99");
	}



	@Test(priority=4)
	public void checkCartFunctionality() {
		productspage.clickOnAddToCart();
		String cartCountAfterAddingItems = productspage.cartCounter.getText();
		Assert.assertEquals(cartCountAfterAddingItems, "6");
		
		productspage.clickOnRemoveButton();
		String cartCountAfterDeletingItems = productspage.cartCounter.getText();
		driver.navigate().refresh();
		Assert.assertEquals(cartCountAfterDeletingItems, "3");
		
		productspage.clickOnRemoveButton();
	}
	
	@Test(priority=5)
	public void checkCartButtonFunctionality() {
		
		cartpage = productspage.clickonCart();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	


}
