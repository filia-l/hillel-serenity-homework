package frontend.pages.sport_master_pages;

import frontend.pages.AbstractPage;
import frontend.panels.sport_master_panels.ChooseCityPanel;
import frontend.panels.sport_master_panels.SearchPanel;
import frontend.panels.sport_master_panels.ToolbarPanel;
import org.openqa.selenium.WebDriver;

public class SportMasterMainPage extends AbstractPage {

    private static final String CHOOSE_CITY_PANEL_LOCATOR = ".basketgeo";
    private static final String SEARCH_PANEL_LOCATOR = "//div[@class='new-nav-header']";
    private static final String TOOLBAR_PANEL_LOCATOR = ".toolbar";

    public SportMasterMainPage(final WebDriver driver) {
        super(driver);
    }

    public ChooseCityPanel getChooseCityPanel() {
        return new ChooseCityPanel(findBy(CHOOSE_CITY_PANEL_LOCATOR), this);
    }

    public SearchPanel getSearchPanel() {
        return new SearchPanel(findBy(SEARCH_PANEL_LOCATOR), this);
    }

    public ToolbarPanel getToolbarPanel() { return new ToolbarPanel(findBy(TOOLBAR_PANEL_LOCATOR), this); }

    public void waitUntilCityPanelInvisible() {
        waitForAbsenceOf(SEARCH_PANEL_LOCATOR);
    }
}
