package tests;

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

    @Test(description = "Проверка ошибки для locked_out_user")
    public void testLockedOutUserErrorMessage() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorMessageDisplayed(),
                "Сообщение об ошибке должно отображаться");

        String errorText = loginPage.getErrorMessage();
        assertTrue(errorText.contains("Sorry, this user has been locked out"),
                "Текст ошибки должен содержать информацию о блокировке пользователя");
    }

    @Test(description = "Проверка ошибки при пустом поле логина")
    public void testEmptyUsernameErrorMessage() {
        loginPage.open();
        // Вводим только пароль, логин оставляем пустым
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        assertTrue(loginPage.isErrorMessageDisplayed(),
                "Сообщение об ошибке должно отображаться при пустом логине");

        String errorText = loginPage.getErrorMessage();
        assertEquals(errorText, "Epic sadface: Username is required",
                "Текст ошибки должен требовать ввод username");
    }

    @Test(description = "Проверка ошибки при пустом поле пароля")
    public void testEmptyPasswordErrorMessage() {
        loginPage.open();
        // Вводим только логин, пароль оставляем пустым
        loginPage.enterUsername("standard_user");
        loginPage.clickLogin();

        assertTrue(loginPage.isErrorMessageDisplayed(),
                "Сообщение об ошибке должно отображаться при пустом пароле");

        String errorText = loginPage.getErrorMessage();
        assertEquals(errorText, "Epic sadface: Password is required",
                "Текст ошибки должен требовать ввод password");
    }
}