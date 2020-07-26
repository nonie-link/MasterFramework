package zmaster.framework.listeners;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import zmaster.framework.utilities.DriverManager;

public class ExtentManager {
	
	private static ExtentReports eReports;
	private static ExtentSparkReporter htmlReporter;
	public static String screenshotPath = System.getProperty("user.dir") + "\\target\\extentreportsscreenshot\\";
	public static String screenshotName;
	
	public static void takeShot() {
		
		File screenShot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		
		screenshotName = new Date().toString().replace(":", "_").replace(" ", "_") + ".jpg";
		
		try {
			FileUtils.copyFile(screenShot, new File(screenshotPath + screenshotName));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ExtentReports getInstance(String filePath) {
		
		eReports = new ExtentReports();
		htmlReporter = new ExtentSparkReporter(filePath);
		htmlReporter.config().setDocumentTitle("Extent Reports");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		eReports.attachReporter(htmlReporter);
		return eReports;
		
}
	
}
