package pages;

import framework.appiumDriver.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class SearchWithParamsForm {
    public static By brandDropdown = MobileBy.xpath("(//*[@resource-id='by.av.client:id/button'])[1]");
    public static By modelDropdown = MobileBy.xpath("(//*[@resource-id='by.av.client:id/button'])[2]");
    public static By generationDropdown = MobileBy.xpath("(//*[@resource-id='by.av.client:id/button'])[3]");
    public static By results = MobileBy.id("by.av.client:id/showButton");

    public static void SearchForCar(String brand) {
        AppiumDriver.FindElement(brandDropdown).click();
        AppiumDriver.ScrollDownClick(brand);
    }

    public static void SearchForCar(String brand, String model) {
        SearchForCar(brand);
        AppiumDriver.FindElement(modelDropdown).click();
        AppiumDriver.ScrollDownClick(model);
    }

    public static void SearchForCar(String brand, String model, String generation) {
        SearchForCar(brand, model);
        AppiumDriver.FindElement(generationDropdown).click();
        AppiumDriver.ScrollDownClick(generation);
    }


    public static void ShowResults() {
        AppiumDriver.FindElement(results).click();
    }

}
