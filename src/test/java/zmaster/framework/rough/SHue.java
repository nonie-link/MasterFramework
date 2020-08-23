package zmaster.framework.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SHue {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		WebElement ele = driver.findElement(By.name("btnK"));
		Actions actions = new Actions(driver);
		actions.click(ele);
		actions.clickAndHold(ele);
		actions.contextClick(ele);
		Thread.sleep(3000);
		
	}

}


//NoSuchElementException
//ElementNotVisibleException
//NoSuchWindowException
//NoSuchAlertPresentException
//NoSuchFrameException
//invalidSelectorException
//illegalStateException
//TimeoutException
//Invalidargumentexception
//ElementNotselectableexception