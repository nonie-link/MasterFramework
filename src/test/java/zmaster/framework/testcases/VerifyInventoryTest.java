package zmaster.framework.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import zmaster.framework.base.BaseTest;
import zmaster.framework.base.Constants;
import zmaster.framework.pageobjects.HomePageActions;
import zmaster.framework.pageobjects.InventoryPageActions;
import zmaster.framework.utilities.DataClass;

public class VerifyInventoryTest extends BaseTest {
	
	@Test(dataProviderClass = DataClass.class, dataProvider = "CommonDataProvider")
	public void verifyInventoryTest(Hashtable<String, String> ht) {
		
		
		openBrowser(Constants.FIREFOX);
		HomePageActions homePage = new HomePageActions();
		homePage = homePage.navigateToUrl(Constants.SITE_URL);
		logInfo("Navigated to website");
		InventoryPageActions inventoryPage = homePage.doLogin(ht.get("EmailID"), ht.get("Password"));
		logInfo("Logged In Successfully!!!");
		hardAssert(String.valueOf(inventoryPage.getProductListing()), ht.get("NumberOfListing").replace("6.0", "6"));
		logInfo("Expected product listing matched");
		
	}

}
