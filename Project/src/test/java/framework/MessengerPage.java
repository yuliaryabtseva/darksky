package framework;

import org.openqa.selenium.By;

public class MessengerPage extends BasePage {

    private By emailTextField = By.id("email");
    private By passTextField = By.id("pass");
    private By signInButton = By.id("loginbutton");

    public void enterEmail(String email) {
        setValue(emailTextField, email);
    }

    public void enterPassword(String pass) {
        setValue(passTextField, pass);
    }

    public void clickOnSignInButton() {
        clickOn(signInButton);
    }


}
