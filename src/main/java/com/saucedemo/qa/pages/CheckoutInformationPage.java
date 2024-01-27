package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class CheckoutInformationPage extends TestBase {

	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id = "postal-code")
	WebElement postalCode;
	
	@FindBy(xpath = "//div[@class='error-message-container error']")
	WebElement errorMessage;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	@FindBy(xpath = "//span[@class='title']")
	WebElement checkoutPageTitle;

	
	public CheckoutInformationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String checkMandtoryFields() {
		this.continueButton.click();
		return this.errorMessage.getText();
	}
	
	public void enterData() {
		this.firstName.sendKeys("Deepti");
		this.lastName.sendKeys("Deepti");
		this.postalCode.sendKeys("560035");
	}
	
	public CheckoutOverviewPage clickContinue() {
		this.continueButton.click();
		return new CheckoutOverviewPage();
	}
	
	public String checkPageTitle() {
		return this.checkoutPageTitle.getText();
	}
}
