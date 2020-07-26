package zmaster.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import zmaster.framework.base.BasePage;

public class CartPageActions extends BasePage {
	
	@FindBy(how = How.CSS, using = "div.cart_footer > a:last-child")
	public WebElement checkoutButton;
	
	@FindBy(how = How.CSS, using = "div.cart_footer > a:first-child")
	public WebElement continueShopping;
	
	
	public InventoryPageActions goToContinueShopping() {
		continueShopping.click();
		return (InventoryPageActions) openPage(InventoryPageActions.class);
	}
	
	public CheckOutPageActions goToNextPage() {
		checkoutButton.click();
		return (CheckOutPageActions) openPage(CheckOutPageActions.class);
	}
	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(checkoutButton);
	}

}
