package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest {

    @Test
    public void testInventoryPageElements() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        // deal with  Inventory page
        InventoryPage inventoryPage = new InventoryPage(driver);

        // check Page Title
        String pageTitle = inventoryPage.getPageTitle();
        Assert.assertEquals(pageTitle, "Swag Labs", "Page title should be 'Swag Labs'");


       //check cart icon
        boolean isCartDisplayed = inventoryPage.isCartIconDisplayed();
        Assert.assertTrue(isCartDisplayed, "Cart icon should be displayed");

        // check products counts
        int productCount = inventoryPage.getProductCount();
        Assert.assertEquals(productCount, 6, "There should be 6 products displayed");
    }
}