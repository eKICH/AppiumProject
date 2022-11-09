package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class YourCartPage {

    private final AndroidDriver driver;
    private final By yourCartTxt = By
            .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android" +
                    ".widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
                    "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
                    "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android" +
                    ".view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android" +
                    ".view.ViewGroup[2]/android.widget.TextView");
    private final By checkoutBtn = AppiumBy.accessibilityId("test-CHECKOUT");

    public YourCartPage(AndroidDriver driver){
        this.driver = driver;
    }

    //Method to confirm you are in your cart page
    public String confirmYourCartPage(){
        return driver.findElement(yourCartTxt).getText();
    }

    //Method to click checkout button
    public CheckOutInfoPage clickCheckOut(){
        driver.findElement(checkoutBtn).click();
        return new CheckOutInfoPage(driver);
    }
}
