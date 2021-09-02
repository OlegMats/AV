package pages;

import framework.FW;
import framework.appiumDriver.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class MainPage {
    public static By other = MobileBy.id("by.av.client:id/navigation_other");
    public static By dialogs = MobileBy.id("by.av.client:id/navigation_dialogs");
    public static By adverts = MobileBy.id("by.av.client:id/navigation_adverts_collection");
    public static By bookmarks = MobileBy.id("by.av.client:id/navigation_bookmarks_collection");
    public static By search = MobileBy.id("by.av.client:id/navigation_primary");

    public static void GoTo(By by) {
        AppiumDriver.FindElement(by).click();
        String section = by.toString().split("/")[1].split("_")[1];
        FW.Log().Step(section.equals("primary") ? "'SEARCH' section is opened" : String.format("'%s' section is opened", section.toUpperCase()));
    }
}
