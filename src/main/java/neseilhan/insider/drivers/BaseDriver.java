package neseilhan.insider.drivers;

import neseilhan.insider.utils.ConfigReader;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseDriver {
    public static WebDriver driver;

    ConfigReader configReader;

    public BaseDriver() {
        configReader = new ConfigReader();
    }
    @Before
    public void setUp() {
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.get("https://useinsider.com/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notification");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--ignore-certificate-errors-spki-list");
        chromeOptions.addArguments("--suppress-message-center-popups");
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }

}
