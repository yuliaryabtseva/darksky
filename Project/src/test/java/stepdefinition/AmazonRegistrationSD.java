package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.AmazonHomepage;
import framework.AmazonRegisterPage;
import org.testng.Assert;

public class AmazonRegistrationSD {

    AmazonHomepage amazonHomepage = new AmazonHomepage();
    AmazonRegisterPage amazonRegisterPage = new AmazonRegisterPage();

    @Given("^I am on Amazon home page$")
    public void iAmOnAmazonHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.amazon.com/", "Wrong Home page");
    }

    @Given("^I am on Create Account page$")
    public void iAmOnCreateAccountPage() {
        amazonHomepage.hoverOverAccountAndListsButton();
        amazonHomepage.clickOnStartHereButton();
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Amazon Registration", "Wrong Registration Page");
    }

    @When("^I enter (.*) into (name|email|password|re-enter password) field on amazon register page$")
    public void enterDataIntoTextFields(String anyText, String textField) {

        switch (textField) {
            case "name":
                amazonRegisterPage.enterName(anyText);
                break;

            case "email":
                amazonRegisterPage.enterEmail(anyText);
                break;

            case "password":
                amazonRegisterPage.enterPassword(anyText);
                break;

            case "re-enter password":
                amazonRegisterPage.reEnterPassword(anyText);
                break;
        }
    }

    @When("^I click on Create your Amazon account button on amazon register page$")
    public void clickOnCreateAccountButton() {
        amazonRegisterPage.clickOnCreateYourAmazonAccountButton();
    }

    @Then("^I verify \"Enter your name\" error on amazon register page$")
    public void verifyEnterNameError() {
        Assert.assertEquals(amazonRegisterPage.getMissingNameErrorText(), "Enter your name", "Wrong Name Error Text");
    }

    @Then("^I verify \"Enter your email\" error on amazon register page$")
    public void verifyEnterEmailError() {
        Assert.assertEquals(amazonRegisterPage.getMissingEmailErrorText(), "Enter your email", "Wrong Email Error Text");
    }

    @Then("^I verify \"Enter a valid email address\" error on amazon register page$")
    public void verifyInvalidEmailError() {
        Assert.assertEquals(amazonRegisterPage.getInvalidEmailErrorText(), "Enter a valid email address", "Wrong Invalid Email Error Text");
    }

    @Then("^I verify \"Passwords must match\" error on amazon register page$")
    public void verifyPasswordsMismatchError() {
        Assert.assertEquals(amazonRegisterPage.getPasswordsMismatchErrorText(), "Passwords must match", "Wrong Password Mismatch Error Text");
    }

    @Then("^I verify \"Passwords must be at least 6 characters.\" error on amazon register page$")
    public void verifyPasswordLengthError() {
        Assert.assertEquals(amazonRegisterPage.getPasswordLengthErrorText(), "Passwords must be at least 6 characters.", "Wrong Password Length Error Text");
    }


}







