package framework;

import org.openqa.selenium.By;

public class DarkskyApiLoginPage extends BasePage {

    private By emailAddressTextField = By.id("email");
    private String email = "email@email.com";
    private By passwordTextField = By.id("password");
    private String password = "password";
    private By loginButton = By.xpath("//button[@type='submit']");

    public void enterEmail() {
        setValue(emailAddressTextField, email);
    }

    public void enterPassword() {
        setValue(passwordTextField, password);
    }

    public void clickOnLoginButton() {
        clickOn(loginButton);
    }
}
