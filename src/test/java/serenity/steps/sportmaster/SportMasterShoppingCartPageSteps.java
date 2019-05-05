package serenity.steps.sportmaster;

import dto.sport_master_dto.Product;
import frontend.pages.sport_master_pages.ShoppingCartPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.pages.Pages;

public class SportMasterShoppingCartPageSteps extends PageObject {

    private ShoppingCartPage shoppingCartPage;

    public SportMasterShoppingCartPageSteps(Pages pages) {
        pages.getPage(ShoppingCartPage.class);
    }

    public String getShoppingCartTitle() {
        return shoppingCartPage.getShoppingCartPageTitle();
    }

    public Product getProductDTO() {
        return shoppingCartPage.getCartProductPanel().getAddedProductDTO();
    }

    public String[] colorSize() {
        return shoppingCartPage.getCartProductPanel().getProductColorAndSize();
    }
}
