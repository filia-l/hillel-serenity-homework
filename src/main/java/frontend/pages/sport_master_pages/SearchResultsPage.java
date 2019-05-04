package frontend.pages.sport_master_pages;

import frontend.pages.AbstractPage;
import frontend.panels.sport_master_panels.SearchResultsPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.stream.Collectors;

public class SearchResultsPage extends AbstractPage {

    private static final String SEARCH_RESULTS_PANEL_LOCATOR = ".products-list.katalog-tovarov";
    private static final String SEARCH_MESSAGE_LOCATOR = "//h1";

    public SearchResultsPage(final WebDriver driver) {
        super(driver);
    }

    public String getSearchMessage() {
        return findAll(SEARCH_MESSAGE_LOCATOR)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.joining(" "));
    }

    public SearchResultsPanel getSearchedProductsPanel() {
        return new SearchResultsPanel(findBy(SEARCH_RESULTS_PANEL_LOCATOR), this);
    }
}
