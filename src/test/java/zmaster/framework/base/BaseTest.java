package zmaster.framework.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import zmaster.framework.listeners.ExtentListener;
import zmaster.framework.utilities.DriverFactory;
import zmaster.framework.utilities.DriverManager;

public class BaseTest {

	private WebDriver driver;


	@BeforeSuite
	private void setUpFramework() {
		DriverFactory.setGridPath("C:\\Users\\himun\\eclipse-workspace\\zmaster.framework\\src\\test\\resources\\grid\\selenium-server-4.0.0-alpha-1.jar");

		if(System.getProperty("os.name").contains("mac")) {
			DriverFactory.setChromeDriverPath("C:\\Users\\himun\\eclipse-workspace\\zmaster.framework\\src\\test\\resources\\grid\\chromedriver");
			DriverFactory.setFirefoxDriverPath("C:\\Users\\himun\\eclipse-workspace\\zmaster.framework\\src\\test\\resources\\grid\\geckodriver");
		} else {
			DriverFactory.setChromeDriverPath("C:\\Users\\himun\\eclipse-workspace\\zmaster.framework\\src\\test\\resources\\grid\\chromedriver.exe");
			DriverFactory.setFirefoxDriverPath("C:\\Users\\himun\\eclipse-workspace\\zmaster.framework\\src\\test\\resources\\grid\\geckodriver.exe");
		}
	}

	protected void openBrowser(String browser) {
		if(System.getenv("isRemote").equalsIgnoreCase("Grid"))
			DriverFactory.setIsRemote(true);
		else
			DriverFactory.setIsRemote(false);

		      System.out.println(DriverFactory.getRemote());

		if(!DriverFactory.getRemote()) {
			if(browser.equals(Constants.CHROME)) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equals(Constants.FIREFOX)) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		
		DriverManager.setDriver(driver);

		DriverManager.getDriver().manage().window().maximize();
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void softAssert(String actual, String expected) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected);
		softAssert.assertAll();

	}

	protected void hardAssert(Object actual, Object expected) {
		Assert.assertEquals(actual, expected);

	}

	protected void logInfo(String message) {
		ExtentListener.testReport.get().info(message);
	}

	@AfterMethod
	protected void quit() {
		if(driver != null) 
			DriverManager.getDriver().quit();

	}

}
