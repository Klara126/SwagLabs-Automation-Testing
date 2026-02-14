package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By cartIcon = By.className("shopping_cart_link");
    private By continueShoppingButton = By.name("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public int getCartItemCount() {
        return driver.findElements(By.className("cart_item")).size();
    }

    public boolean isProductInCart(String productName) {
        try {
            driver.findElement(By.xpath("//div[text()='" + productName + "']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void removeProduct(String productName) {
        if (productName.equals("Sauce Labs Backpack")) {
            driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        }
        if (productName.equals("Sauce Labs Bolt T-Shirt")) {
            driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        }
        if (productName.equals("Sauce Labs Onesie")) {
            driver.findElement(By.id("remove-sauce-labs-onesie")).click();
        }
    }

    public void clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
    }
}