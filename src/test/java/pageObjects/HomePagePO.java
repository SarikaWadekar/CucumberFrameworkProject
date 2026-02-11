package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import utilities.ExplicitWaitHelper;
import utilities.Util;

public class HomePagePO {
	public WebDriver driver;
	Util util;
	ExplicitWaitHelper explicitWaitHelper;
	public String actualText;
	public boolean flag;
	
	
	By cartTabLocator = By.xpath("//button[@routerlink='/dashboard/cart']");

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    private WebElement cartTab;

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    private WebElement ordersTab;

    @FindBy(xpath = "//div[@class='card-body']/h5/b")
    private java.util.List<WebElement> cardName;

    @FindBy(xpath = "//button[@class='btn w-10 rounded']")
    private java.util.List<WebElement> addToCartButtonList;

     @FindBy(xpath = "//button[@class='btn w-10 rounded']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement toastMessage;

    @FindBy(xpath = "//div[@id='toast-container']//div")
    private WebElement orderToastMessage;

    @FindBy(xpath = "//div[@aria-label='Product Added To Cart']")
    private WebElement addProductToastMessage;


    public HomePagePO(WebDriver driver) {
        this.driver=driver;
        this.util = new Util(driver);
        this.explicitWaitHelper = new ExplicitWaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

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

    // Define an enum for tabs
    public enum Tab {
        CART,
        ORDERS
    }

    public void clickTab(Tab tab) throws InterruptedException {
        WebElement element;

        switch (tab) {
            case CART:
                element = cartTab;
                break;
            case ORDERS:
                element = ordersTab;
                break;
            default:
                throw new IllegalArgumentException("Unknown tab: " + tab);
        }

        Thread.sleep(2000L);
        explicitWaitHelper.WaitForElementToBeClickable(element, 100);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


    public void clickSpecificAddToCartButton(String expectedText) {
        explicitWaitHelper.waitForNoOfElementsMoreThan(cardName, 3, 100);
        int noOfCards = cardName.size();
        for(int i = 0; i < noOfCards; i++) {
            String cardText = cardName.get(i).getText();
            if(cardText.equals(expectedText)) {
                System.out.println("Card displayed is "+cardText);
                explicitWaitHelper.WaitForElementToBeClickable(addToCartButton, 100);
                addToCartButtonList.get(i).click();
                break;
            }
        }
    }

    public String toastMessageValidation(String expectedToastMessage) {

        Map<String, WebElement> locatorMap = new HashMap<>();
        locatorMap.put(" Product Added To Cart ", toastMessage);
        locatorMap.put(" Order Placed Successfully ", orderToastMessage);
        locatorMap.put(" Please Enter Full Shipping Information ", orderToastMessage);
        actualText = (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].textContent;", locatorMap.get(expectedToastMessage));
        return actualText;
    }

    public int cartItemCountValidation() {
        String cartCount = driver.findElement(RelativeLocator.with(By.tagName("label")).near(cartTabLocator)).getText();
        return util.convertStringToInt(cartCount);
    }

}
