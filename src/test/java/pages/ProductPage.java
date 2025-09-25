package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class ProductPage extends BasePage {
    private static final By PRODUCTS_TITLE = By.cssSelector(".title");
    private static final By MENU_BUTTON = By.id("react-burger-menu-btn");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        try {
            return driver.findElement(PRODUCTS_TITLE).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTitle() {
        try {
            WebElement titleElement = driver.findElement(PRODUCTS_TITLE);
            return titleElement.isDisplayed() ? titleElement.getText() : "";
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public boolean isMenuButtonDisplayed() {
        try {
            return driver.findElement(MENU_BUTTON).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}