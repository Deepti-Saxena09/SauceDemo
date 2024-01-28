package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class LoginPage extends TestBase {

	// This file includes 'Object Repository' of the elements which are present on
	// 'Login' page.

	@FindBy(id = "user-name")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "login-button")
	WebElement login;

	@FindBy(xpath = "//div[@class='error-message-container error']")
	WebElement errorMessage;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// List of methods which can be performed on above added object repository are
	// mentioned below:

	public void enterValidUsername() {
		// This is submitting 'valid username'.
		this.username.sendKeys("standard_user");

	}

	public void enterValidPassword() {
		// This is submitting valid password.
		this.password.sendKeys("secret_sauce");
	}

	public void enterInvalidUsernameAndPassword() {
		// This is submitting invalid username and invalid password.
		this.username.sendKeys(prop.getProperty("invalid_Username"));
		this.password.sendKeys(prop.getProperty("invalid_password"));
	}

	public void clickLoginButton() {
		// This is clicking on 'Login' button
		this.login.click();
	}

	public String emptyFieldErrorMessage() {
		// This is returning the error message on no inputs in the fields
		this.username.sendKeys("");
		this.password.sendKeys("");
		this.clickLoginButton();
		return this.errorMessage.getText();

	}

	public String invalidCredentialErrorMessage() {
		// This is returning the error message for invalid login attempt
		this.enterInvalidUsernameAndPassword();
		this.clickLoginButton();
		return this.errorMessage.getText();
	}

	public ProductsPage checkProductPageNavigationOnCorrectLogin() {
		// This is next redirected page
		return new ProductsPage();
	}
}
