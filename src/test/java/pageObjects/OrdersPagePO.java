package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import utilities.ExplicitWaitHelper;
import utilities.Util;

public class OrdersPagePO {
	public WebDriver driver;
	Util util;
	ExplicitWaitHelper explicitWaitHelper;
	public String actualText;
	public boolean flag;
	
	
	public OrdersPagePO(WebDriver driver) {
		this.driver=driver;
		this.util = new Util(driver);
		this.explicitWaitHelper = new ExplicitWaitHelper(driver);
	}
	
	By ordersOrderID = By.xpath("//table[@class='table table-bordered table-hover ng-star-inserted']/tbody/tr/th");
	
	
	public Util getUtil() {
		return this.util;
	}
	
	public String getOrdersOrderId(String expectedOrderID) throws InterruptedException {
		return util.dataValidationText(ordersOrderID, expectedOrderID);
	}
	
	
}
