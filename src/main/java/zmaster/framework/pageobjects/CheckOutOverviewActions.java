package zmaster.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import zmaster.framework.base.BasePage;

public class CheckOutOverviewActions extends BasePage {
	
	@FindBy(how = How.CSS, using = "a.btn_action.cart_button")
	public WebElement finishButton;
	
	@FindBy(how = How.CSS, using = "h2.complete-header")
	public WebElement message;
	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(finishButton);
	}
	
	public String getOrderMessage() {
       return message.getAttribute("textContent");
	}
	
	public CheckOutOverviewActions clickOnFinish() {
		finishButton.click();
		return this;
	}

}
