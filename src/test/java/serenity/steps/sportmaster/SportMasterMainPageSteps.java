package serenity.steps.sportmaster;

import frontend.pages.sport_master_pages.SportMasterMainPage;
import frontend.panels.sport_master_panels.SearchPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportMasterMainPageSteps extends ScenarioSteps {

    private SportMasterMainPage sportMasterMainPage;

    public SportMasterMainPageSteps(final Pages pages) {
        sportMasterMainPage = pages.getPage(SportMasterMainPage.class);
    }

    @Step
    public void openPage(final String link) {
        sportMasterMainPage.openAt(link);
    }

    @Step
    public void selectCityInPanel(final String cityName) {
        sportMasterMainPage.getChooseCityPanel().selectCity(cityName);
        sportMasterMainPage.waitUntilCityPanelInvisible();
    }

    @Step
    public String getToolbarCityName() {
        return sportMasterMainPage.getToolbarPanel().getCurrentCityName();
    }

    @Step
    public void searchFor(final String item) {
        final SearchPanel searchPanel = sportMasterMainPage.getSearchPanel();
        searchPanel.inputSearchText(item);
    }
}
