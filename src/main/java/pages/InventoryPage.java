package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {

    private WebDriver driver;

    public By cartIcon = By.className("shopping_cart_link");
    public By inventoryItems = By.className("inventory_item");

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

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

}
