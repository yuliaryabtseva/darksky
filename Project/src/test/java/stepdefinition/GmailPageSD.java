package stepdefinition;

import cucumber.api.java.en.When;
import framework.GmailMainPage;
import framework.GmailSignInPage;

public class GmailPageSD {

    GmailSignInPage gmailSignInPage = new GmailSignInPage();
    GmailMainPage gmailMainPage = new GmailMainPage();

    @When("^I verify my account by clicking on the link in Gmail account$")
    public void verifyDarkskyRegistration() throws InterruptedException {
        gmailSignInPage.openGmailUrl();
        gmailSignInPage.enterEmail();
        gmailSignInPage.clickOnNextButton();
        gmailSignInPage.enterPassword();
        Thread.sleep(1000);
        gmailSignInPage.clickOnPasswordNextButton();
        gmailMainPage.clickOnDarkskyEmail();
        gmailMainPage.clickOnConfirmationLink();
    }
}
