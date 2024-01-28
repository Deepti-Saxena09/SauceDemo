package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class CheckoutOverviewPage extends TestBase {
	// This includes object repository for 'Checkout:Overview' page.

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement itemName;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement itemPrice;

	@FindBy(xpath = "//div[@class='summary_value_label'][1]")
	WebElement paymentInformation;

	@FindBy(xpath = "//div[@class='summary_value_label'][2]")
	WebElement shippingInformation;

	@FindBy(id = "finish")
	WebElement finishButton;

	public CheckoutOverviewPage() {
		PageFactory.initElements(driver, this);
	}

	public String getItemName() {
		// Return the page title.
		return this.itemName.getText();
	}

	public String getItemPrice() {
		// Return the page price.
		return this.itemPrice.getText();
	}

	public String getPaymentInformation() {
		// Return the payment information
		return this.paymentInformation.getText();
	}

	public String getShippingInformation() {
		// Return the shipping information
		return this.shippingInformation.getText();
	}

	public CheckoutCompletePage clickFinish() {
		// Finishing the checkout
		this.finishButton.click();
		return new CheckoutCompletePage();
	}

}
