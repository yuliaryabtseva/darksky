package framework;

import org.openqa.selenium.By;

public class DarkskyApiAccountPage extends BasePage {

    private By accountSettingsButton = By.xpath("//a[contains(text(),'Account Settings')]");

    public void clickOnAccountSettingsButton() {
        clickOn(accountSettingsButton);
    }
}
