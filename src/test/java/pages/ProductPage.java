package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    final By title = By.xpath("//span[@data-test='title']");
    final By title2 = By.xpath("//*[text()='Products']");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[text()='Add to cart']");
    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//*[text() ='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");

    private static final By MENU_BUTTON = By.id("react-burger-menu-btn");

    public boolean isMenuButtonDisplayed() {
        return driver.findElement(MENU_BUTTON).isDisplayed();
    }

    public void openCart() {
        driver.findElement(CART_BUTTON).click();
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public boolean isTitlePresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title2)).isDisplayed();
    }

    public void addToCart(String goodsName) {
// By addToCart = By.xpath(String.format(ADD_TO_CART_BUTTON_PATTERN, goodsName));
        By addToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public void addToCart(int goodsIndex) {
        //  By addToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN(goodsName));
        driver.findElements(ADD_TO_CART_BUTTON).get(goodsIndex).click();
    }
}
