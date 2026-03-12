package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataprovider.LoginDataProvider;
import pages.LoginPage;
import utils.ConfigReader;

public class Guru99LoginTest extends BaseTest {

//	 @Test
//	 public void VerifyLogin() {
//	ConfigReader config = new ConfigReader();
//
//    LoginPage loginPage = new LoginPage(driver);
//
//    loginPage.login(
//            config.getUsername(),
//            config.getPassword());
//
//    String title = driver.getTitle();
//
//    Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
//}

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
    public void VerifyLogin(
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

            // Switch to alert popup
            String alertText =
                    driver.switchTo().alert().getText();

            // Verify alert message
            Assert.assertEquals(
                    alertText,
                    "User or Password is not valid",
                    "Alert message mismatch"
            );

            // Accept alert popup
            driver.switchTo().alert().accept();
        }
	}

}