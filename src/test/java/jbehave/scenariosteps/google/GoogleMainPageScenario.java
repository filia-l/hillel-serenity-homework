package jbehave.scenariosteps.google;

import dto.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import serenity.steps.google.GoogleMainPageTestSteps;

public class GoogleMainPageScenario {

    @Steps
    private GoogleMainPageTestSteps googleMainPageTestSteps;

    @Given("user opens Google site, using following link $pageUrl")
    @When("user opens Google site, using following link $pageUrl")
    @Aliases(values = {
            "user opens Hotline site, using following link $pageUrl",
            "user opens Sportchek site, using following link $pageUrl"
    })
    public void openGooglePage(final String pageUrl) {
        googleMainPageTestSteps.openGooglePage(pageUrl);
    }

    @When("register new user with next data: $userData")
    public void registerUser(final ExamplesTable userData) {
        final User user = userData.getRowsAs(User.class).get(0);
    }

    @Then("the site opened with next title $expectedTitle")
    public void isGoogleTitleDisplayedCorrectly(final String expectedTitle) {
        final String actualTitle = googleMainPageTestSteps.getDisplayedTitle();
        Assert.assertEquals("There is incorrect title displayed!",
                expectedTitle, actualTitle);
    }

    @Then("'Google' label should be available to display")
    public void isGoogleLabelDisplayed() {
        final Boolean isLogoDisplayed = googleMainPageTestSteps.isLogoDisplayed();
        Assert.assertTrue("There is no 'Google' label displayed!", isLogoDisplayed);
    }
}
