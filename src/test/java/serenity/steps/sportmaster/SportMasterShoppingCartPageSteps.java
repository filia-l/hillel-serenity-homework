package serenity.steps.sportmaster;

import frontend.pages.sport_master_pages.ShoppingCartPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.pages.Pages;

public class SportMasterShoppingCartPageSteps extends PageObject {

    private ShoppingCartPage shoppingCartPage;

    public SportMasterShoppingCartPageSteps(Pages pages) {
        pages.getPage(ShoppingCartPage.class);
    }

    public String getItemColorAndSize() {
        return shoppingCartPage.getCartProductPanel().getProductColorAndSize();
    }
}
