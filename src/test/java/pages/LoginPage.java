package pages;

import framework.FW;
import framework.appiumDriver.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginPage {
    public static By entranceByMailOrLogin = MobileBy.id("by.av.client:id/chipEmailBg");
    public static By mailOrLoginField = MobileBy.id("by.av.client:id/emailEditView");
    public static By passwordField = MobileBy.id("by.av.client:id/passwordEditView");
    public static By loginButton = MobileBy.id("by.av.client:id/loginButton");

    public static void LoginByMail(String email, String password) {
        AppiumDriver.FindElement(entranceByMailOrLogin).click();
        AppiumDriver.FindElement(mailOrLoginField).sendKeys(email);
        AppiumDriver.FindElement(passwordField).sendKeys(password);
        AppiumDriver.FindElement(loginButton).click();
        FW.Log().Step("Login via email is successfully executed");
    }
}
