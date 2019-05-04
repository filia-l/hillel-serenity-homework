package frontend.panels.sport_master_panels;

import frontend.pages.AbstractPage;
import frontend.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchResultsPanel extends AbstractPanel {

    private static final String PRODUCT_LOCATOR = ".//a[contains(@title, '%s')]";

    public SearchResultsPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        super(panelBaseLocation, rootPage);
    }

    public void selectProductFromResults(String productTitle) {
        getRootPage().findBy(String.format(PRODUCT_LOCATOR, productTitle)).click();
    }
}
