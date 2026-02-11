package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitHelper {

	public WebDriver driver;
	public WebDriverWait wait;

	public ExplicitWaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void WaitForVisibilityOfElement(WebElement element, long timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void WaitForInvisibilityOfElement(WebElement element, long timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void WaitForElementToBeClickable(WebElement element, long timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void WaitForURLToBe(String url, long timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void waitForTextToBePresent(By locator, String expectedText, long timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.textToBe(locator, expectedText));
    }

    /*public void waitForNoOfElementsMoreThan(WebElement element, int number, long timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(element, number));
    }*/

    public void waitForNoOfElementsMoreThan(List<WebElement> elements, int number, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(driver -> elements.size() > number);
    }

}
