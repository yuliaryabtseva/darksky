package framework;

import org.openqa.selenium.By;
import stepdefinition.SharedSD;

public class GmailSignInPage extends BasePage {

    private String urlGmail = "http://gmail.com";
    private By emailOrPhoneTextField = By.id("identifierId");
    private String email = "ryabtsevayuv@gmail.com";
    private By nextButton = By.id("identifierNext");
    private By passwordTextField = By.xpath("//input[@name='password']");
    private String password = "Gmail911033";
    private By passwordNextButton = By.id("passwordNext");

    public void enterEmail() {
        setValue(emailOrPhoneTextField, email);
    }

    public void clickOnNextButton() {
        clickOn(nextButton);
    }

    public void enterPassword() {
        setValue(passwordTextField, password);
    }

    public void clickOnPasswordNextButton() {
        clickOn(passwordNextButton);
    }

    public void openGmailUrl() {
        SharedSD.getDriver().get(urlGmail);
    }





}
