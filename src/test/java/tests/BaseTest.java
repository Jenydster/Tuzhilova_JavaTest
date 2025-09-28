package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;


public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductPage productsPage;
    protected CartPage cartPage;


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        loginPage = new LoginPage(driver);
        productsPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}