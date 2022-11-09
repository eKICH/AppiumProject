package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {

    private final AndroidDriver driver;

    private final By userNameField = AppiumBy.accessibilityId("test-Username");
    private final By passwordField = AppiumBy.accessibilityId("test-Password");
    private final By loginBtn= AppiumBy.accessibilityId("test-LOGIN");
    private final By lockedOutErrorMsg= By.xpath("//android.view.ViewGroup[@content-desc=" +
            "\"test-Error message\"]/android.widget.TextView");

    public LoginPage(AndroidDriver driver){
        this.driver = driver;
    }

    /**
     * @param userName
     * Method to key in username
     */

    public void keyingUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }

    /**
     * @param password
     * Method to key in password
     */
    public void keyingPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    /**
     * @return ProductsPage
     * Method to click login button
     */
    public ProductsPage clickLoginButton(){
        driver.findElement(loginBtn).click();
        return new ProductsPage(driver);
    }

    //Method to get lockedOut Error Message
    public String getLockedOutMessage(){
        return driver.findElement(lockedOutErrorMsg).getText();
    }
}
