package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.*;

public class DarkskyHomePage extends BasePage {

    private By hoursLocator = By.xpath("//span[contains(@class,'hour')]//span");
    private By todayExpandTimelineLocator = By.xpath("//a[@data-day='0']//span[@class='open']");
    private By minTodayTempRangeLocator = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    private By maxTodayTempRangeLocator = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");
    private By lowTodayTempExpandedLocator = By.xpath("//div[contains(@class, 'revealed')]//span[starts-with(@class, 'highTemp')]//span[@class='temp']");
    private By highTodayTempExpandedLocator = By.xpath("//div[contains(@class, 'revealed')]//span[starts-with(@class, 'lowTemp')]//span[@class='temp']");
    private By currentTempLocator = By.xpath("//span[@class='summary swap']");
    private By tempsLocator = By.xpath("//div[@class='temps']//span//span");
    private By darkskyApiButton = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");


    //get all values of today's hours
    public List<WebElement> getHours() {
        return getWebElements(hoursLocator);
    }

    //create a new array starting now, then with two hours incremented
    public List<String> currentTimeArray() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ha");
        int length = getHours().size();
        int increaseByHrs = 2;

        ArrayList<String> list = new ArrayList<String>();
        list.add("Now");
        for (int i = 1; i < length; i++) {
            calendar.add(Calendar.HOUR_OF_DAY, increaseByHrs);
            String timeFormat = simpleDateFormat.format(calendar.getTime());
            list.add(timeFormat.toLowerCase());
        }
        return list;
    }

    //compare two arrays
    public boolean compareTwoArrays() {
        boolean isMatch = true;
        for (int i = 0; i < currentTimeArray().size(); i++){
            if (!currentTimeArray().get(i).equals(getHours().get(i).getText())){
                isMatch = false;
            }
        } return isMatch;
    }

    //click on Today "+" to expand details
    public void clickOnTodayTimelineToExpand() throws InterruptedException {
        WebElement element = SharedSD.getDriver().findElement(By.xpath("//span[contains(text(),'Today')]"));
        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        mouseOver(todayExpandTimelineLocator);
        Thread.sleep(2000);
        clickOn(todayExpandTimelineLocator);
    }

    //get min today temp from the header of expand window
    public String getMinTempFromRange() {
        return getTextFromElement(minTodayTempRangeLocator);
    }

    //get max today temp from the header of expand window
    public String getMaxTempFromRange() {
        return getTextFromElement(maxTodayTempRangeLocator);
    }

    //get min today temp from the low-high scale with arrow
    public String getLowTempFromExpanded() {
        return getTextFromElement(lowTodayTempExpandedLocator);
    }

    //get max today temp from the low-high scale with arrow
    public String getHighTempFromExpanded() {
        return getTextFromElement(highTodayTempExpandedLocator);
    }


    //get today's current temp
    public String getCurrentTemp() {
        return getTextFromElement(currentTempLocator);
    }

    //get an array of today's temps
    public List<WebElement> getTemps() {
        return getWebElements(tempsLocator);
    }

    //convert WebElement array into String array
    public List<String> convertGetTemps() {
        List<String> convertedGetTemps = new ArrayList<>();
        for (WebElement element : getTemps()) {
            convertedGetTemps.add(element.getText());
        }
        return convertedGetTemps;
    }

    //convert String Array into Integer array and remove extra "degree" sign
    public List<Integer> convertNewGetTemps() {
        List<Integer> newGetTemps = new ArrayList<>();
        for (String element : convertGetTemps()) {
            newGetTemps.add(Integer.valueOf(element.substring(0,element.length()-1)));
        }
        Collections.sort(newGetTemps);
        return newGetTemps;
    }

    //get min value from integer array
    public int getMinDailyTemp() {
        int min = convertNewGetTemps().get(0);
            for (int i = 1; i < convertNewGetTemps().size(); i++) {
            if (convertNewGetTemps().get(i) < min) {
                min = convertNewGetTemps().get(i);
            }
        }
        return min;
    }

    //get max value for integer array
    public int getMaxDailyTemp() {
        int max = convertNewGetTemps().get(0);
        for (int i = 1; i < convertNewGetTemps().size(); i++) {
            if (convertNewGetTemps().get(i) > max) {
                max = convertNewGetTemps().get(i);
            }
        }
        return max;
    }

    //compare today's current temp with min and max today's temps
    public boolean compareCurrentTemp () {
        boolean isNotGreater = false;
        int currentTemp = Integer.valueOf(getCurrentTemp().substring(0,2));
        int minTemp = convertNewGetTemps().get(0);
        int maxTemp = convertNewGetTemps().get(convertNewGetTemps().size()-1);
        for (int i = 0; i < convertNewGetTemps().size(); i++) {
            if (currentTemp > minTemp || currentTemp < maxTemp) {
//            if (currentTemp > getMinDailyTemp() || currentTemp < getMaxDailyTemp()) {
                isNotGreater = true;
            }
        } return isNotGreater;
    }

    //click on Dark Sky API button in the header
    public void clickOnDarkskyApiButton() {
        clickOn(darkskyApiButton);
    }












}
