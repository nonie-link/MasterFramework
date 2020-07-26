package zmaster.framework.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import zmaster.framework.base.BasePage;
import zmaster.framework.base.BaseTest;
import zmaster.framework.base.Constants;
import zmaster.framework.base.TopMenu;
import zmaster.framework.pageobjects.CartPageActions;
import zmaster.framework.pageobjects.CheckOutOverviewActions;
import zmaster.framework.pageobjects.HomePageActions;
import zmaster.framework.pageobjects.InventoryPageActions;
import zmaster.framework.utilities.DataClass;

public class PlaceOrder extends BaseTest {
	
	@Test(groups = {"system"}, dataProviderClass = DataClass.class, dataProvider = "CommonDataProvider")
	public void placeOrder(Hashtable<String, String> ht) {
		
		openBrowser(Constants.FIREFOX);
		
		HomePageActions homePage = new HomePageActions();
		InventoryPageActions inventoryPage = homePage.navigateToUrl(Constants.SITE_URL).doLogin(Constants.DEFAULT_USER, Constants.DEFAULT_PASS);
		logInfo("Navigated to Site and logged in!!!");
		inventoryPage.goToProductPage(inventoryPage.productLink).addItemToCart();
		logInfo("Added item to cart");
		TopMenu menu = BasePage.getInstance();
		hardAssert("1", menu.getNumberOfProductsInCart());
		logInfo("Cart Does have the Added Item");
		CartPageActions cartPage = menu.goToCart();
		logInfo("Landed on CartPage");
		CheckOutOverviewActions overview = cartPage.goToNextPage().enterDetails(ht).clickOnFinish();
		logInfo("Entered Details and got to the next page");
		Assert.assertEquals(overview.getOrderMessage(), ht.get("message"));
	    logInfo("Order Placed Successfully");
				
			
		
		
		
		
		
		
	}

}
