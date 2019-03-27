package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import framework.MessengerLoginPage;
import framework.MessengerPage;
import org.testng.Assert;

public class MessengerSignUpSD {

    HomePage homePage = new HomePage();
    MessengerPage messengerPage = new MessengerPage();
    MessengerLoginPage messengerLoginPage = new MessengerLoginPage();

    @Given("^I am on messenger facebook$")
    public void iAmOnMessengerPage() {
        homePage.clickOnMessengerButton();
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Messenger", "Invalid Messenger Page");
    }

    @When("^I enter (.+) into (username|password) field on messenger page$")
    public void enterDataIntoTextFields(String anyText, String textFields) {

        switch (textFields) {
            case "username":
                messengerPage.enterEmail(anyText);
                break;
            case "password":
                messengerPage.enterPassword(anyText);
        }
    }

    @When("^I click on sign in button on messenger page$")
    public void clickOnSignInButton() {
        messengerPage.clickOnSignInButton();
    }

    @Then("^I verify invalid login message on signup page$")
    public void verifyInvalidLoginMessage() {
        try {
            Assert.assertEquals("Incorrect Email", messengerLoginPage.getErrorTextLineOne());
        } catch (AssertionError e) {
            System.out.println("In catch block");
            Assert.assertEquals("Incorrect email or phone number", messengerLoginPage.getErrorTextLineOne());
        }

        Assert.assertEquals("The email you’ve entered doesn’t match any account. Sign up for an account.", messengerLoginPage.getErrorTextLineTwo());
    }
}






