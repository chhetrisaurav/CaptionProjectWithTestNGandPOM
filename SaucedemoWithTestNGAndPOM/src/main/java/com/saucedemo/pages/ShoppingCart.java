package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	
	Actions actions;
	
	@FindBy(id = "checkout")
	private WebElement checkout;
	
	@FindBy(xpath = "//span[contains(@class,'title')]")
	private WebElement yourCart;
	
	@FindBy(xpath = "//div[contains(@class,'inventory_item_desc')]")
	private WebElement cartItemDetail;
	
	@FindBy(id = "continue-shopping")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//span[contains(@class,'shopping_cart_badge')]")
	private WebElement itemsOnCart;
	
	public ShoppingCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions (driver);
	}
	
	public void clickCheckout() {
		checkout.click();
	}
	
	public String getCartItemDetail() {
		String  detail = cartItemDetail.getText();
				return detail;
	}
	
	public String getYourCartText() {
		String text = yourCart.getText();
		return text;
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
	public String numberOfItemsInCart() {
		String text = itemsOnCart.getText();
		return text;
	}
	
}
