package framework;

import org.openqa.selenium.By;

public class AmazonRegisterPage extends BasePage {

    private By nameTextField = By.id("ap_customer_name");
    private By emailTextField = By.id("ap_email");
    private By passwordTextField = By.id("ap_password");
    private By reEnterPasswordTextField = By.id("ap_password_check");
    private By createYourAmazonAccountButton = By.id("continue");
    private By missingNameError = By.xpath("//div[contains(text(),'Enter your name')]");
    private By missingEmailError = By.xpath("//div[@id='auth-email-missing-alert']//div[@class='a-alert-content'][contains(text(),'Enter your email')]");
    private By invalidEmailError = By.xpath("//div[contains(text(),'Enter a valid email address')]");
    private By passwordMismatchError = By.xpath("//div[contains(text(),'Passwords must match')]");
    private By passwordLengthError = By.xpath("//div[@class='a-alert-content'][contains(text(),'Passwords must be at least 6 characters.')]");

    public void enterName(String name) {
        setValue(nameTextField, name);
    }

    public void enterEmail(String email) {
        setValue(emailTextField, email);
    }

    public void enterPassword(String password) {
        setValue(passwordTextField, password);
    }

    public void reEnterPassword(String reEnterPassword) {
        setValue(reEnterPasswordTextField, reEnterPassword);
    }

    public void clickOnCreateYourAmazonAccountButton() {
        clickOn(createYourAmazonAccountButton);
    }

    public String getMissingNameErrorText() {
        return getTextFromElement(missingNameError);
    }

    public String getMissingEmailErrorText() {
        return getTextFromElement(missingEmailError);
    }

    public String getInvalidEmailErrorText() {
        return getTextFromElement(invalidEmailError);
    }

    public String getPasswordsMismatchErrorText() {
        return getTextFromElement(passwordMismatchError);
    }

    public String getPasswordLengthErrorText() {
        return getTextFromElement(passwordLengthError);
    }

}
