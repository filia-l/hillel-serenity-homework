package frontend.pages.google_pages;

import frontend.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage extends AbstractPage {

    private static final String GOOGLE_LOGO_LOCATOR = "//img[@id='hplogo']";

    public GoogleMainPage(final WebDriver driver) {
        super(driver);
    }

    public Boolean getLogoVisibility() {
        return findBy(GOOGLE_LOGO_LOCATOR).isDisplayed();
    }

    public String getCurrentTitle() {
        return getTitle();
    }
}
