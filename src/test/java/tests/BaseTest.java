public class BaseTest {import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

    public class BaseTest {
        protected WebDriver browser;

        @BeforeMethod
        public void setup() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--guest");
            browser = new ChromeDriver(options);
            browser.manage().window().maximize();
        }

        @AfterMethod
        public void tearDown() {
            if (browser != null) {
                browser.quit();
            }
        }
    }
}
