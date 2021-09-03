package framework.appiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class AppiumDriver {
    public static AndroidDriver<MobileElement> driver;

    public static void Init(URL url, DesiredCapabilities caps) {
        driver = new AndroidDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static AndroidDriver<MobileElement> Current() {
        if (driver != null)
            return driver;
        throw new NullPointerException("driver is null");
    }

    public static MobileElement FindElement(By by) {
        return Current().findElement(by);
    }

    public static void Quit() {
        Current().quit();
    }

    public static void TakeScreenShot(String methodName) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd_MM_yy_hh_mm_ss");
        String dateTime = LocalDateTime.now().format(dateTimeFormatter);
        File scrFile = Current().getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + String.format("\\TestResults\\%s\\", methodName) + methodName + "_" + dateTime + ".png");
        try {
            FileUtils.copyFile(scrFile, destination);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void ScrollDownClick(String text){
        Current().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0))").click();
    }
}
