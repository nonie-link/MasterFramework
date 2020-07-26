package zmaster.framework.base;

import java.time.Duration;

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

	public BasePage() {
		this.driver = DriverManager.getDriver();
	}

	protected T openPage(Class <T> clazz) {

		T page = null;
		this.driver = DriverManager.getDriver();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, 10);
		page = PageFactory.initElements(driver, clazz);
		PageFactory.initElements(factory, page);
		ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
		waitForPageLoadCondition(pageLoadCondition);
		return page;


	}

	public static TopMenu getInstance() {
		menu = PageFactory.initElements(DriverManager.getDriver(), TopMenu.class);
		if(menu.menu.isDisplayed())
		return menu;
		else
			return null;
			
	}


	protected abstract ExpectedCondition getPageLoadCondition();


	private void waitForPageLoadCondition(ExpectedCondition condition) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(condition);
	}

	protected void selectValueFromDropDown(String visibleText, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	protected boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}


}
