package frontend.pages.sport_master_pages;

import frontend.pages.AbstractPage;
import frontend.panels.sport_master_panels.ProductPanel;
import frontend.panels.sport_master_panels.SelectedProductPreviewPanel;
import org.openqa.selenium.WebDriver;

public class ProductPage extends AbstractPage {

    private static final String PRODUCT_PANEL_LOCATOR = ".cb-item.fl";
    private static final String PRODUCT_ADDED_TO_CART_PANEL_LOCATOR = ".cb-item-popup";

    public ProductPage(final WebDriver driver) {
        super(driver);
    }

    public ProductPanel getProductPanel() {
        return new ProductPanel(findBy(PRODUCT_PANEL_LOCATOR), this);
    }

    public SelectedProductPreviewPanel getProductPreviewPanel() {
        return new SelectedProductPreviewPanel(findBy(PRODUCT_ADDED_TO_CART_PANEL_LOCATOR), this);
    }
}
