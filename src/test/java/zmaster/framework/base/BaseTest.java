package zmaster.framework.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	public void setUpFramework() {
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

		DriverFactory.setIsRemote(true);

		if(DriverFactory.getRemote()) {
			DesiredCapabilities dc = new DesiredCapabilities();

			if(browser.equals("firefox")) {
				dc.setPlatform(Platform.ANY);
				dc.setBrowserName("firefox");
				FirefoxOptions fo = new FirefoxOptions();
				fo.merge(dc);
			} else if(browser.equals("chrome")) {
				dc.setPlatform(Platform.ANY);
				dc.setBrowserName("chrome");
				ChromeOptions co = new ChromeOptions();
				co.merge(dc);
			}

			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
			}catch(MalformedURLException mae) {
				mae.printStackTrace();
			}
} else {
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

	protected void hardAssert(String actual, String expected) {
		Assert.assertEquals(actual, expected);

	}

	protected void logInfo(String message) {
		ExtentListener.testReport.get().info(message);
	}

	@AfterMethod
	protected void quit() {
		if(driver != null) {
			driver.quit();
			DriverManager.setDriver(null);
		}

	}

}
