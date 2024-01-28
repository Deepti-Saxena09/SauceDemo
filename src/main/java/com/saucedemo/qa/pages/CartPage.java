package com.saucedemo.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class CartPage extends TestBase {
	// This includes Object Repository for the elements present in Your Cart page.

	@FindBy(xpath = "//span[@class='title']")
	WebElement yourCartPageTitle;

	@FindBy(xpath = "//div[@class='cart_item']")
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
		// Returning the page title.
		return this.yourCartPageTitle.getText();
	}

	public int checkTotalItemsInCart() {
		// Returning the count of total items added.
		return this.totalItems.size();
	}

	public void clickOnRemove() {
		// checking remove button working or not.
		this.removeButton.click();
	}

	public boolean checkItemAfterRemoval() {
		// checking the cart status when all the items are removed.
		return this.zeroItemOnCart.isDisplayed();
	}

	public void clickContinueShopping() {
		// clicking on continue shopping button
		this.continueShoppingButton.click();
	}

	public CheckoutInformationPage clickCheckoutButton() {
		// clicking on checkout button
		this.checkoutButton.click();
		return new CheckoutInformationPage();
	}

	public String checkItemName() {
		// Returning the item's name.
		return this.itemName.getText();

	}

	public String checkItemPrice() {
		// Returning the item's price.
		return this.itemPrice.getText();
	}

}
