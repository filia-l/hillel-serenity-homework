package frontend.panels;

import frontend.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChooseCityPanel extends AbstractPanel {

    private static final String CITY_LOCATOR = ".//ul[@class='basketgeo-citylist']/li/a[contains(text(), '%s')]";

    public ChooseCityPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        super(panelBaseLocation, rootPage);
    }

    public void selectCity(String cityName) {
        getRootPage().findBy(String.format(CITY_LOCATOR, cityName)).click();
    }
}
