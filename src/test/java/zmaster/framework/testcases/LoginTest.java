package zmaster.framework.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import zmaster.framework.base.BaseTest;
import zmaster.framework.base.Constants;
import zmaster.framework.pageobjects.HomePageActions;
import zmaster.framework.utilities.DataClass;

public class LoginTest extends BaseTest{
	
	
	@Test(dataProviderClass = DataClass.class, dataProvider = "CommonDataProvider")
	public void loginTest(Hashtable<String, String> ht) {
		
		 openBrowser(Constants.FIREFOX);
		 
		 HomePageActions homePageActions = new HomePageActions();
		 homePageActions = homePageActions.navigateToUrl(Constants.SITE_URL);
		 logInfo("Navigated to website");
		 softAssert(getTitle(), ht.get("ExpectedTitle"));
		 logInfo("Title is correct");
		 homePageActions.doLogin(ht.get("EmailID"), ht.get("Password"));
		 logInfo("login successful");
		
	}

}
