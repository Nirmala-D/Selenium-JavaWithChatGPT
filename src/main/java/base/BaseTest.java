package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utils.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	ConfigReader config;

	@BeforeMethod
	public void setup() {

		config = new ConfigReader();

		driver = DriverFactory.initDriver(config.getBrowser());

		driver.get(config.getURL());
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
