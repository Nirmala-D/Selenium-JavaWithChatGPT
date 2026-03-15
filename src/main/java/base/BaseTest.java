package base;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestContext;

import factory.DriverFactory;
import utils.ConfigReader;

public class BaseTest {

	 protected WebDriver driver;
	    ConfigReader config;

	    @BeforeMethod
	    public void setup(ITestContext context) {

	        config = new ConfigReader();

	        driver = DriverFactory.initDriver(
	                config.getBrowser());

	        // ✅ VERY IMPORTANT (for screenshot listener)
	        context.setAttribute("driver", driver);

	        driver.get(config.getURL());
	    }
	    
	    

	    @AfterMethod
	    public void tearDown() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
