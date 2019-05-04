package serenity.steps.sportmaster;

import dto.sport_master_dto.Product;
import frontend.pages.sport_master_pages.ProductPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.pages.Pages;
import org.yecht.Data;

public class SportMasterProductPageSteps extends PageObject {

    private ProductPage productPage;

    public SportMasterProductPageSteps(Pages pages) {
        pages.getPage(ProductPage.class);
    }

    public String getCurrentProductTitle() {
        return productPage.getProductPanel().getProductTitle();
    }

    public void setProductSize(String size) {
        productPage.getProductPanel().selectProductSize(size);
    }

    public Product getSelectedProductDTO() {
        return productPage.getProductPanel().getProductDTO();
    }

    public void addItemToCart() {
        productPage.getProductPanel().addToCart();
        productPage.getProductPreviewPanel().clickProceedToCartBtn();
    }
}
