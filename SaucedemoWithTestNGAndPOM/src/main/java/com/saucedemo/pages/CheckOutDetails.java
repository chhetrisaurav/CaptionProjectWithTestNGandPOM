package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutDetails {
	
	Actions actions;
	
	@FindBy(id = "first-name")
	private WebElement firstname;
	
	@FindBy (id = "last-name")
	private WebElement lastname;
	
	@FindBy (id = "postal-code")
	private WebElement postalCode;
	
	@FindBy(id = "continue")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//div[contains(@class,'error-message-container error')]")
	private WebElement errText;
	
	
	
	public CheckOutDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void enterFirstname(String name) {
		firstname.sendKeys(name);
	}
	public void enterLastname(String name) {
		lastname.sendKeys(name);
	}
	public void enterPostalCode(String num) {
		postalCode.sendKeys(num);
	}
	public void clickContinue() {
		continueBtn.click();
	}
	
	public String getErrTxt() {
		String text = errText.getText();
		return text;
	}
	
}
