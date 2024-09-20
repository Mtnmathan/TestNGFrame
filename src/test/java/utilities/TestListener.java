package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.BaseTest;

public class TestListener implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Started");
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        String testName = result.getName();
        
        ScreenshotPage.getScreenShot(driver, testName + "_success");
        
        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + testName + "_success.png";
        System.out.println("Screenshot for success saved at: " + screenshotPath);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = ((BaseTest)result.getInstance()).getDriver();
		String testName = result.getName();
		
		ScreenshotPage.getScreenShot(driver, testName +"_failure");
		
		String screenShotPath = System.getProperty("user.dir")+"/Screenshots/"+testName+"_failure.png";
		System.out.println("Screenshot for failed saved at: " + screenShotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	

}
