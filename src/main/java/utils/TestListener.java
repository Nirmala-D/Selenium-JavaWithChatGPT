package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener implements ITestListener {
	
	 @Override
	    public void onTestFailure(ITestResult result) {

	        WebDriver driver =
	                (WebDriver) result.getTestContext()
	                        .getAttribute("driver");

	        ScreenshotUtil.captureScreenshot(
	                driver,
	                result.getName());

	        System.out.println("Screenshot captured");
	    }

}
