package jbehave.scenariosteps.sportmaster;

import dto.sport_master_dto.Product;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import serenity.steps.sportmaster.SportMasterMainPageSteps;
import serenity.steps.sportmaster.SportMasterProductPageSteps;
import serenity.steps.sportmaster.SportMasterSearchResultsPageSteps;
import serenity.steps.sportmaster.SportMasterShoppingCartPageSteps;
import org.unitils.reflectionassert.ReflectionAssert;

public class SportMasterScenario {

    @Steps
    private SportMasterMainPageSteps sportMasterMainPageSteps;

    @Steps
    private SportMasterSearchResultsPageSteps sportMasterSearchResultsPageSteps;

    @Steps
    private SportMasterProductPageSteps productPageSteps;

    @Steps
    private SportMasterShoppingCartPageSteps shoppingCartPageSteps;

    @Given("user opens page, by using following link: '$link'")
    public void openMainPage(final String link) {
        sportMasterMainPageSteps.openPage(link);
    }

    @Given("user selects current city: '$cityName'")
    public void selectCurrentCity(String cityName) {
        sportMasterMainPageSteps.selectCityInPanel(cityName);
        final String actualDisplayedCity = sportMasterMainPageSteps.getToolbarCityName();

        Assert.assertEquals("Incorrect city name displayed in toolbar!", cityName, actualDisplayedCity);
    }

    @When("user searches for next item: '$item'")
    public void searchFor(final String item) {
        Serenity.setSessionVariable("input_item_key").to(item); // положить айтем в сессию по ключу some_key

        sportMasterMainPageSteps.searchFor(item);
    }

    @Then("following message is displayed: '$message'")
    @Alias("page title is: '$pageTitle'")
    public void isMessageDisplayed(final String message) {
        String searchItem = Serenity.sessionVariableCalled("input_item_key"); // достать айтем из сессии по ключу some_key

        final String actualSearchMessage = sportMasterSearchResultsPageSteps.getDisplayedSearchMessage();
        final String expectedSearchMessage = String.format(message, searchItem);

        Assert.assertTrue("There is incorrect search message displayed!",
                actualSearchMessage.contains(expectedSearchMessage));
    }

    @When("user selects following product: '$productTitle'")
    public void selectProduct(String productTitle) {
        sportMasterSearchResultsPageSteps.selectProductFromSearchResults(productTitle);

        final String actualProductTitle = productPageSteps.getCurrentProductTitle();
        Assert.assertTrue("Incorrect product title is displayed!", actualProductTitle.contains(productTitle));
    }

    @When("user selects product size: '$size'")
    public void setSizeToProduct(String size) {
        productPageSteps.setProductSize(size);

        final Product expectedProductDTO = productPageSteps.getSelectedProductDTO();
        Serenity.setSessionVariable("expected_product").to(expectedProductDTO);
    }

    @When("user adds product to cart")
    public void addToCart() {
        productPageSteps.addItemToCart();
        String actualTitle = shoppingCartPageSteps.getShoppingCartTitle();

        Assert.assertEquals("Shopping cart page title is incorrect!", actualTitle, "Корзина");
    }

    @Then("user verifies that added item characteristics are correctly displayed in the shopping cart: $shoppingCartData")
    public void verifyProductCharacteristics(final ExamplesTable shoppingCartData) {
        final Product expectedProductDTO = shoppingCartData.getRowsAs(Product.class).get(0);
        final Product expectedSelectedProductDTO = Serenity.sessionVariableCalled("expected_product");
        final Product actualProductDTO = shoppingCartPageSteps.getProductDTO();

        //Compares actual product DTO to information from the table
        ReflectionAssert.assertReflectionEquals("Product characteristics are incorrect", expectedProductDTO, actualProductDTO);
        //Compares actual product DTO to information saved on product page before adding to cart
        ReflectionAssert.assertReflectionEquals("Product characteristics are incorrect", expectedSelectedProductDTO, actualProductDTO);
    }
}
