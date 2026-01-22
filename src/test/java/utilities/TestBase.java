package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public WebDriver driver;
	public FileInputStream fis;
	public Properties prop;

	public WebDriver WebDriverManager() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
		prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("Url");
		if (driver == null) {
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				// firefox code
			}
			driver.manage().window().maximize();
			driver.get(url);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

}
