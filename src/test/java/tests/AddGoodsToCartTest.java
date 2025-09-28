package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AddGoodsToCartTest extends BaseTest {

    @Test(description = "Проверка добавления товаров в корзину")
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart(0);
        productsPage.addToCart(1);

        productsPage.openCart();

        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Onesie"),
                "Товар 'Sauce Labs Onesie' должен быть в корзине");

        assertEquals(cartPage.getProductsNames().size(), 3,
                "В корзине должно быть 3 товара");
    }
}
