package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    public static void setTest(ExtentTest t) {
        test.set(t);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

}
