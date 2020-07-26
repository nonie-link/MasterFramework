package zmaster.framework.testcases;

import org.testng.annotations.Test;

import zmaster.framework.base.BaseTest;
import zmaster.framework.base.Constants;
import zmaster.framework.pageobjects.HomePageActions;
import zmaster.framework.pageobjects.InventoryPageActions;

public class AddProductToCart extends BaseTest{
	
	@Test
	public void addProductToCart() {
		
		openBrowser(Constants.CHROME);
		
		HomePageActions pageActions = new HomePageActions();
		InventoryPageActions inventoryActions = pageActions.navigateToUrl(Constants.SITE_URL).doLogin(Constants.DEFAULT_USER, Constants.DEFAULT_PASS);
		logInfo("Navigated to the Website");
		inventoryActions.goToProductPage(inventoryActions.productLink).addItemToCart().removeItemFromCart();
		logInfo("Added and Removed the Item from Cart");
}

}
