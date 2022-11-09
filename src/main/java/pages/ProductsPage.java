package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductsPage {
    private final AndroidDriver driver;
    private final By productsTxt = By
            .xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]" +
                    "/android.view.ViewGroup/android.widget.TextView");
    private final By backPackBtn = By
            .xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    private final By newBtnTxt = By
            .xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]/android.widget.TextView");
    private final By cartIcon = By
            .xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]" +
                    "/android.view.ViewGroup/android.widget.ImageView");
    private final By hamburgerMenu = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]" +
            "/android.view.ViewGroup/android.widget.ImageView");
    private final By logoutOption = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]" +
            "/android.widget.TextView");

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
    }


    //Method to confirm we are logged into the products page
    public String getProductsText() {
        return driver.findElement(productsTxt).getText();
    }

    //Method to click add to cart button
    public void clickAddToCartButton() {
        driver.findElement(backPackBtn).click();
    }

    //Method to confirm the add to cart button name changes to REMOVE
    public String getRemoveTxt(){
        return driver.findElement(newBtnTxt).getText();
    }

    //Method to click the cart icon
    public YourCartPage clickCartIcon(){
        driver.findElement(cartIcon).click();
        return new YourCartPage(driver);
    }

    //Method to click hamburger menu
    public void clickHamburgerIcon(){
        driver.findElement(hamburgerMenu).click();
    }

    //Method to click logout
    public LoginPage clickLogOut(){
        driver.findElement(logoutOption).click();
        return new LoginPage(driver);
    }
}
