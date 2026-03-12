package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	static Properties prop;

	public ConfigReader() {

		try {

			prop = new Properties();

			FileInputStream fis = new FileInputStream("src\\test\\java\\resources\\config.properties");

			prop.load(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getURL() {
		return prop.getProperty("url");
	}

	public String getUsername() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

}
