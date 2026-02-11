package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        PageFactory.initElements(driver, this);
    }

    // PageFactory locators
    @FindBy(xpath = "//div[@class='cartSection']/h3")
    private WebElement productName;

    @FindBy(xpath = "(//button[@class='btn btn-primary'])[2]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    private WebElement selectCountryField;

    @FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//h1[@class='hero-primary']")
    private WebElement messageString;

    @FindBy(xpath = "//label[@class='ng-star-inserted']")
    private WebElement orderId;

    @FindBy(xpath = "//div[@class='title']")
    private WebElement summaryProductName;


    public Util getUtil() {
        return this.util;
    }

    public String getProductName() {
        return util.getElementText(productName);
    }

    public void placeOrder(String country) throws InterruptedException {
        checkoutButton.click();
        explicitWaitHelper.WaitForVisibilityOfElement(selectCountryField, 100);
       selectCountryField.sendKeys(country);
        Thread.sleep(1000L);
        selectCountryField.sendKeys(Keys.ENTER);
        placeOrderButton.click();
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
