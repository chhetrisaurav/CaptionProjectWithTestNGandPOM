package com.saucedemo.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CheckOutDetails;
import com.saucedemo.pages.LandingPage;
import com.saucedemo.pages.ProductList;
import com.saucedemo.pages.ShoppingCart;

public class ScenarioThree extends BaseTest {
	
	@Test
	public void scenarioThree() {
		
	//	1)Enter the username – ‘problem_user’, password ‘secret_sauce’ and then click on Login button.
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterUsername("problem_user");
		landingPage.enterPassword();
		landingPage.clickLogin();
		
	//	2)You will see a list of products. Add the 1st product to the cart.
		ProductList productList = new ProductList(driver);
		productList.addFirstItem();
		
	//	3)Click on the cart icon at top right corner. 
		productList.clickShoppingCart();
		
	//	4)Click on ‘Checkout’ button.
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		shoppingCart.clickCheckout();
		
	//	5)Enter your first name in ‘First Name’ textbox.
		CheckOutDetails checkoutDetails = new CheckOutDetails(driver);
		checkoutDetails.enterFirstname("Sam");
		
	//	6)Enter your last name in ‘Last Name’ textbox.
		checkoutDetails.enterLastname("Jackson");
		
	//	7)Enter Postal Code in ‘Postal Code’ textbox.
		checkoutDetails.enterPostalCode("34567");
		
	//	8)Click on ‘Continue’ button.
		checkoutDetails.clickContinue();
		
	//	9)You will see the ‘Last Name’ text-box gets emptied automatically and an error message is 
	//	displayed. Verify the error message – ‘Error: Last Name is required’ is displayed to the user.
		String expectedErrMsg = "Error: Last Name is required";
		String actualErrMsg = checkoutDetails.getErrTxt();
		
		Assert.assertEquals(expectedErrMsg, actualErrMsg);
	}
	
}
