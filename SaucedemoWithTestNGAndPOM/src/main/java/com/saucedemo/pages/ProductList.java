package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductList {
	
	Actions actions;
	
		
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement firstItem;
	
	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removeFirstItem;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement secItem;
	
	@FindBy (id = "add-to-cart-sauce-labs-onesie")
	private WebElement lowPriceItem;
	
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	private WebElement hignPriceItem;
	
	@FindBy (id = "shopping_cart_container")
	private WebElement shoppingCart;
	
	@FindBy(xpath = "//select[contains(@class,'product_sort_container')]")
	private WebElement filter;
	
	@FindBy(xpath = "(//div[contains(@class,'inventory_item_desc')])[2]")
	private WebElement firstItemDetail;
	
	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement thirdItem;
	
	
	public ProductList(WebDriver driver) {
		PageFactory.initElements(driver, this);
		  actions = new Actions(driver);
	
	}
	
	public void addFirstItem() {
		firstItem.click();
	}
	public void addSecItem() {
		secItem.click();
	}
	
	public void clickShoppingCart() {
		shoppingCart.click();
	}
	
	public void clickFilter() {
		filter.click();
	}
	
	public void selectPriceLotoHi() {
		Select select = new Select(filter);
		select.selectByValue("lohi");
	}
	
	public void selectHitoLow() {
		Select select = new Select(filter);
		select.selectByValue("hilo");
	}
	
	public void itemWithLowPrice() {
		lowPriceItem.click();
	}
	
	public void addHighPriceItem() {
		hignPriceItem.click();
	}
	
	public String getItemDetail() {
		String text = firstItemDetail.getText();
		return text;
	}
	
	public void addThirdItem() {
		thirdItem.click();
	}
	
	public void removeFirstProduct() {
		removeFirstItem.click();
	}

}
