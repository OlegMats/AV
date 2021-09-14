package pages;

import framework.FW;
import framework.appiumDriver.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class OtherPage {
    public static By entranceField = MobileBy.id("by.av.client:id/unauthorized");
    public static By username = MobileBy.id("by.av.client:id/userName");
    public static By logout = MobileBy.id("by.av.client:id/logout");

    public static void GoToLoginForm() {
        AppiumDriver.FindElement(entranceField).click();
//        FW.Log().Step("Login Form is opened");
    }
    public static String GetUsername(){
        return AppiumDriver.FindElement(username).getText();
    }
    public static Boolean CheckForQuitButtonPresence(){
        return AppiumDriver.FindElement(logout).isDisplayed();
    }
}
