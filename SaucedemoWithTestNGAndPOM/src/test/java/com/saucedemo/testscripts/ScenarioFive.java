package com.saucedemo.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CheckOutDetails;
import com.saucedemo.pages.CheckoutComplete;
import com.saucedemo.pages.CheckoutOverview;
import com.saucedemo.pages.LandingPage;
import com.saucedemo.pages.ProductList;
import com.saucedemo.pages.ShoppingCart;

public class ScenarioFive extends BaseTest {
	
	@Test
	public void scenarioFive() {
		
	//	2) Enter the username – ‘standard_user’ , password ‘secret_sauce’ and then click on Login button.
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterUsername("standard_user");
		landingPage.enterPassword();
		landingPage.clickLogin();
		
	//	3) You will see a list of products. Add the first and third products to the cart.
		ProductList productList = new ProductList(driver);
		productList.addFirstItem();
		productList.addThirdItem();
		
	//	4) Now remove the first product from the cart.
		productList.removeFirstProduct();
		
	//	5) Click on cart icon at top right corner. 
		productList.clickShoppingCart();
		
	//	6) Verify the text ‘Your Cart’ is displayed at the top left corner of the page. 
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		String expectedtext = "Your Cart";
		String actualText = shoppingCart.getYourCartText();
		
		Assert.assertEquals(actualText, expectedtext);
		
	//	7) Click on ‘Continue Shopping’ button.
		shoppingCart.clickContinueBtn();
		
	//	8) Sort the prices from high to low.
		productList.clickFilter();
		productList.selectHitoLow();
		
	//	9) Add the most expensive item to the cart. 
		productList.addHighPriceItem();
		
	//	10) Click on cart icon.
		productList.clickShoppingCart();
		
	//	11) Now verify that there are 2 items in the cart.
		String expectedItemsOnCart = "2";
		String actualItemsOnCart = shoppingCart.numberOfItemsInCart();
		
		Assert.assertEquals(actualItemsOnCart, expectedItemsOnCart);
		
	//	12) Click on ‘Checkout’ button.
		shoppingCart.clickCheckout();
		
	//	13) Enter your first name in ‘First Name’ textbox.
		CheckOutDetails checkoutDetails = new CheckOutDetails(driver);
		checkoutDetails.enterFirstname("Amir");
		
	//	14) Enter your last name in ‘Last Name’ textbox.
		checkoutDetails.enterLastname("Khan");
		
	//	15) Enter Postal Code in ‘Postal Code’ textbox.
		checkoutDetails.enterPostalCode("45675");
		
	//	16) Click on ‘Continue’ button.
		checkoutDetails.clickContinue();
		
	//	17) Click on ‘Finish’ button on the next page.
		CheckoutOverview checkoutOverview = new CheckoutOverview(driver);
		checkoutOverview.clickFinishBtn();
		
	//	18) Verify the success message – ‘Thank you for your order!’ is displayed to the user
		CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
		String expectedMsg = "Thank you for your order!";
		String actualMsg = checkoutComplete.getThankYouMsg();
		
		Assert.assertEquals(actualMsg, expectedMsg);
	}

}
