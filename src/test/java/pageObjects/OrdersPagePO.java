package pageObjects;

import java.util.HashMap;
import java.util.List;
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

public class OrdersPagePO {
	public WebDriver driver;
	Util util;
	ExplicitWaitHelper explicitWaitHelper;
	public String actualText;
	public boolean flag;
	
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover ng-star-inserted']/tbody/tr/th")
    private List<WebElement> ordersOrderID;

    public OrdersPagePO(WebDriver driver) {
        this.driver=driver;
        this.util = new Util(driver);
        this.explicitWaitHelper = new ExplicitWaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public Util getUtil() {
        return this.util;
    }

    public String getOrdersOrderId(String expectedOrderID) throws InterruptedException {
        return util.dataValidationText(ordersOrderID, expectedOrderID);
    }


}
