package framework;

import org.openqa.selenium.By;

public class AmazonHomepage extends BasePage {

    private By accountAndListsButton = By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]");
    private By startHereButton = By.xpath("//div[@id='nav-flyout-ya-newCust']//a[@class='nav-a'][contains(text(),'Start here.')]");

    public void hoverOverAccountAndListsButton() {
        mouseOver(accountAndListsButton);
    }

    public void clickOnStartHereButton() {
        clickOn(startHereButton);
    }




}
