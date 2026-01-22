package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitHelper {

	public WebDriver driver;
	public WebDriverWait wait;

	public ExplicitWaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void WaitForVisibilityOfElement(By locator, long timeOutInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}
	
	public void WaitForInvisibilityOfElement(By locator, long timeOutInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
	}
	
	public void WaitForElementToBeClickable(By locator, long timeOutInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
	}
	
	public void WaitForURLToBe(String url, long timeOutInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.urlToBe(url));
	}
	
	public void waitForTextToBePresent(By locator, String expectedText, long timeOutInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.textToBe(locator, expectedText));
	}
	
	public void waitForNoOfElementsMoreThan(By locator, int number, long timeOutInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
	}

}
