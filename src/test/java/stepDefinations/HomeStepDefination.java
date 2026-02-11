package stepDefinations;

import io.cucumber.java.en.*;
import pageObjects.HomePagePO;
import utilities.TestContextSetup;

import java.io.IOException;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomeStepDefination {

	TestContextSetup testContextSetup;
	HomePagePO homePagePO;

	public HomeStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		homePagePO = testContextSetup.pageObjectManager.getHomePagePO();
	}

	@Given("User is on home page")
	public void user_is_on_home_page() {
		String currentURL = homePagePO.getHomePageUrl();
		System.out.println("Current URL is " + currentURL);
		System.out.println("Navigated to home page");

	}

	@When("User clicks on Add to cart button of {string} card")
	public void user_clicks_on_Add_to_cart_button_of_card(String expectedCard) {
		homePagePO.clickSpecificAddToCartButton(expectedCard.toUpperCase());
		System.out.println("Clicked on Add To Cart button");
	}
	
	@When("Wait for invisibility of element")
	public void wait_for_invisibility_of_element() {
		homePagePO.explicitWaitForInvisibilityOfElement();
	}
	
	@Then("toast message should be displayed {string}")
	public void toast_message_should_be_displayed(String expectedToastText) throws IOException {
		String actualText = homePagePO.toastMessageValidation(expectedToastText);
		System.out.println("Toast message displayed is " + actualText);
		//Assert.assertEquals(actualText, expectedToastText, "Toast message is not displayed correctly");
		testContextSetup.getSoftAssert().assertEquals(actualText, expectedToastText, "Toast message is not displayed correctly");
		if (!actualText.equals(expectedToastText)) {
	        ScreenShotUtils.addScreenshot(testContextSetup.testBase.WebDriverManager(), testContextSetup.getScenario());
	        testContextSetup.getSoftAssert().fail("Validation failed in step: Expected message '" + expectedToastText + "', but got '" + actualText + "'");
	    }else {
	    	System.out.println("****** Successfully displayed toast message "+actualText+" ******");
	    }
	}

	@Then("Cart count is increased by {int}")
	public void cart_count_is_increased_by(int expectedCartCount) throws IOException {
		int actualCartCount = homePagePO.cartItemCountValidation();
		System.out.println("Actual cart count displayed is " + actualCartCount);
		//Assert.assertEquals(actualCartCount, expectedCartCount, "Cart count is not increased");
		testContextSetup.getSoftAssert().assertEquals(actualCartCount, expectedCartCount, "Cart count is not increased");
		if (actualCartCount != expectedCartCount) {
			ScreenShotUtils.addScreenshot(testContextSetup.testBase.WebDriverManager(), testContextSetup.getScenario());
			testContextSetup.getSoftAssert().fail("Validation failed in step: Expected message '" + expectedCartCount + "', but got '" + actualCartCount + "'");
		}else {
	    	System.out.println("****** Successfully increased cart count by "+actualCartCount + " ******");
	    }
		
	}

	@When("Clicked on the tab {string}")
	public void clicked_on_the_tab(String tabName) throws InterruptedException {
		Thread.sleep(1000L);
		HomePagePO.Tab tab = HomePagePO.Tab.valueOf(tabName.toUpperCase()); // convert string to enum
        homePagePO.clickTab(tab);
	}

}
