package frontend.panels.sport_master_panels;

import frontend.pages.AbstractPage;
import frontend.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPanel extends AbstractPanel {

    private static final String SEARCH_INPUT_LOCATOR = ".//input[@name='search_str']";

    public SearchPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        super(panelBaseLocation, rootPage);
    }

    public void inputSearchText(final String text) {
        getRootPage().findBy(SEARCH_INPUT_LOCATOR).waitUntilVisible().typeAndEnter(text);
    }
}
