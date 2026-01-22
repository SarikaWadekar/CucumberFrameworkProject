package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.Scenario;
import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public Util utils;
	public ExplicitWaitHelper explicitWaitHelper;
	public String orderId;
	private Scenario scenario;
	private SoftAssert softAssert = new SoftAssert();
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		utils = new Util(testBase.WebDriverManager());
		explicitWaitHelper = new ExplicitWaitHelper(testBase.WebDriverManager());
	}
	
	public SoftAssert getSoftAssert() {
		return softAssert;
	}
	
	 public String getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(String orderId) {
	        this.orderId = orderId;
	    }
	    
	    public Scenario getScenario() {
	        return scenario;
	    }

	    public void setScenario(Scenario scenario) {
	        this.scenario = scenario;
	    }


	

}
