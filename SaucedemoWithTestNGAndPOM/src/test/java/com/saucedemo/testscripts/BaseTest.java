package com.saucedemo.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void lunchBrowser() {
		//Open Chrome
		driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//	1) Go to https://www.saucedemo.com/	
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
