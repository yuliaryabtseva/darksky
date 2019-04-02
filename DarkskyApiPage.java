package framework;

import org.openqa.selenium.By;

public class DarkskyApiPage extends BasePage {

    private By signUpButton = By.xpath("//a[@class='button filled']");

    public void clickOnSignUpButton() {
        clickOn(signUpButton);
    }


}
