package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class GmailMainPage extends BasePage {

    private By listOfEmails = By.xpath("//tr[starts-with(@class, 'zA')]");
    private By confirmationLink = By.xpath("//a[starts-with(@href, 'https://darksky.net/dev/register')]");


    public List<WebElement> getListOfEmails() {
        return getWebElements(listOfEmails);
    }

    public void clickOnDarkskyEmail() {
        for (WebElement email : getListOfEmails()) {
            if (email.getText().contains("Welcome! And confirm your email")) {
                email.click();
            }
        }
    }

    public void clickOnConfirmationLink() {
        clickOn(confirmationLink);
    }




}
