package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelsComSearchPage extends BasePage {

    private String starsXpathBeginning = "star";
    private By hotelStarRating = By.xpath("//li[starts-with(@class, 'starRating')]");
    private By hotelsDistance = By.xpath("//li[starts-with(@class, 'distance')]");
    private By hotelsNames = By.xpath("//h3[@class='visuallyhidden']");
    private int radius;

    public void selectStars(String stars) {
        waitUntilElementIsPresent(By.id(starsXpathBeginning+stars));
        clickOn(By.id(starsXpathBeginning+stars));
    }

    public List<WebElement> getHotelsRatings() {
        return getWebElements(hotelStarRating);
    }

    public boolean verifyHotelsRating(String stars) {
        boolean isVerified = true;
        List<WebElement> list = getHotelsRatings();
        for (WebElement element : list){
            if (!element.getText().equals(stars + ".0 out of 5.0")) {
                isVerified = false;
                break;
            }
        }
        return isVerified;
    }

    //get list of all distances
    public List<WebElement> getHotelsRadius() {
        waitUntilAllElementsAppear(hotelsDistance);
        return getWebElements(hotelsDistance);
    }

    //convert WebElement array into String array
    public List<String> getHotelsRadiusString() {
        List<String> list = new ArrayList<>();
        for (WebElement element : getHotelsRadius()) {
            String[] newElement = element.getText().split(" km");
            list.add(newElement[0]);
        }
        return list;
    }

    //convert String Array into Double Array
    public List<Double> getHotelsRadiusDouble() {
        List<Double> list = new ArrayList<>();
        for (String element : getHotelsRadiusString()) {
            list.add(Double.valueOf(element));
        }
        return list;
    }

    //get list of all hotels names
    public List<WebElement> getHotelsNames() {
        waitUntilAllElementsAppear(hotelsNames);
        return getWebElements(hotelsNames);
    }

    //convert list of hotels names into String Array list
    public List<String> getHotelsNamesString() {
        List<String> list = new ArrayList<>();
        for (WebElement element : getHotelsNames()) {
            list.add(element.getText());
        }
        return list;
    }

    //check if list of hotels contain requested hotel
    public boolean isHotelExists(String hotel) {
        boolean isExist = false;
        for (String element : getHotelsNamesString()) {
            if (element.contains(hotel)) {
                isExist = true;
                break;
            }
        } return isExist;
    }

    //create HashMap from two arrays (HotelsNames, HotelsRadius)
    public HashMap<String, Double> hotelsNamesAndRadius(int radius) {
        this.radius = radius;
        HashMap<String, Double> hashMap = new HashMap<>();
        for (int i = 0; i < getHotelsNamesString().size(); i++) {
            if (getHotelsRadiusDouble().get(i) <= radius) {
                hashMap.put(getHotelsNamesString().get(i), getHotelsRadiusDouble().get(i));
            }
        }
        return hashMap;
    }

    //check if hashmap contains Hotel Name
    public boolean isHotelNamePresented(String hotel) {
        boolean isPresented = false;
        for (Map.Entry<String, Double> e : hotelsNamesAndRadius(radius).entrySet()) {
            if (e.getKey().startsWith(hotel)) {
                isPresented = true;
            }
        }return isPresented;
    }
}

