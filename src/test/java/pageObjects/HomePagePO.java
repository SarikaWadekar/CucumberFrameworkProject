package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import utilities.ExplicitWaitHelper;
import utilities.Util;

public class HomePagePO {
	public WebDriver driver;
	Util util;
	ExplicitWaitHelper explicitWaitHelper;
	public String actualText;
	public boolean flag;
	
	
	public HomePagePO(WebDriver driver) {
		this.driver=driver;
		this.util = new Util(driver);
		this.explicitWaitHelper = new ExplicitWaitHelper(driver);
	}
	
	By cartTab = By.xpath("//button[@routerlink='/dashboard/cart']");
	By ordersTab = By.xpath("//button[@routerlink='/dashboard/myorders']");
	By cardName = By.xpath("//div[@class='card-body']/h5/b");
	By addToCartButton = By.xpath("//button[@class='btn w-10 rounded']");
	By toastMessage = By.xpath("//div[@role='alert']");
	By orderToastMessage = By.xpath("//div[@id='toast-container']//div");
	By addProductToastMessage = By.xpath("//div[@aria-label='Product Added To Cart']");
	
	public Util getUtil() {
		return this.util;
	}
	
	public void explicitWaitForInvisibilityOfElement() {
		explicitWaitHelper.WaitForInvisibilityOfElement(addProductToastMessage, 100);
	}
	
	public String getHomePageUrl() {
		explicitWaitHelper.WaitForURLToBe("https://rahulshettyacademy.com/client/#/dashboard/dash", 50);
		return util.getCurrentUrl();
	}
	
	public void clickTab(String tabName) throws InterruptedException {
		Map<String, By> locatorMap = new HashMap<>();
		locatorMap.put("Cart", cartTab);
		locatorMap.put("Orders", ordersTab);
		Thread.sleep(2000L);
		explicitWaitHelper.WaitForElementToBeClickable(locatorMap.get(tabName), 100);
		WebElement element = driver.findElement(locatorMap.get(tabName));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public void clickSpecificAddToCartButton(String expectedText) {
		explicitWaitHelper.waitForNoOfElementsMoreThan(cardName, 3, 100);
		int noOfCards = driver.findElements(cardName).size();
		for(int i = 0; i < noOfCards; i++) {
			String cardText = driver.findElements(cardName).get(i).getText();
			if(cardText.equals(expectedText)) {
				System.out.println("Card displayed is "+cardText);
				explicitWaitHelper.WaitForElementToBeClickable(addToCartButton, 100);
				driver.findElements(addToCartButton).get(i).click();
				break;
			}
		}
	}
	
	public String toastMessageValidation(String expectedToastMessage) {

		Map<String, By> locatorMap = new HashMap<>();
		locatorMap.put(" Product Added To Cart ", toastMessage);
		locatorMap.put(" Order Placed Successfully ", orderToastMessage);
		locatorMap.put(" Please Enter Full Shipping Information ", orderToastMessage);
		actualText = (String) ((JavascriptExecutor) driver)
			    .executeScript("return arguments[0].textContent;", driver.findElement(locatorMap.get(expectedToastMessage)));
		return actualText;
	}
	
	public int cartItemCountValidation() {
		String cartCount = driver.findElement(RelativeLocator.with(By.tagName("label")).near(cartTab)).getText();
		return util.convertStringToInt(cartCount);
	}

}
