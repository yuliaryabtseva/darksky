package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkskyApiPage;
import framework.DarkskyApiRegisterPage;
import framework.DarkskyHomePage;
import org.testng.Assert;


public class DarkskyHomePageSD {

    DarkskyHomePage darkskyHomePage = new DarkskyHomePage();
    DarkskyApiPage darkskyApiPage = new DarkskyApiPage();
    DarkskyApiRegisterPage darkskyApiRegisterPage = new DarkskyApiRegisterPage();

    @Given("^I am on Darksky home page$")
    public void iAmOnDarkskyHomePage() {
//        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.darksky.net/", "Wrong Home page");
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimeline() {
        Assert.assertTrue(darkskyHomePage.compareTwoArrays(), "Time is incorrect");
    }

    @When("^I expand todays timeline$")
    public void expendTodaysTimeline() throws InterruptedException {
        darkskyHomePage.clickOnTodayTimelineToExpand();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyLowestAndHighestTemp() {
        Assert.assertEquals(darkskyHomePage.getMinTempFromRange(), darkskyHomePage.getLowTempFromExpanded(), "Lowest temp are not equal");
        Assert.assertEquals(darkskyHomePage.getMaxTempFromRange(), darkskyHomePage.getHighTempFromExpanded(), "Highest temp are not equal");
    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void verifyCurrentTemp() {
        Assert.assertTrue(darkskyHomePage.compareCurrentTemp(), "Current temp is greater or less then temps from daily timeline");
    }

    @When("^I sign up in Darksky API$")
    public void signUpInDarkskyApi() {
        darkskyHomePage.clickOnDarkskyApiButton();
        darkskyApiPage.clickOnSignUpButton();
        darkskyApiRegisterPage.enterEmail();
        darkskyApiRegisterPage.enterPassword();
        darkskyApiRegisterPage.reEnterPassword();
        darkskyApiRegisterPage.clickOnRegisterButton();
    }
}







