package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import java.util.Set;

public class CartTest extends BaseTest {

    @Test
    public void testSocialLinks() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        InventoryPage inventoryPage = new InventoryPage(driver);

        // Test LinkedIn
        String mainWindow = driver.getWindowHandle();
        inventoryPage.clickLinkedIn();
        Thread.sleep(2000);
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                String url = driver.getCurrentUrl();
                Assert.assertTrue(url.contains("linkedin"));
                driver.close();
                break;
            }
        }
        driver.switchTo().window(mainWindow);

        // Test Facebook
        inventoryPage.clickFacebook();
        Thread.sleep(2000);
        allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                String url = driver.getCurrentUrl();
                Assert.assertTrue(url.contains("facebook"));
                driver.close();
                break;
            }
        }
        driver.switchTo().window(mainWindow);

        // Test Twitter
        inventoryPage.clickTwitter();
        Thread.sleep(2000);
        allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                String url = driver.getCurrentUrl();
                Assert.assertTrue(url.contains("x.com"));
                driver.close();
                break;
            }
        }
        driver.switchTo().window(mainWindow);
    }

    @Test
    public void testEmptyCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartIcon();

        int count = cartPage.getCartItemCount();
        Assert.assertEquals(count, 0);
    }

    @Test
    public void testAdd3Products() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProduct("Sauce Labs Backpack");
        inventoryPage.addProduct("Sauce Labs Bolt T-Shirt");
        inventoryPage.addProduct("Sauce Labs Onesie");

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartIcon();

        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"));
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Onesie"));
    }

    @Test
    public void testRemoveProduct() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProduct("Sauce Labs Backpack");
        inventoryPage.addProduct("Sauce Labs Bolt T-Shirt");
        inventoryPage.addProduct("Sauce Labs Onesie");

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartIcon();
        cartPage.removeProduct("Sauce Labs Bolt T-Shirt");
        cartPage.clickContinueShopping();

        String button1 = inventoryPage.getButtonText("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(button1, "Add to cart");

        String button2 = inventoryPage.getButtonText("Sauce Labs Backpack");
        Assert.assertEquals(button2, "Remove");

        String button3 = inventoryPage.getButtonText("Sauce Labs Onesie");
        Assert.assertEquals(button3, "Remove");
    }
}