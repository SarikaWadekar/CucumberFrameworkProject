package utilities;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.*;

public class Util {
	public WebDriver driver;
	public Boolean flag;
	public String text;
	
	
	public Util(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void clickButton(By locator) {
		driver.findElement(locator).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public Boolean elementSizeValidation(By element) {
		flag = false;
		if(driver.findElements(element).size()!=0) {
			flag = true;
		}
		return flag;
	}
	
	public Boolean dataValidation(By element, String expectedText) {
		reusableDataValidation(element, expectedText);
		return flag;
	}
	
	public String dataValidationText(By element, String expectedText) {
		reusableDataValidation(element, expectedText);
		Assert.assertTrue(flag);
		return text;
	}
	
	public void reusableDataValidation(By element, String expectedText) {
		flag = false;
		int totalElementSize = driver.findElements(element).size();
		for(int i = 0; i < totalElementSize; i++) {
			text = driver.findElements(element).get(i).getText();
			if(text.equals(expectedText)) {
				flag = true;
				break;
			}
		}
	}
	
	public int convertStringToInt(String stringToConvert) {
		return Integer.parseInt(stringToConvert);
	}
	
	public void switchWindowHandleToChild() {
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
	}
	
	public void addScreenshot(Scenario scenario) throws IOException {
		try {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "Soft assertion failure");
		}catch(IOException e) {
			e.printStackTrace();			
		}
	}

}
