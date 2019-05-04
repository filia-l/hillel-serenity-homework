package frontend.pages;

import frontend.panels.ChooseCityPanel;
import frontend.panels.SearchPanel;
import org.openqa.selenium.WebDriver;

public class SportMasterMainPage extends AbstractPage {

    private static final String CHOOSE_CITY_PANEL_LOCATOR = ".basketgeo";
    private static final String SEARCH_PANEL_LOCATOR = "//div[@class='new-nav-header']";

    public SportMasterMainPage(final WebDriver driver) {
        super(driver);
    }

    public ChooseCityPanel getChooseCityPanel() {
        return new ChooseCityPanel(findBy(CHOOSE_CITY_PANEL_LOCATOR), this);
    }

    public SearchPanel getSearchPanel() {
        return new SearchPanel(findBy(SEARCH_PANEL_LOCATOR), this);
    }

    public void waitUntilCityPanelInvisible() {
        waitForAbsenceOf(SEARCH_PANEL_LOCATOR);
    }
}
