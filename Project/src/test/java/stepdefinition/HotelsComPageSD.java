package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HotelsComHomePage;
import framework.HotelsComSearchPage;
import framework.HotelsComTravelPage;
import org.testng.Assert;

public class HotelsComPageSD {

    HotelsComHomePage hotelsComHomePage = new HotelsComHomePage();
    HotelsComTravelPage hotelsComTravelPage = new HotelsComTravelPage();
    HotelsComSearchPage hotelsComSearchPage = new HotelsComSearchPage();

    @Given("^I am on default locations search result screen$")
    public void enterSearchParameters() throws InterruptedException {
        hotelsComHomePage.clickOnPackagesAndFlightsButton();
        hotelsComTravelPage.clickOnOriginField();
        hotelsComTravelPage.enterDepartureLocation();
        Thread.sleep(2000);
        hotelsComTravelPage.clickOnDepartureLocationFromSuggestion();
        hotelsComTravelPage.clickOnDestinationField();
        hotelsComTravelPage.enterDestinationLocation();
        hotelsComTravelPage.clickOnDestinationLocationFromSuggestion();
        hotelsComTravelPage.enterDepartingDate();
        hotelsComTravelPage.enterReturningDate();
        hotelsComTravelPage.clickOnSearchButton();
//        Thread.sleep(30000);
    }

    @When("^I select property class (5 stars|4 stars|3 stars)$")
    public void selectPropertyClass(String hotelStars) throws InterruptedException {

        switch (hotelStars.toLowerCase()) {

            case "5 stars":
                hotelsComSearchPage.selectStars("5");
                Thread.sleep(5000);
                break;
            case "4 stars":
                hotelsComSearchPage.selectStars("4");
                Thread.sleep(5000);
                break;
            case "3 stars":
                hotelsComSearchPage.selectStars("3");
                Thread.sleep(5000);
                break;
        }
    }

    @Then("^I verify system displays only (5 stars|4 stars|3 stars) hotels on search result$")
    public void verifyDisplayedHotelsByStars(String hotelStars) {

        switch (hotelStars) {

            case "5 stars":
                Assert.assertTrue(hotelsComSearchPage.verifyHotelsRating("5"), "System displays not only 5 stars hotels");
                break;
            case "4 stars":
                Assert.assertTrue(hotelsComSearchPage.verifyHotelsRating("4"), "System displays not only 4 stars hotels");
                break;
            case "3 stars":
                Assert.assertTrue(hotelsComSearchPage.verifyHotelsRating("3"), "System displays not only 3 stars hotels");
                break;
        }

    }

    @Then("^I verify system displays all hotels within (.+) miles radius of airport$")
    public void verifyDisplayedHotelsByRadius(int radius) {
        hotelsComSearchPage.hotelsNamesAndRadius(radius);
    }

    @Then("^I verify (.+) Hotel is within radius$")
    public void verifyHiltonHotel(String hotelName) {
        if (!hotelsComSearchPage.isHotelExists(hotelName)) {
            Assert.fail(hotelName + " Hotel is not in the list");
        } else {
            Assert.assertTrue(hotelsComSearchPage.isHotelNamePresented(hotelName), hotelName + " Hotel is not within radius");
        }


    }




}
