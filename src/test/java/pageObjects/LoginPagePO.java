package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ExplicitWaitHelper;
import utilities.Util;

public class LoginPagePO {
	public WebDriver driver;
	Util util;
	ExplicitWaitHelper explicitWaitHelper;
	String actualText;
	
	
	By usernameField = By.xpath("//input[@id='userEmail']");
	By passwordField = By.xpath("//input[@id='userPassword']");
	By loginButton = By.xpath("//input[@id='login']");
	
	public LoginPagePO(WebDriver driver) {
		this.driver=driver;
		this.util = new Util(driver);
		this.explicitWaitHelper = new ExplicitWaitHelper(driver);
	}

	public void enterLoginCredentials(String userName, String password) {
		driver.findElement(usernameField).sendKeys(userName);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

}
