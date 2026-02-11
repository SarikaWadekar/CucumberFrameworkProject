package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitHelper;
import utilities.Util;

public class LoginPagePO {
	public WebDriver driver;
	Util util;
	ExplicitWaitHelper explicitWaitHelper;
	String actualText;
	
	
	@FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(id = "userPassword")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPagePO(WebDriver driver) {
        this.driver=driver;
        this.util = new Util(driver);
        this.explicitWaitHelper = new ExplicitWaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterLoginCredentials(String userName, String password) {
        emailInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
