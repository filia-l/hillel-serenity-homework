package frontend.panels.sport_master_panels;

import frontend.pages.AbstractPage;
import frontend.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SelectedProductPreviewPanel extends AbstractPanel {

    private static final String PROCEED_TO_CART_BTN_LOCATOR = ".//a[contains(@class, 'go_to_order_basket')]";

    public SelectedProductPreviewPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        super(panelBaseLocation, rootPage);
    }

    public void clickProceedToCartBtn() {
        getRootPage().findBy(PROCEED_TO_CART_BTN_LOCATOR).click();
    }
}
