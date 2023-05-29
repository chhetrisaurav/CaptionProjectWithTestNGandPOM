package com.saucedemo.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CheckOutDetails;
import com.saucedemo.pages.CheckoutComplete;
import com.saucedemo.pages.CheckoutOverview;
import com.saucedemo.pages.LandingPage;
import com.saucedemo.pages.ProductList;
import com.saucedemo.pages.ShoppingCart;

public class ScenarioOne extends BaseTest{
	
	@Test
	public void scenarioOne() {
		
		LandingPage landingPage = new LandingPage(driver);
		//2) Enter the username – ‘standard_user’ , password ‘secret_sauce’ and then click on Login button.
		landingPage.enterUsername("standard_user");
		landingPage.enterPassword();
		landingPage.clickLogin();
		
		//3) Add the first 2 products to the cart.
		ProductList productList = new ProductList(driver);
		productList.addFirstItem();
		productList.addSecItem();
		
		//4) Click on the cart icon at top right corner. 
		productList.clickShoppingCart();
		
		//5) Click on ‘Checkout’ button.
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		shoppingCart.clickCheckout();
		
		//6) Enter first name
		CheckOutDetails checkoutDetails = new CheckOutDetails(driver);
		checkoutDetails.enterFirstname("Sam");
		
		//7) Enter last name
		checkoutDetails.enterLastname("Jackson");
		
		//8) Enter postal code
		checkoutDetails.enterPostalCode("23456");
		
		//9) Click continue button
		checkoutDetails.clickContinue();
		
		//10) Click finish button on the next page
		CheckoutOverview checkoutOverview = new CheckoutOverview(driver);
		checkoutOverview.clickFinishBtn();
		
		//11) Verify the success message – ‘Your order has been dispatched, and will arrive just as fast as the 
		//	pony can get there!’ is displayed.
		CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
		String expectedMsg = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actualMsg = checkoutComplete.getSuccessMsg();
		
		Assert.assertEquals(actualMsg, expectedMsg);
		
		
	}

}
