package frontend.panels.sport_master_panels;

import frontend.pages.AbstractPage;
import frontend.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class ToolbarPanel extends AbstractPanel {

    private static final String CURRENT_CITY_LOCATOR = ".//a[contains(@class, 'citySelect')]/span";

    public ToolbarPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        super(panelBaseLocation, rootPage);
    }

    public String getCurrentCityName() {
        return getRootPage().findBy(CURRENT_CITY_LOCATOR).waitUntilVisible().getText();
    }
}
