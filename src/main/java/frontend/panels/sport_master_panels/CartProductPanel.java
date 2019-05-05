package frontend.panels.sport_master_panels;

import dto.sport_master_dto.Product;
import frontend.pages.AbstractPage;
import frontend.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartProductPanel extends AbstractPanel {

    private final static String ADDED_PRODUCT_TITLE_LOCATOR = ".//div[@class='cart-table-name']";
    private final static String ADDED_PRODUCT_COLOR_SIZE_LOCATOR = ".//div[@class='cart-table-desc']";
    private final static String ADDED_PRODUCT_PRICE_LOCATOR = ".//div[@class='cart-table-row']//div[@class='cart-table-cell cart-table-summ']";

    public CartProductPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        super(panelBaseLocation, rootPage);
    }

    private String getAddedProductTitle() {
        return getRootPage().findBy(ADDED_PRODUCT_TITLE_LOCATOR).getText();
    }

    private String[] getProductColorAndSize() {
        return getRootPage().findBy(ADDED_PRODUCT_COLOR_SIZE_LOCATOR).getText().replace(" ", "").split(":");
    }

    private String getAddedProductColor() {
        return getProductColorAndSize()[2];
    }

    private String getAddedProductSize() {
        return getProductColorAndSize()[1].replaceAll("[^-0-9]", "");
    }

    private String getAddedProductPrice() {
        return getRootPage().findBy(ADDED_PRODUCT_PRICE_LOCATOR).getText().replaceAll("[-,]","");
    }

    public Product getAddedProductDTO() {
        Product product = new Product();
        product.setTitle(getAddedProductTitle());
        product.setPrice(getAddedProductPrice());
        product.setColor(getAddedProductColor());
        product.setSize(getAddedProductSize());
        return product;
    }
}
