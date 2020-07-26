package zmaster.framework.pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import zmaster.framework.base.BasePage;
import zmaster.framework.utilities.DriverManager;

public class InventoryPageActions extends BasePage{
	
	@FindBy(how = How.CSS, using = "select.product_sort_container")
	public WebElement sortingDropDown;
	
	@FindBy(how = How.CSS, using = "div.product_label")
	public WebElement pageHeading;
	
	@FindBys({
				@FindBy(how = How.CSS, using = "div.inventory_list"),
				@FindBy(how = How.CSS, using = "div.inventory_item")
				})
	public List<WebElement> inventoryList;
	
	@FindBy(how = How.CSS, using = "a#item_4_title_link")
	public WebElement productLink;
	
	public void sortProducts(String visibleText) {
		
		selectValueFromDropDown(visibleText, sortingDropDown);
	}
	
	public int getProductListing() {
		
		return inventoryList.size();
		
	}
	
	public ProductDescriptionActions goToProductPage(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
		js.executeScript("arguments[0].click();", element);
		return (ProductDescriptionActions) openPage(ProductDescriptionActions.class);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pageHeading);
	}
	
	

}
