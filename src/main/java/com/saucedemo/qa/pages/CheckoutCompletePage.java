package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class CheckoutCompletePage extends TestBase {
	// This includes object repository for all the elements of 'Checkout:Complete'
	// page.

	@FindBy(xpath = "//span[@class='title']")
	WebElement pageTitle;

	@FindBy(xpath = "//div[@id='checkout_complete_container']//h2")
	WebElement thankyouMessage;

	@FindBy(id = "back-to-products")
	WebElement backHomeButton;

	public CheckoutCompletePage() {
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		// Return the page title.
		return this.pageTitle.getText();
	}

	public String getOrderConfirmation() {
		// Return the thank you message.
		return this.thankyouMessage.getText();
	}

	public void clickBackToHome() {
		// clicking on 'Back to home' button.
		this.backHomeButton.click();
	}

}
