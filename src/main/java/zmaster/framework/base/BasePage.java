package zmaster.framework.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import zmaster.framework.utilities.DriverManager;

public abstract class BasePage <T> {

	private WebDriver driver;
	private static TopMenu menu = null;
	public static Logger logger = LogManager.getLogger("sauce.demo");

	public BasePage() {
		this.driver = DriverManager.getDriver();
	}

	protected T openPage(Class <T> clazz) {

		T page = null;
		this.driver = DriverManager.getDriver();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, 10);
		page = PageFactory.initElements(driver, clazz);
		PageFactory.initElements(factory, page);
		try {
			ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
			waitForPageLoadCondition(pageLoadCondition);
			menu = PageFactory.initElements(this.driver, TopMenu.class);
			return page;
		}catch(TimeoutException exc) {
			logger.fatal("Can't initalize the object as the page load condition got failed" + page.getClass().getName());
		}
		return null;

	}
	


	protected abstract ExpectedCondition getPageLoadCondition();


	private void waitForPageLoadCondition(ExpectedCondition condition) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(condition);
	}
	
	public static TopMenu getMenu() {
		if(menu != null)
			return menu;
		else {
			logger.warn("Top Menu Object is null");
			return null;
	}
			
	}

	protected void selectValueFromDropDown(String visibleText, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);


	}

	protected boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}


}
