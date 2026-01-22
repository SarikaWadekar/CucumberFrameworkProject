package stepDefinations;

import java.io.IOException;

import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.*;
import pageObjects.OrdersPagePO;
import utilities.TestContextSetup;

public class OrdersStepDefination {

	TestContextSetup testContextSetup;
	OrdersPagePO ordersPagePO;

	public OrdersStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		ordersPagePO = testContextSetup.pageObjectManager.getOrdersPagePO();
	}
	
	@Then("orderID should be same as displayed in the order summary page")
	public void orderid_should_be_same_as_displayed_in_the_order_summary_page() throws InterruptedException, IOException {
		String ordersOrderID = ordersPagePO.getOrdersOrderId(testContextSetup.getOrderId());
		System.out.println("Order ID displayed in orders page is "+ordersOrderID);
		System.out.println("Validating Order ID displayed in orders summary page is "+testContextSetup.getOrderId());
		//Assert.assertEquals(ordersOrderID, testContextSetup.getOrderId(), "OrderID is not same as displayed in order summary page");
		testContextSetup.getSoftAssert().assertEquals(ordersOrderID, testContextSetup.getOrderId(), "OrderID is not same as displayed in order summary page");
		if (!ordersOrderID.equals(testContextSetup.getOrderId())) {
	        ScreenShotUtils.addScreenshot(testContextSetup.testBase.WebDriverManager(), testContextSetup.getScenario());
	        testContextSetup.getSoftAssert().fail("Validation failed in step: Expected message '" + testContextSetup.getOrderId() + "', but got '" + ordersOrderID + "'");
	    }else {
	    	System.out.println("****** Successfully displayed OrderID same as in the order summary page ******");
	    }
	}
	
}
