package loginscenarios;

import base.BaseTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test(testName = "Successful Login")
    public void successfulLogin() throws InterruptedException {
        logIn();
        assertTrue(productsPage.getProductsText().contains("PRODUCTS"),
                "You are not in the products page!");
        System.out.println("You are in the products page!");
        Thread.sleep(5000);
    }

    @Test(testName = "LockedOut User Login", priority = 2)
    public void lockedOutLogin() throws InterruptedException, MalformedURLException {
        loginPage.keyingUserName("locked_out_user");
        loginPage.keyingPassword("secret_sauce");
        productsPage = loginPage.clickLoginButton();
        assertTrue(loginPage.getLockedOutMessage().contains("Sorry, this user has been locked out."),
                "Wrong message!");
        System.out.println("Sorry, this user has been locked out.");
        Thread.sleep(5000);
    }
}
