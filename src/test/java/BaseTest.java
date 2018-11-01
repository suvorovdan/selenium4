import Page.TestProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    @BeforeClass
    public static void setUp() throws Exception {
        String s = properties.getProperty("browser");
        if ("firefox".equals(s)) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
            driver = new FirefoxDriver();

        } else if ("chrome".equals(s)) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();

        } else {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
        }
        baseUrl = properties.getProperty("app.url");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}