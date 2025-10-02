package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка успешной авторизации standard_user")
    public void testSuccessfulLoginWithStandardUser() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isTitlePresent(),
                "Заголовок страницы продуктов должен отображаться");
        assertEquals(productsPage.getTitle(), "Products",
                "Название заголовка не соответствует ожидаемому");
        assertTrue(productsPage.isMenuButtonDisplayed(),
                "Кнопка меню должна отображаться после успешного логина");
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dependsOnMethods = "testSuccessfulLoginWithStandardUser", priority = 1, dataProvider = "loginData",
            description = "Проверка сообщений об ошибке при некорректной авторизации")
    public void checkIncorrectLogin(String username, String password, String expectedErrorMsg) {
        loginPage.open();
        loginPage.login(username, password);

        assertTrue(loginPage.isErrorMessageDisplayed(), "Ожидается отображение сообщения об ошибке");
        assertEquals(loginPage.getErrorMessage(), expectedErrorMsg,
                "Текст ошибки не соответствует ожидаемому");
    }
}