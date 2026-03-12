package dataprovider;

import org.testng.annotations.DataProvider;

import utils.JsonDataReader;

public class LoginDataProvider {
	
	 @DataProvider(name = "loginData")
	    public Object[][] getData() {

	        String path = "src\\test\\java\\resources\\loginData.json";

	        return JsonDataReader.getLoginData(path, "loginData");
	    }

}
