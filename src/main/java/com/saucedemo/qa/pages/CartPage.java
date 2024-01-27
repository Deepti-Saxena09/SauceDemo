package com.saucedemo.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(xpath = "//span[@class='title']")
	WebElement yourCartPageTitle;
	
	@FindBy(xpath="//div[@class='cart_item']")
	List<WebElement> totalItems;
	
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement removeButton;
	
	@FindBy(xpath = "//div[@class='removed_cart_item']")
	WebElement zeroItemOnCart;
	
	@FindBy(id = "continue-shopping")
	WebElement continueShoppingButton;
	
	@FindBy(id = "checkout")
	WebElement checkoutButton;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement itemName;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement itemPrice;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String checkPageTitle() {
		return this.yourCartPageTitle.getText();
	}
	
	public int checkTotalItemsInCart() {
		return this.totalItems.size();
	}

	public void clickOnRemove() {
		this.removeButton.click();
	}
	
	public boolean checkItemAfterRemoval() {
		return this.zeroItemOnCart.isDisplayed();
	}
	
	public void clickContinueShopping() {
		this.continueShoppingButton.click();
	}
	
	public CheckoutInformationPage clickCheckoutButton() {
		this.checkoutButton.click();
		return new CheckoutInformationPage();
	}
	
	public String checkItemName() {
		return this.itemName.getText();
		
	}
	
	public String checkItemPrice() {
		return this.itemPrice.getText();
	}
	
}
