package com.saucedemo.qa.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class ProductsPage extends TestBase {

	// This contains object repository for all the elements present in Products
	// page.
	@FindBy(xpath = "//span[@class='title']")
	WebElement ProductsPageTitle;

	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement ProductsPageLogo;

	@FindBy(xpath = "//div[@class='inventory_item']")
	List<WebElement> itemList;

	@FindBy(xpath = "//div[@class='inventory_item_name '][1]")
	WebElement itemName;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> itemPrice;

	@FindBy(xpath = "//button[starts-with(@id,'add-to-cart-')]")
	List<WebElement> addToCartButtons;

	@FindBy(xpath = "//button[starts-with(@id,'remove-')]")
	List<WebElement> removeButtons;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	public WebElement cartCounter;

	@FindBy(id = "shopping_cart_container")
	WebElement addToCart;

	@FindBy(xpath = "//button[starts-with(@id,'add-to-cart-')][1]")
	WebElement firstAddToCartButton;

	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}

	public String checkProductsPageTitle() {
		// Returning the title of the page.
		return this.ProductsPageTitle.getText();
	}

	public String checkProductPageLogoName() {
		// Returning the logo name of the page.
		return this.ProductsPageLogo.getText();
	}

	public int checkItemCount() {
		// returning the total count of items present on page.
		return this.itemList.size();
	}

	public String checkItemName() {
		// returning the 'item name'.
		return this.itemName.getText();
	}

	public String checkItemPrice() {
		// returning the 'itemPrice'.
		return this.itemPrice.get(0).getText();
	}

	public void addAllItemsToCart() {
		// This will add all the items present in the page to the cart.
		Iterator<WebElement> cartButtonIterator = this.addToCartButtons.iterator();

		while (cartButtonIterator.hasNext()) {
			cartButtonIterator.next().click();
		}
	}

	public void removeItemsFromCart() {
		// This will remove items from the cart.
		for (int i = 0; i < this.removeButtons.size(); i++) {
			this.removeButtons.get(i).click();
		}
	}

	public CartPage clickonCart() {
		// This will click on 'Cart' icon
		this.addToCart.click();
		return new CartPage();

	}

	public void clickFirstAddtocartButton() {
		// Redirected page
		this.firstAddToCartButton.click();
	}
}
