package frontend.pages.sport_master_pages;

import frontend.pages.AbstractPage;
import frontend.panels.sport_master_panels.CartProductPanel;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends AbstractPage {

    private static final String ADDED_PRODUCTS_PANEL = ".cart-table";
    private static final String PAGE_TITLE_LOCATOR = "//h1";

    public ShoppingCartPage(final WebDriver driver) {
        super(driver);
    }

    public CartProductPanel getCartProductPanel() {
        return new CartProductPanel(findBy(ADDED_PRODUCTS_PANEL), this);
    }

    public String getShoppingCartPageTitle() {
        return findBy(PAGE_TITLE_LOCATOR).getText();
    }
}
