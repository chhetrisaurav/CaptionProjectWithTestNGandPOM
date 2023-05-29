package com.saucedemo.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.LandingPage;

public class ScenarioTwo extends BaseTest{
	
	@Test
	public void scenarioTwo() {
		
	//	2) Enter the username – ‘locked_out_user’ in the ‘Username’ textbox.
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterUsername("locked_out_user");
		
	//	3) Enter password ‘secret_sauce’ in the ‘Password’ textbox.
		landingPage.enterPassword();
		
	//	4) Click on Login button.
		landingPage.clickLogin();
		
	//	5) Verify the error message – ‘Epic sadface: Sorry, this user has been locked out.’ is displayed on the web-page
		String expectedErrMsg = "Epic sadface: Sorry, this user has been locked out.";
		String actualErrMsg = landingPage.viewErrMsg();
		
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}

}
