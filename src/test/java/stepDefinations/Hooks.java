package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.*;
import pageObjects.LoginPagePO;
import utilities.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;;
	LoginPagePO loginPagePO;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Before
	public void login() throws InterruptedException {
		loginPagePO = testContextSetup.pageObjectManager.getLoginPagePO();
		loginPagePO.enterLoginCredentials("wadekarsarika9@gmail.com", "12345678aA");
		System.out.println("Entered the credentials and clicked on login button");
	}
	
	@After
	public void tearDown() throws IOException {
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed()){
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}
	
	@Before
    public void beforeScenario(Scenario scenario) {
        testContextSetup.setScenario(scenario);
    }


}
