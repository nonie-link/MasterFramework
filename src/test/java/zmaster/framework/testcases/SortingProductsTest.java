package zmaster.framework.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import zmaster.framework.base.BaseTest;
import zmaster.framework.base.Constants;
import zmaster.framework.pageobjects.HomePageActions;
import zmaster.framework.pageobjects.InventoryPageActions;
import zmaster.framework.utilities.DataClass;

public class SortingProductsTest extends BaseTest{
	
	@Test()
	public void sortingProductsTest() {
		
		openBrowser(Constants.CHROME);
		
		HomePageActions homePage = new HomePageActions();
		InventoryPageActions inventoryPage = homePage.navigateToUrl(Constants.SITE_URL).doLogin(Constants.DEFAULT_USER, Constants.DEFAULT_PASS);
		logInfo("Logged In Successfully!!!");
		inventoryPage.sortProducts("Price (low to high)");
		logInfo("Products Sorted");
	}


}
