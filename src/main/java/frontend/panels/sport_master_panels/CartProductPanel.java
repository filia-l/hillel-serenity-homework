package frontend.panels.sport_master_panels;

import frontend.pages.AbstractPage;
import frontend.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartProductPanel extends AbstractPanel {

    private final static String ADDED_PRODUCT_COLOR_SIZE_LOCATOR = "//div[@class='cart-table-desc']";

    public CartProductPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        super(panelBaseLocation, rootPage);
    }

    public String getProductColorAndSize() {
        return getRootPage().findBy(ADDED_PRODUCT_COLOR_SIZE_LOCATOR).getText();
    }
}
