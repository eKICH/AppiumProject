package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckOutInfoPage {

    private final AndroidDriver driver;

    private final By firstNameTxt = AppiumBy.accessibilityId("test-First Name");
    private final By lastNameTxt = AppiumBy.accessibilityId("test-Last Name");
    private final By postalCodeTxt = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private final By continueBtn = AppiumBy.accessibilityId("test-CONTINUE");

    public CheckOutInfoPage(AndroidDriver driver){
        this.driver = driver;
    }

    //Method to key in first name
    public void keyingFirstName(String fname){
        driver.findElement(firstNameTxt).sendKeys(fname);
    }

    //Method to key in last name
    public void keyingLastName(String lname){
        driver.findElement(lastNameTxt).sendKeys(lname);
    }

    //Method to key in postal code
    public void keyingPostalCode(String postalCode){
        driver.findElement(postalCodeTxt).sendKeys(postalCode);
    }

    //Method to click button continue
    public CheckOutOverviewPage clickContinue(){
        driver.findElement(continueBtn).click();
        return new CheckOutOverviewPage(driver);
    }
}
