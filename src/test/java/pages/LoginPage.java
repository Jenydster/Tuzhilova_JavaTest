package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

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
        // Прямой подход - ищем один элемент
        try {
            WebElement errorElement = driver.findElement(ERROR_MESSAGE);
            return errorElement.isDisplayed() ? errorElement.getText() : "";
        } catch (NoSuchElementException e) {
            return ""; // Элемента нет - возвращаем пустую строку
        }
    }

    public boolean isErrorMessageDisplayed() {
        // Прямая проверка одного элемента
        try {
            return driver.findElement(ERROR_MESSAGE).isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // Элемента нет - значит не отображается
        }
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