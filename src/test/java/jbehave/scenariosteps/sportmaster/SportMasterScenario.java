package jbehave.scenariosteps.sportmaster;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import serenity.steps.sportmaster.SportMasterMainPageSteps;
import serenity.steps.sportmaster.SportMasterSearchResultsPageSteps;

public class SportMasterScenario {

    @Steps
    private SportMasterMainPageSteps sportMasterMainPageSteps;

    @Steps
    private SportMasterSearchResultsPageSteps sportMasterSearchResultsPageSteps;

    @Given("user opens page, by using following link: '$link'")
    public void openMainPage(final String link) {
        sportMasterMainPageSteps.openPage(link);
    }

    @When("search for next item: '$item'")
    public void searchFor(final String item) {

        Serenity.setSessionVariable("some_key").to(item); // положить айтем в сессию по ключу some_key

        sportMasterMainPageSteps.searchFor(item);
    }

    @Then("following message is displayed: '$message'")
    public void isMessageDisplayed(final String expectedSearchMessage) {
        final String actualSearchMessage = sportMasterSearchResultsPageSteps.getDisplayedSearchMessage();

        String s = Serenity.sessionVariableCalled("some_key"); // достать айтем из сессии по ключу some_key

        Assert.assertEquals("There is incorrect search message displayed!",
                actualSearchMessage, expectedSearchMessage);
    }
}
