package neseilhan.insider.methods;

import neseilhan.insider.drivers.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;

public class BaseMethods {
    private static Map<String, String> savedValue = new HashMap<>();
    private static int sizeJobList = 0;
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;

    public BaseMethods() {
        driver = BaseDriver.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    protected WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    protected void click(By by) {
        findElement(by).click();
    }

    protected void type(By by, String text) {
        findElement(by).sendKeys(text);
    }

//    protected void pressEnter(By by) {
//        findElement(by).sendKeys(Keys.ENTER);
//    }
//
    protected void clickWithJS(By by) {
        WebElement element = findElement(by);
        jsdriver.executeScript("arguments[0].click();", element);
    }

    protected WebElement scrollToElement(By by) {
        WebElement element = findElement(by);
        jsdriver.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        Assert.assertTrue("Element not found", element.isDisplayed());
        return element;
    }

    protected void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void goToUrl(String url) {
        driver.navigate().to(url);
    }

    protected WebElement waitForElementToBeVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void assertTextContainsInList(By by, String expectedValue) {
        List<WebElement> elements = findElements(by);
        Assert.assertFalse("Element list is empty", elements.isEmpty());
        sizeJobList = elements.size();
        int workQuantity = 1;
        for (WebElement element : elements) {
            Assert.assertTrue("Text doesn't match", element.getText().contains(expectedValue));
            workQuantity++;
        }
    }

    protected void hoverOverLastElement(By by) {
        List<WebElement> elements = findElements(by);
        Assert.assertFalse("Element list is empty", elements.isEmpty());
        Actions actions = new Actions(driver);
        actions.moveToElement(elements.get(elements.size() - 1)).perform();
        waitSeconds(1);
    }

//    protected void saveText(By by, String key) {
//        String text = findElement(by).getText().replace(" /", "");
//        savedValue.put(key, text);
//    }
    protected void saveValue(By by, String key) {
        String cleanValue = findElement(by).getText().replace(" /", "").trim();
        savedValue.put(key, cleanValue);
    }

    protected void saveValueLastJob(By by, String key) {
        List<WebElement> elements = findElements(by);
        Assert.assertFalse("Element list is empty", elements.isEmpty());
        String cleanValue = elements.get(elements.size() - 1).getText().replace(" /", "").trim();
        savedValue.put(key, cleanValue);
    }
    protected void isSavedValueEqualExpectedValue(By by, String savedValueKey) {
        String cleanValue = findElement(by).getText().replace(" /", "").trim();
        Assert.assertNotNull("Saved value is null for key: " + savedValueKey, savedValue.get(savedValueKey));
        Assert.assertEquals("Text doesn't match", savedValue.get(savedValueKey), cleanValue);
    }

    protected void saveLastElementText(By by, String key) {
        List<WebElement> elements = findElements(by);
        Assert.assertFalse("Element list is empty", elements.isEmpty());
        String cleanText = elements.get(elements.size() - 1).getText().replace(" /", "").trim(); //trim() eklenebilir?
        savedValue.put(key, cleanText);
    }

    protected void compareWithSavedElement(By by, String key) {
//        String text = findElement(by).getText().replace(" /", "").trim(); //trim() eklenebilir?
//        Assert.assertEquals("Text doesn't match", savedValue.get(key), text);
        String currentText = findElement(by).getText().replace(" /", "").trim();
        String expectedText = savedValue.get(key);
        Assert.assertNotNull("No saved value found for key: " + key, expectedText);
        Assert.assertEquals("Text doesn't match", expectedText, currentText);
    }

    protected void switchToNewTab() {
        Set<String> handles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(handles);
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        } else {
            Assert.fail("New tab not found");
        }
    }

    protected void checkIfElementVisible(By by, String message) {
        Assert.assertTrue(message, findElement(by).isDisplayed());
    }

    protected void clickLastElement(By by) {
        List<WebElement> elements = findElements(by);
        Assert.assertFalse("Element list is empty", elements.isEmpty());
        elements.get(elements.size() - 1).click();
    }

    protected String getCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
}
