package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
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

	
	public void enterValidUsername() {
		this.username.sendKeys("standard_user");
	
	}
	
	public void enterValidPassword() {
		this.password.sendKeys("secret_sauce");
	}
	
	public void enterInvalidUsernameAndPassword() {
		this.username.sendKeys(prop.getProperty("invalid_Username"));
		this.password.sendKeys(prop.getProperty("invalid_password"));
	}
	
	public void clickLoginButton() {
		this.login.click();
	}
	
	public String emptyFieldErrorMessage() {
		this.username.sendKeys("");
		this.password.sendKeys("");
		this.clickLoginButton();
		return this.errorMessage.getText();
		
	}
	
	public String invalidCredentialErrorMessage() {
		this.enterInvalidUsernameAndPassword();
		this.clickLoginButton();
		return this.errorMessage.getText();
	}
	
	public ProductsPage checkProductPageNavigationOnCorrectLogin() {
		return new ProductsPage();
	}
}
