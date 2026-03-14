package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer{


    private int count = 0;
    private int maxRetry = 2;   // number of retries

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetry) {
            count++;
            System.out.println("Retrying test: " + result.getName() + 
                               " again count = " + count);
            return true;   // retry test
        }

        return false;  // stop retrying
    }
}
