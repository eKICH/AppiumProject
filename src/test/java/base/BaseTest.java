package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    AndroidDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected YourCartPage yourCartPage;
    protected CheckOutInfoPage checkOutInfoPage;
    protected CheckOutOverviewPage checkOutOverviewPage;
    protected CheckOutCompletePage checkOutCompletePage;

    @BeforeClass
    //Method to set desired capabilities
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        //Setting capabilities
        dc.setCapability("automationName", "uiautomator2");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "7.1.2");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("app", "E:\\Appium-Automation\\saucedemoapp\\saucelabapp\\app" +
                "\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        dc.setCapability("appPackage", "com.swaglabsmobileapp");
        dc.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");

        //Initialize a new Android Driver object
        driver = new AndroidDriver(remoteUrl, dc);

        //Set wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkOutInfoPage = new CheckOutInfoPage(driver);
        checkOutOverviewPage = new CheckOutOverviewPage(driver);
        checkOutCompletePage = new CheckOutCompletePage(driver);
    }

    @AfterClass
    //Method to quit session
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    //Login Helper method
    public void logIn(){
        loginPage.keyingUserName("standard_user");
        loginPage.keyingPassword("secret_sauce");
        productsPage = loginPage.clickLoginButton();
    }
}
