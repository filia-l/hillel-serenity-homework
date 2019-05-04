package serenity.steps.sportmaster;

import frontend.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportMasterSearchResultsPageSteps extends ScenarioSteps {

    private SearchResultsPage searchResultsPage;

    public SportMasterSearchResultsPageSteps(final Pages pages) {
        searchResultsPage = pages.getPage(SearchResultsPage.class);
    }

    @Step
    public String getDisplayedSearchMessage() {
        return searchResultsPage.getSearchMessage();
    }
}
