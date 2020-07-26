package zmaster.framework.pageobjects;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import zmaster.framework.base.BasePage;

public class CheckOutPageActions extends BasePage{
	
	@FindBy(how = How.CSS, using = "input[type = 'submit']")
	public WebElement continueButton;
	
	@FindBy(how = How.ID, using = "first-name")
	public WebElement firstName;
	
	@FindBy(how = How.ID, using = "last-name")
	public WebElement lastName;
	
	@FindBy(how = How.ID, using = "postal-code")
	public WebElement zipCode;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(continueButton);
	}
	
	public CheckOutOverviewActions enterDetails(Hashtable<String, String> ht) {
		firstName.sendKeys(ht.get("firstName"));
		lastName.sendKeys(ht.get("lastName"));
		zipCode.sendKeys(ht.get("zipCode"));
		continueButton.click();
		return (CheckOutOverviewActions) openPage(CheckOutOverviewActions.class);
		
	}
	

}
