package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataprovider.LoginDataProvider;
import pages.LoginPage;

public class LoginTestWithDataProvider extends BaseTest {
	

	/*
	 * Test Method : VerifyLogin This test will run multiple times using TestNG
	 * DataProvider Test data is read from JSON file using LoginDataProvider
	 *
	 * Scenarios covered: 
	 * SS1 - valid user & valid password → login success
	 * SS2 -invalid user & valid password → alert 
	 * SS3 - valid user & invalid password → alert
	 * SS4 - invalid user & invalid password → alert
	 */

	@Test(
            dataProvider = "loginData",
            dataProviderClass = LoginDataProvider.class
    )
    public void VerifyLoginWithDataProvider(
            String userId,
            String password,
            String expectedResult) {

        // Create LoginPage object (Page Object Model)
        LoginPage loginPage = new LoginPage(driver);

        // Perform login using data from DataProvider
        loginPage.login(userId, password);


        // ✅ If expected result is valid → verify home page
        if (expectedResult.equals("login success")) {

            // Get page title after login
            String title = driver.getTitle();

            // Verify home page title
            Assert.assertEquals(
                    title,
                    "Guru99 Bank Manager HomePage",
                    "Login failed for valid credentials"
            );
        }

        // ✅ If expected result is invalid → verify alert message
        else {

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(5));

            wait.until(ExpectedConditions.alertIsPresent());

            String alertText =
                    driver.switchTo().alert().getText();

            Assert.assertEquals(
                    alertText,
                    "User or Password is not valid"
            );

            driver.switchTo().alert().accept();
        }

	}


}
