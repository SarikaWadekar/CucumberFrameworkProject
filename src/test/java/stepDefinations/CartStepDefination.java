package stepDefinations;

import java.io.IOException;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.*;
import pageObjects.CartPagePO;
import utilities.TestContextSetup;

public class CartStepDefination {

	TestContextSetup testContextSetup;
	CartPagePO cartPagePO;
	String summaryOrderID;


	public CartStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		cartPagePO = testContextSetup.pageObjectManager.getCartPagePO();
	}

	@Then("Added product {string} should be displayed in cart")
	public void added_product_should_be_displayed_in_cart(String expectedProductName) throws IOException {
		String actualProductName = cartPagePO.getProductName();
		System.out.println("Product displayed in cart page is " + actualProductName);
		//Assert.assertEquals(actualProductName, expectedProductName.toUpperCase(), "Right product is not added to the cart");
		testContextSetup.getSoftAssert().assertEquals(actualProductName, expectedProductName.toUpperCase(), "Right product is not added to the cart");
		if (!actualProductName.equals(expectedProductName.toUpperCase())) {
	        ScreenShotUtils.addScreenshot(testContextSetup.testBase.WebDriverManager(), testContextSetup.getScenario());
	        testContextSetup.getSoftAssert().fail("Validation failed in step: Expected message '" + expectedProductName.toUpperCase() + "', but got '" + actualProductName + "'");
	    }else {
	    	System.out.println("****** Successfully displayed added product in cart ******");
	    }
	}
	
	@When("Placed the order selecting country as {string}")
	public void placed_the_order_selecting_country_as(String country) throws InterruptedException {
		cartPagePO.placeOrder(country);
	}
	
	@Then("{string} should be displayed")
	public void should_be_displayed(String expectedMessageString) throws IOException {
		String actualString = cartPagePO.messageStringValidation();
		System.out.println("Message displayed is "+actualString);
		testContextSetup.getSoftAssert().assertEquals(actualString, expectedMessageString,"Incorrect Message is displayed for successful order");
			if (!actualString.equals(expectedMessageString)) {
		        ScreenShotUtils.addScreenshot(testContextSetup.testBase.WebDriverManager(), testContextSetup.getScenario());
		        testContextSetup.getSoftAssert().fail("Validation failed in step: Expected message '" + expectedMessageString + "', but got '" + actualString + "'");
		    }else {
		    	System.out.println("****** Successfully displayed message "+actualString+" ******");
		    }
		
	}
	
	@Then("{string} product name should be displayed on order summary page")
	public void product_name_should_be_displayed_on_order_summary_page(String expectedString) throws IOException {
		String actualString = cartPagePO.summaryProductNameValidation();
		System.out.println("Summary product name displayed is "+actualString);
		//Assert.assertEquals(actualString, expectedString,"Product name is not displayed correctly");
		testContextSetup.getSoftAssert().assertEquals(actualString, expectedString,"Product name is not displayed correctly");
		if (!actualString.equals(expectedString)) {
	        ScreenShotUtils.addScreenshot(testContextSetup.testBase.WebDriverManager(), testContextSetup.getScenario());
	        testContextSetup.getSoftAssert().fail("Validation failed in step: Expected message '" + expectedString + "', but got '" + actualString + "'");
	    }else {
	    	System.out.println("****** Successfully displayed product name on order summary page ******");
	    }
	}
	
	@When("fetch the generated orderID")
	public void fetch_the_generated_orderID() {
		summaryOrderID = cartPagePO.fetchOrderID();
		System.out.println("OrderId generated in summary Page is "+summaryOrderID);
		testContextSetup.setOrderId(summaryOrderID);

	}
	
	@Then("assertAll validations")
	public void assert_all_validations() {
		testContextSetup.getSoftAssert().assertAll();
	}
}
