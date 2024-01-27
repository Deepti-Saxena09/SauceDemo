package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class CheckoutCompletePage extends TestBase {
	
	@FindBy(xpath = "//span[@class='title']")
	WebElement pageTitle;
	
	@FindBy(xpath ="//div[@id='checkout_complete_container']//h2")
	WebElement thankyouMessage;
	
	@FindBy(id = "back-to-products")
	WebElement backHomeButton;
	
	public CheckoutCompletePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return this.pageTitle.getText();
	}
	
	public String getOrderConfirmation() {
		return this.thankyouMessage.getText();
	}
	
	public void clickBackToHome() {
		this.backHomeButton.click();
	}
	

}
