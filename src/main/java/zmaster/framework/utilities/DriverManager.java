package zmaster.framework.utilities;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	public static ThreadLocal<WebDriver> drive = new ThreadLocal<WebDriver>();
	
	
	public static void setDriver(WebDriver driver) {
		
		drive.set(driver);
		
	}
	
	public static WebDriver getDriver() {
		
		return drive.get();
	}


}
