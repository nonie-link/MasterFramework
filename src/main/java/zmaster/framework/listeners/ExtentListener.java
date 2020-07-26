package zmaster.framework.listeners;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListener implements ITestListener{
	
	static Date d = new Date();
	public static String fileName = System.getProperty("user.dir") + "\\target\\ExtentReports\\";
	
	
	private static ExtentReports extent = ExtentManager.getInstance(fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		ExtentTest test = extent.createTest(result.getTestClass().getName() + " @Test" + result.getMethod().getMethodName());
		testReport.set(test);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		String logText = "<b>The Test" + " " + result.getMethod().getMethodName().toString() + " has passed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		String logText = "The Test case has failed\n" + "<details>" + "<summary>" + "Exception Occured : Click here to see" + "</summary>" +
		                  exceptionMessage.replaceAll(",", "<br />") + "</details>" + "\n";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		testReport.get().fail(m);
		
		try {
			ExtentManager.takeShot();
			testReport.get().addScreenCaptureFromPath(ExtentManager.screenshotPath + ExtentManager.screenshotName);
		}catch(IOException e) {
			
		}
		
	
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
	
		if(extent != null)
			extent.flush();
	}
	
	
	

}
