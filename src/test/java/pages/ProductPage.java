package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductPage extends BasePage {
    private static final By PRODUCTS_TITLE = By.cssSelector(".title");
    private static final By MENU_BUTTON = By.id("react-burger-menu-btn");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        List<WebElement> titleElements = driver.findElements(PRODUCTS_TITLE);
        return !titleElements.isEmpty() && titleElements.get(0).isDisplayed();
    }

    public String getTitle() {
        List<WebElement> titleElements = driver.findElements(PRODUCTS_TITLE);
        if (!titleElements.isEmpty() && titleElements.get(0).isDisplayed()) {
            return titleElements.get(0).getText();
        }
        return "";
    }

    public boolean isMenuButtonDisplayed() {
        List<WebElement> menuElements = driver.findElements(MENU_BUTTON);
        return !menuElements.isEmpty() && menuElements.get(0).isDisplayed();
    }
}