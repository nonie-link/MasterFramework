package zmaster.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import zmaster.framework.base.BasePage;
import zmaster.framework.utilities.DriverManager;


public class HomePageActions extends BasePage{
	
	
	
	@FindBy(how = How.ID , using = "user-name")
	public WebElement login_email_id;
	
	@FindBy(how = How.ID, using = "password")
	public WebElement login_password;
	
	@FindBy(how = How.ID, using = "login-button")
	public WebElement login_button;
	
	
	
	public HomePageActions navigateToUrl(String url) {
		
	   DriverManager.getDriver().navigate().to(url);
	   return (HomePageActions) openPage(HomePageActions.class);
	}
	
	public InventoryPageActions doLogin(String email, String password) {
		
		login_email_id.sendKeys(email);
		login_password.sendKeys(password);
		login_button.submit();
		return (InventoryPageActions) openPage(InventoryPageActions.class);
	}
	


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
	     
		return ExpectedConditions.visibilityOf(login_email_id);
	}
	
	
	  

}
