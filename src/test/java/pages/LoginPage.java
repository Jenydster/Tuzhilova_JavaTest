package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void login(String login, String password) {
        fillLoginField(login);
        fillPasswordField(password);
        clickSubmit();
    }
    public void fillLoginField(String login) {
        driver.findElement(USERNAME_INPUT).sendKeys(login);

    }

    public void fillPasswordField(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
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