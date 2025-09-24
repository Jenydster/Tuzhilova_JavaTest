public class LoginTest {import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

    public class LoginTest extends BaseTest {

        @Test
        public void testSuccessfulLoginWithStandardUser() {
            // Открываем страницу логина
            browser.get("https://www.saucedemo.com/");

            // Вводим логин и пароль
            browser.findElement(By.id("user-name")).sendKeys("standard_user");
            browser.findElement(By.id("password")).sendKeys("secret_sauce");

            // Нажимаем кнопку Login
            browser.findElement(By.id("login-button")).click();

            // Проверяем, что мы успешно залогинились
            WebElement productsTitle = browser.findElement(By.cssSelector(".title"));
            assertTrue(productsTitle.isDisplayed());
            assertEquals(productsTitle.getText(), "Products");

            // Проверяем наличие кнопки меню (дополнительная проверка)
            WebElement menuButton = browser.findElement(By.id("react-burger-menu-btn"));
            assertTrue(menuButton.isDisplayed());
        }

        @Test
        public void testLockedOutUserErrorMessage() {
            // Открываем страницу логина
            browser.get("https://www.saucedemo.com/");

            // Вводим логин заблокированного пользователя
            browser.findElement(By.id("user-name")).sendKeys("locked_out_user");
            browser.findElement(By.id("password")).sendKeys("secret_sauce");

            // Нажимаем кнопку Login
            browser.findElement(By.id("login-button")).click();

            // Проверяем сообщение об ошибке
            WebElement errorMessage = browser.findElement(By.cssSelector("[data-test='error']"));
            assertTrue(errorMessage.isDisplayed());
            assertTrue(errorMessage.getText().contains("Sorry, this user has been locked out"));

            // Проверяем, что мы остались на странице логина
            WebElement loginButton = browser.findElement(By.id("login-button"));
            assertTrue(loginButton.isDisplayed());
        }
    }
}
