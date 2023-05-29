package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {
	
	Actions actions;
	
	@FindBy(xpath = "//div[contains(@class,'complete-text')]")
	private WebElement successMsg;
	
	@FindBy(xpath = "//h2[contains(@class,'complete-header')]")
	private WebElement thankYouMsg;
	
	public CheckoutComplete(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public String getSuccessMsg() {
		String text = successMsg.getText();
		return text;
	}
	
	public String getThankYouMsg() {
		String text = thankYouMsg.getText();
		return text;
	}
	

}
