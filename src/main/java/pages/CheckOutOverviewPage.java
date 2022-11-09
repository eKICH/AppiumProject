package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckOutOverviewPage {

    private final AndroidDriver driver;
    private final By finalBtn = AppiumBy.accessibilityId("test-FINISH");

    public CheckOutOverviewPage(AndroidDriver driver){
        this.driver = driver;
    }

    //Click on the finish button
    public CheckOutCompletePage clickFinish(){
        driver.findElement(finalBtn).click();
        return new CheckOutCompletePage(driver);
    }
}
