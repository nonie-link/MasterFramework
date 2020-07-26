package zmaster.framework.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import zmaster.framework.pageobjects.CartPageActions;
import zmaster.framework.pageobjects.HomePageActions;
import zmaster.framework.pageobjects.InventoryPageActions;

public class TopMenu {
	
	
	
	
	@FindBy(how = How.CSS, using = "div.bm-burger-button")
	public WebElement menu;
	
	@FindBy(how = How.ID , using = "inventory_sidebar_link")
    public WebElement allItems;
	
	@FindBy(how = How.ID, using = "about_sidebar_link")
	public WebElement about;
	
	@FindBy(how = How.ID, using = "logout_sidebar_link")
	public WebElement logout;
	
	@FindBy(how = How.ID, using = "reset_sidebar_link")
	public WebElement resetAppState;
	
	@FindBy(how = How.CSS, using = "svg[data-icon = 'shopping-cart']")
	public WebElement cart;
	
	@FindBy(how = How.CSS, using = "span.fa-layers-counter.shopping_cart_badge")
	public WebElement numberOfCartItems;
	
	
	private void clickOnMenu() {
		menu.click();
	}
	
	public InventoryPageActions goToAllItems() {
		clickOnMenu();
		allItems.click();
		return (InventoryPageActions) new InventoryPageActions().openPage(InventoryPageActions.class);
	}
	
	public void goToAbout() {
		clickOnMenu();
		about.click();
	}
	
	public HomePageActions logOut() {
		clickOnMenu();
		logout.click();
		return (HomePageActions) new HomePageActions().openPage(HomePageActions.class);
	}
	
	public void resetAppState() {
		clickOnMenu();
		resetAppState.click();
		
	}
	
	public String getNumberOfProductsInCart() {
		return numberOfCartItems.getAttribute("textContent");
	}
	
	public CartPageActions goToCart() {
		cart.click();
		return (CartPageActions) new CartPageActions().openPage(CartPageActions.class);
	}
}
