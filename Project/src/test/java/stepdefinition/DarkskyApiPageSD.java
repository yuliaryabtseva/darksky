package stepdefinition;

import cucumber.api.java.en.Then;
import framework.DarkskyApiAccountPage;
import framework.DarkskyApiAccountSettingsPage;
import framework.DarkskyApiLoginPage;
import framework.DarkskyApiWelcomePage;

public class DarkskyApiPageSD {

    DarkskyApiWelcomePage darkskyApiWelcomePage = new DarkskyApiWelcomePage();
    DarkskyApiLoginPage darkskyApiLoginPage = new DarkskyApiLoginPage();
    DarkskyApiAccountPage darkskyApiAccountPage = new DarkskyApiAccountPage();
    DarkskyApiAccountSettingsPage darkskyApiAccountSettingsPage = new DarkskyApiAccountSettingsPage();

    @Then("^I go to Account Setting in Darksky Account$")
    public void goToAccountSettings() {
        darkskyApiWelcomePage.switchToDarkskyWindow();
        darkskyApiWelcomePage.clickOnLoginButton();
        darkskyApiLoginPage.enterEmail();
        darkskyApiLoginPage.enterPassword();
        darkskyApiLoginPage.clickOnLoginButton();
        darkskyApiAccountPage.clickOnAccountSettingsButton();


    }

}
