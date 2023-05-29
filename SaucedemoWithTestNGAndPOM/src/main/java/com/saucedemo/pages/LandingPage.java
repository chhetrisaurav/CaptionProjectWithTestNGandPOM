package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	Actions actions;

	@FindBy(id= "user-name")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy (id = "login-button")
	private WebElement login;
	
	@FindBy (xpath = "//div[contains(@class,'error-message-container error')]")
	private WebElement errMsg;
	

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		  actions = new Actions(driver);
	}
	
	public void enterUsername(String email) {
		username.sendKeys(email);
	}
	
	public void enterPassword() {
		password.sendKeys("secret_sauce");
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public String viewErrMsg() {
		String text = errMsg.getText();
		return text;
		
	}
}
