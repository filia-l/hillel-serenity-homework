package frontend.panels.sport_master_panels;

import dto.sport_master_dto.Product;
import frontend.pages.AbstractPage;
import frontend.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPanel extends AbstractPanel {

    private static final String PRODUCT_TITLE_LOCATOR = ".//div[@class='cb-item-actions fl withPreview']/h1";
    private static final String PRODUCT_PRICE_LOCATOR = ".//div[@class='kartochka-price cb-item-actions-price relative']/div[@class='cb-item-price-new']";
    private static final String PRODUCT_SELECTED_COLOR_LOCATOR = ".//a[@class='card-colors__item active']";
    private static final String PRODUCT_SELECTED_SIZE_LOCATOR = ".//input[@name='item-sizes' and @class='checked']/following::label[1]";
    private static final String PRODUCT_SIZE_LOCATOR = ".//input[@data-size='%s']/following::label[1] ";
    private static final String ADD_TO_CART_BUTTON_LOCATOR = ".//a[@class='button button-red buybutton tt-u']";

    public ProductPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        super(panelBaseLocation, rootPage);
    }

    public String getProductTitle() {
        return getRootPage().findBy(PRODUCT_TITLE_LOCATOR).getText();
    }

    public void selectProductSize(String size) {
        getRootPage().findBy(String.format(PRODUCT_SIZE_LOCATOR, size)).click();
    }

    public Product getProductDTO() {
        Product product = new Product();
        product.setTitle(getRootPage().findBy(PRODUCT_TITLE_LOCATOR).getText());
        product.setPrice(getRootPage().findBy(PRODUCT_PRICE_LOCATOR).getText().replace(".", ""));
        product.setColor(getRootPage().findBy(PRODUCT_SELECTED_COLOR_LOCATOR).getAttribute("title"));
        product.setSize(getRootPage().findBy(PRODUCT_SELECTED_SIZE_LOCATOR).getText());
        return product;
    }

    public void addToCart() {
        getRootPage().findBy(ADD_TO_CART_BUTTON_LOCATOR).click();
    }
}
