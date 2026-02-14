package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InventoryPage {

    private WebDriver driver;

    public By cartIcon = By.className("shopping_cart_link");
    public By inventoryItems = By.className("inventory_item");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Part 1 Methods
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isCartIconDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getProductCount() {
        List<WebElement> products = driver.findElements(inventoryItems);
        return products.size();
    }

    // Part 2 Methods - NEW
    public void clickLinkedIn() {
        driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']")).click();
    }

    public void clickFacebook() {
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/saucelabs']")).click();
    }

    public void clickTwitter() {
        driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
    }

    public void addProduct(String productName) {
        if (productName.equals("Sauce Labs Backpack")) {
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        }
        if (productName.equals("Sauce Labs Bolt T-Shirt")) {
            driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        }
        if (productName.equals("Sauce Labs Onesie")) {
            driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        }
    }

    public String getButtonText(String productName) {
        if (productName.equals("Sauce Labs Backpack")) {
            try {
                driver.findElement(By.id("remove-sauce-labs-backpack"));
                return "Remove";
            } catch (Exception e) {
                return "Add to cart";
            }
        }
        if (productName.equals("Sauce Labs Bolt T-Shirt")) {
            try {
                driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
                return "Remove";
            } catch (Exception e) {
                return "Add to cart";
            }
        }
        if (productName.equals("Sauce Labs Onesie")) {
            try {
                driver.findElement(By.id("remove-sauce-labs-onesie"));
                return "Remove";
            } catch (Exception e) {
                return "Add to cart";
            }
        }
        return "";
    }
}