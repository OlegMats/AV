package BDD.stepDefinitions;

import framework.appiumDriver.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import pages.LoginPage;
import pages.MainPage;
import pages.OtherPage;

import java.net.URL;

public class Login {

    @Before
    public void setup() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        caps.setCapability(MobileCapabilityType.APP, "src\\test\\resources\\appsBinaries\\av_by.apk");
        try {
            URL url = new URL("http://localhost:4723/wd/hub");
            AppiumDriver.Init(url, caps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(){
        AppiumDriver.Quit();
    }

    @Given("user is in 'Other' section")
    public void navigateToOtherPage() {
        MainPage.GoTo(MainPage.other);
    }

    @When("user is navigated to login form")
    public void navigateToLoginForm() {
        OtherPage.GoToLoginForm();
    }

    @And("^user enters (.*), (.*) and click on loginButton$")
    public void loggedIn(String email, String password) {
        LoginPage.LoginByMail(email, password);
    }

    @Then("user is logged in")
    public void checkLogin() {
        Assert.assertTrue(OtherPage.CheckForQuitButtonPresence());
    }
}
