package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckOutCompletePage {

    private final AndroidDriver driver;
    private final By thankYouTxt = By
            .xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]" +
                    "/android.view.ViewGroup/android.widget.TextView[1]");
    private final By backHomeBtn = AppiumBy.accessibilityId("test-BACK HOME");

    public CheckOutCompletePage(AndroidDriver driver){
        this.driver = driver;
    }

    //Assert the Thank-you text is available
    public String getThankYouText(){
        return driver.findElement(thankYouTxt).getText();
    }

    //Method to click back home button
    public ProductsPage clickBackHome(){
        driver.findElement(backHomeBtn).click();
        return new ProductsPage(driver);
    }
}
