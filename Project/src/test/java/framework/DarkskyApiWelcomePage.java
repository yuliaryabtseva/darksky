package framework;

import org.openqa.selenium.By;

public class DarkskyApiWelcomePage extends BasePage {

    private By logInButton = By.xpath("//a[@class='button']");

    public void clickOnLoginButton() {
        clickOn(logInButton);
    }

    public void switchToDarkskyWindow() {
        switchToWindow(1);
    }

}
