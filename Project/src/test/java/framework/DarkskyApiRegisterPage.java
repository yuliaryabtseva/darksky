package framework;

import org.openqa.selenium.By;

public class DarkskyApiRegisterPage extends BasePage {

    private By emailTextField = By.xpath("//input[@name='email']");
    private String email = "email@email.com";
    private By passwordTextField = By.xpath("//input[@name='password']");
    private String password = "password";
    private By confirmPasswordTextField = By.xpath("//input[@name='confirmation']");
    private By registerButton = By.xpath("//button[@type='submit']");

    //enter email
    public void enterEmail() {
        setValue(emailTextField, email);
    }

    //enter password
    public void enterPassword() {
        setValue(passwordTextField, password);
    }

    //re-enter password
    public void reEnterPassword() {
        setValue(confirmPasswordTextField, password);
    }

    //click on Register button
    public void clickOnRegisterButton() {
        clickOn(registerButton);
    }



}
