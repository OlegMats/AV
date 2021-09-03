package pages;

import framework.FW;
import framework.appiumDriver.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class SearchPage {
    public static By searchWithParams = MobileBy.id("by.av.client:id/collapseContainer");

    public static void SearchWithParams() {
        AppiumDriver.FindElement(searchWithParams).click();
        FW.Log().Step("Search with params form is opened");
    }
}
