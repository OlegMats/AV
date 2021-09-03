package pages;

import framework.appiumDriver.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class SearchResultsPage {
    public static By firstResult = MobileBy.xpath("(//*[@resource-id='by.av.client:id/name'])[1]");

    public static String GetFirstResult() {
        return AppiumDriver.FindElement(firstResult).getText();
    }
}
