package com.saucedemo.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CheckOutDetails;
import com.saucedemo.pages.CheckoutComplete;
import com.saucedemo.pages.CheckoutOverview;
import com.saucedemo.pages.LandingPage;
import com.saucedemo.pages.ProductList;
import com.saucedemo.pages.ShoppingCart;


public class ScenarioFour extends BaseTest {
	
	@Test
	public void scenarioFour() {
		
	//	2) Enter the username – ‘standard_user’ , password ‘secret_sauce’ and then click on Login button.
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterUsername("standard_user");
		landingPage.enterPassword();
		landingPage.clickLogin();
		
	//	3)Sort the items based on Price from low to high.
		ProductList productList = new ProductList(driver);
		productList.clickFilter();
		productList.selectPriceLotoHi();
		
	//	4)Add the first item to cart.
		productList.itemWithLowPrice();
		String previousPageItem = productList.getItemDetail();
		
		
	//	5)Verify the same item which you selected on the previous page has been added to cart.
		
		productList.clickShoppingCart();
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		
		String thisPageItem = shoppingCart.getCartItemDetail();
		
		Assert.assertEquals(thisPageItem, previousPageItem);
		
	//	6)Click on ‘Checkout’ button.
		shoppingCart.clickCheckout();
		
	//	7)Enter your first name in ‘First Name’ textbox.
		CheckOutDetails checkoutDetails = new CheckOutDetails(driver);
		checkoutDetails.enterFirstname("Jack");
		
	//	8)Enter your last name in ‘Last Name’ textbox.
		checkoutDetails.enterLastname("Sparrow");
		
	//	9)Enter Postal Code in ‘Postal Code’ textbox.
		checkoutDetails.enterPostalCode("34556");
		
	//	10)Click on ‘Continue’ button.
		checkoutDetails.clickContinue();
		
	//	11)Click on ‘Finish’ button on the next page.
		CheckoutOverview checkoutOverview = new CheckoutOverview(driver);
		checkoutOverview.clickFinishBtn();
		
	//	12)Verify the success message – ‘Thank you for your order!’ is displayed to the user.
		CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
		String expectedMsg = "Thank you for your order!";
		String actualMsg = checkoutComplete.getThankYouMsg();
		
		Assert.assertEquals(actualMsg, expectedMsg);
				
	}

}
