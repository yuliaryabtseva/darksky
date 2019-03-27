package framework;

import org.openqa.selenium.By;

public class MessengerLoginPage extends BasePage {

    private By errorTextLineOne = By.xpath("//*[@id=\"login_form\"]/div[1]/div[1]");
    private By errorTextLineTwo = By.xpath("//*[@id=\"login_form\"]/div[1]/div[2]");

    public String getErrorTextLineOne() {
        return getTextFromElement(errorTextLineOne);
    }

    public String getErrorTextLineTwo() {
        return getTextFromElement(errorTextLineTwo);
    }
}

