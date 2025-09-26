package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private static final By PRODUCTS_TITLE = By.cssSelector(".title");
    private static final By MENU_BUTTON = By.id("react-burger-menu-btn");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return driver.findElement(PRODUCTS_TITLE).isDisplayed();
    }

    public String getTitle() {
        return driver.findElement(PRODUCTS_TITLE).getText();
    }

    public boolean isMenuButtonDisplayed() {
        return driver.findElement(MENU_BUTTON).isDisplayed();
    }
}