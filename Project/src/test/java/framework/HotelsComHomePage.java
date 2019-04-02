package framework;

import org.openqa.selenium.By;

public class HotelsComHomePage extends BasePage {

    private By packagesAndFlightsButton = By.id("hdr-packages");

    public void clickOnPackagesAndFlightsButton() {
        clickOn(packagesAndFlightsButton);
    }
}
