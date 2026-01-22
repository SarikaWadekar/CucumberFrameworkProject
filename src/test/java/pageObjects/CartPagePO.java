package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import utilities.ExplicitWaitHelper;
import utilities.Util;

public class CartPagePO {
	public WebDriver driver;
	Util util;
	ExplicitWaitHelper explicitWaitHelper;
	public String actualText;
	public boolean flag;
	
	
	public CartPagePO(WebDriver driver) {
		this.driver=driver;
		this.util = new Util(driver);
		this.explicitWaitHelper = new ExplicitWaitHelper(driver);
	}
	
	By productName = By.xpath("//div[@class='cartSection']/h3");
	By checkoutButton = By.xpath("(//button[@class='btn btn-primary'])[2]");
	By selectCountryField = By.xpath("//input[@placeholder='Select Country']");
	By placeOrderButton = By.xpath("//a[@class='btnn action__submit ng-star-inserted']");
	By messageString = By.xpath("//h1[@class='hero-primary']");
	By orderId = By.xpath("//label[@class='ng-star-inserted']");
	By summaryProductName = By.xpath("//div[@class='title']");
	
	
	public Util getUtil() {
		return this.util;
	}
	
	public String getProductName() {
		return util.getElementText(productName);
	}
	
	public void placeOrder(String country) throws InterruptedException {
		driver.findElement(checkoutButton).click();
		explicitWaitHelper.WaitForVisibilityOfElement(selectCountryField, 100);
		driver.findElement(selectCountryField).sendKeys(country);
		Thread.sleep(1000L);
		driver.findElement(selectCountryField).sendKeys(Keys.ENTER);
		driver.findElement(placeOrderButton).click();
	}
	
	public String messageStringValidation() {
		return util.getElementText(messageString);
	}
	
	public String summaryProductNameValidation() {
		return util.getElementText(summaryProductName);
	}
	
	public String fetchOrderID() {
		return util.getElementText(orderId).substring(2,26);
	}
	

}
