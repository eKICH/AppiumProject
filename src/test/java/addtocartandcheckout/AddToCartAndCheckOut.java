package addtocartandcheckout;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddToCartAndCheckOut extends BaseTest {

    @Test(testName = "Adding to Cart, Checkout, and logout")
    public void addToCart() throws InterruptedException {
        logIn();
        productsPage.clickAddToCartButton();
        assertTrue(productsPage.getRemoveTxt().contains("REMOVE"),
                "Button text is wrong!");

        //Click cart icon - Your Cart Page
        yourCartPage = productsPage.clickCartIcon();
        assertTrue(yourCartPage.confirmYourCartPage().contains("YOUR CART"),
                "You are in the wrong page!");

        //Click CheckOut button - Checkout information page
        checkOutInfoPage = yourCartPage.clickCheckOut();

        //Keying checkout information
        checkOutInfoPage.keyingFirstName("first");
        checkOutInfoPage.keyingLastName("Customer");
        checkOutInfoPage.keyingPostalCode("890-001");

        //Checkout overview page
        checkOutOverviewPage = checkOutInfoPage.clickContinue();

        //Checkout complete
        checkOutCompletePage = checkOutOverviewPage.clickFinish();
        assertTrue(checkOutCompletePage.getThankYouText().contains("THANK YOU FOR YOU ORDER"),
                "Wrong Text!");

        //Click back home button
        productsPage = checkOutCompletePage.clickBackHome();
        assertTrue(productsPage.getProductsText().contains("PRODUCTS"),
                "You are in the wrong page");

        //Logout
        productsPage.clickHamburgerIcon();
        loginPage = productsPage.clickLogOut();

        Thread.sleep(3000);
    }
}
