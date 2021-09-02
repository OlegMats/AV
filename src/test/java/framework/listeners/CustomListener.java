package framework.listeners;

import framework.FW;
import framework.appiumDriver.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.net.URL;

public class CustomListener implements ITestListener {
    public void onStart(ITestContext context) {
        FW.SetConfig();
        FW.CreateTestDirectory();
    }

    public void onTestStart(ITestResult result) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        caps.setCapability(MobileCapabilityType.APP, "src\\test\\resources\\appsBinaries\\av_by.apk");
        try {
            URL url = new URL("http://localhost:4723/wd/hub");
            FW.SetLogger(result.getName());
            AppiumDriver.Init(url, caps);
        } catch (Exception e) {
            FW.Log().Error("Cause is : " + e.getCause());
            FW.Log().Error("Message is : " + e.getMessage());
            e.printStackTrace();
        }
        FW.Log().Info(String.format("Test name is: %s", result.getName()));
    }

    public void onTestSuccess(ITestResult result) {
        FW.Log().Info("Test has been passed");
        FW.Log().CloseStream();
        AppiumDriver.Quit();
    }

    public void onTestFailure(ITestResult result) {
        AppiumDriver.TakeScreenShot(result.getName());
        FW.Log().Info("Test has been failed");
        FW.Log().CloseStream();
        AppiumDriver.Quit();
    }

    public void onTestSkipped(ITestResult result) {
        FW.Log().Info("Test has been skipped");
        FW.Log().CloseStream();
        AppiumDriver.Quit();
    }

    public void onFinish(ITestContext context) {

    }
}
