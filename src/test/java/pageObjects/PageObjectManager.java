package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public LoginPagePO loginPagePO;
	public HomePagePO homePagePO;
	public CartPagePO cartPagePO;
	public OrdersPagePO ordersPagePO;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPagePO getLoginPagePO() {
		loginPagePO = new LoginPagePO(driver);
		return loginPagePO;
	}
	
	public HomePagePO getHomePagePO() {
		homePagePO = new HomePagePO(driver);
		return homePagePO;
	}
	
	public CartPagePO getCartPagePO() {
		cartPagePO = new CartPagePO(driver);
		return cartPagePO;
	}
	
	public OrdersPagePO getOrdersPagePO() {
		ordersPagePO = new OrdersPagePO(driver);
		return ordersPagePO;
	}

}
