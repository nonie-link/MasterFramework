package zmaster.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import zmaster.framework.base.BasePage;
import zmaster.framework.utilities.DriverManager;

public class ProductDescriptionActions extends BasePage{
	
	@FindBy(how = How.CSS, using = "button.inventory_details_back_button")
    public WebElement backButton;
	
	
	@FindBy(how = How.CSS, using = "button.btn_primary,btn_inventory")
	public WebElement addToCartButton;
	
	@FindBy(how = How.CSS, using = "button.btn_secondary.btn_inventory")
	public WebElement removeItemFromCart;
	
	public ProductDescriptionActions addItemToCart() {
		addToCartButton.click();
		return (ProductDescriptionActions) openPage(ProductDescriptionActions.class);
	}
	
	public ProductDescriptionActions removeItemFromCart() {
		
		if(isElementPresent(removeItemFromCart))
		removeItemFromCart.click();
		return (ProductDescriptionActions) openPage(ProductDescriptionActions.class);
	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(backButton);
				
	}
	
	
	
}
