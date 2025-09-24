package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        // Проверяем, что элемент существует перед получением текста
        List<WebElement> errorElements = driver.findElements(ERROR_MESSAGE);
        if (!errorElements.isEmpty() && errorElements.get(0).isDisplayed()) {
            return errorElements.get(0).getText();
        }
        return "";
    }

    public boolean isErrorMessageDisplayed() {
        // Правильная проверка: элемент существует И отображается
        List<WebElement> errorElements = driver.findElements(ERROR_MESSAGE);
        return !errorElements.isEmpty() && errorElements.get(0).isDisplayed();
    }

    public void enterUsername(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}