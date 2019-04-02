package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HotelsComTravelPage extends BasePage {

    private By originTextField = By.id("package-origin-hp-package");
    private String departureLocation = "JFK-John F. Kennedy Intl.";
    private By originDropdownLocator = By.xpath("//div[@class='autocomplete-dropdown']/ul[1]");
    private By destinationTextField = By.id("package-destination-hp-package");
    private String destinationLocation = "Orlando, FL (MCO-Orlando Intl.)";
    private By destinationDropdownLocator = By.xpath("//div[@class='autocomplete-dropdown']/ul[1]");
    private By departingDateFiled = By.id("package-departing-hp-package");
    private String departingDate = "07/08/2019";
    private By returningDateField = By.id("package-returning-hp-package");
    private String  returningDate = "07/11/2019";
    private By searchButton = By.id("search-button-hp-package");

    public void clickOnOriginField() {
        clickOn(originTextField);
    }

    public void enterDepartureLocation() {
        setValue(originTextField, departureLocation);
    }

    public List<WebElement> originDropdown() {
        return getWebElements(originDropdownLocator);
    }

    public void clickOnDepartureLocationFromSuggestion() {
        List<WebElement> list = originDropdown();
        for (WebElement element : list) {
            if (element.getText().contains(departureLocation)) {
                element.click();
                break;
            }
        }
    }

    public void clickOnDestinationField() {
        clickOn(destinationTextField);
    }

    public void enterDestinationLocation() {
        setValue(destinationTextField, destinationLocation);
    }

    public List<WebElement> destinationDropdown() {
        return getWebElements(destinationDropdownLocator);

    }

    public void clickOnDestinationLocationFromSuggestion() {
        List<WebElement> list = destinationDropdown();
        for (WebElement element : list) {
            if (element.getText().contains(departureLocation)) {
                element.click();
                break;
            }
        }
    }

    public void enterDepartingDate() {
        setValue(departingDateFiled, departingDate);
    }

    public void enterReturningDate() {
        setValue(returningDateField, returningDate);
    }

    public void clickOnSearchButton() {
        clickOn(searchButton);
    }







}

