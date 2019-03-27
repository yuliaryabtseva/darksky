package framework;

import org.openqa.selenium.By;

public class AppleIphonePage extends BasePage{

    private By lastIphone = By.xpath("//li[@class='chapternav-item chapternav-item-iphone-xs']");

    public void clickOnLastIphone() {
        clickOn(lastIphone);
    }


}
