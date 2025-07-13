package neseilhan.insider.methods;

import neseilhan.insider.drivers.BaseDriver;
import neseilhan.insider.utils.LocatorHelper;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;


public class BaseMethods {
    private static Map<String, String> savedValue = new HashMap<>();
    private static int sizeJobList = 0;
    static WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    private LocatorHelper helper = new LocatorHelper();

    public BaseMethods() {
        driver = BaseDriver.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public static void TakeScreenshot(String FileName)
            throws IOException
    {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        File File = ((TakesScreenshot)driver)
//                .getScreenshotAs(OutputType.FILE);
        String fileNamewithTimeStamp = FileName + "_" + timestamp + ".jpeg"; //olusturulan dosya adları farklı olsun timestamp eklesin
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,
                new File("D:\\IdeaProjects\\automated_test_insider\\src\\test\\java\\Screenshots\\"
                        + fileNamewithTimeStamp + ".jpeg"));

    }

    public static void MakeBorder(WebElement Element)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(
                "arguments[0].style.border = '3px solid red'",
                Element);
    }

    protected WebElement findElement(String locatorKey) {
        return helper.findElement(locatorKey, driver);
    }

    protected By findElementInfoBy(String locatorKey) {
        return helper.findElementInfoBy(locatorKey);
    }

    protected void waitBySecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected WebElement waitForElementToBeVisible(String locatorKey) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(findElementInfoBy(locatorKey)));
    }

    protected List<WebElement> findsElements(String locatorKey) {
        return driver.findElements(findElementInfoBy(locatorKey));
    }

    protected void clickElement(String locatorKey) {
        findElement(locatorKey).click();

    }

    protected void javascriptclicker(String locatorKey) {
        WebElement element = findElement(locatorKey);
        JavascriptExecutor executor = (JavascriptExecutor) jsdriver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected WebElement scrollToElementToBeVisible(String key) {
        WebElement webElement = findElement(key);
        try {
            if (webElement != null) {
                scrollTo(webElement.getLocation().getX(), webElement.getLocation().getY() - 100);
                Thread.sleep(1 * 1000L);
                Assert.assertTrue("element Not Found", webElement.isDisplayed());
            }

            return webElement;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void scrollTo(int x, int y) {
        String script = String.format("window.scrollTo(%d, %d);", x, y);
        executeJS(script, true);
    }

    private Object executeJS(String script, boolean wait) {
        return wait ? jsdriver.executeScript(script, "") : jsdriver.executeAsyncScript(script, "");
    }


    protected void gotoURL(String url) {
        driver.navigate().to(url);
    }

    protected void checkIsTextContainsList(String key, String expectedValue) {
        List<WebElement> keys = findsElements(key);
        sizeJobList = keys.size();
        int workQuantity = 1;
        for (WebElement element : keys) {
            Assert.assertTrue("Text doesn't match", element.getText().contains(expectedValue));
            workQuantity++;
        }

    }

    protected void hoverOverElementWithSelectedSize(String key) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(findsElements(key).get(sizeJobList - 1)).perform();
            Thread.sleep(1 * 500L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    protected void saveValueLastJob(String key) {
        WebElement element = findsElements(key).get(sizeJobList - 1);
        String cleanValue = element.getText().replace(" /", "");
        savedValue.put(key, cleanValue);
    }

//    protected void isSavedValueEqualExpectedValue(String key, String savedValueKey) {
//        String cleanValue = findElement(key).getText().replace(" /", "");
//        Assert.assertEquals("Text doesn't match", savedValue.get(savedValueKey), cleanValue);
//    }

    protected void switchToSecondTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);

        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        } else {
            System.out.println("A second tab was not found");
        }
    }

    protected void checkForElement(String key, String errorMessage) {
        Assert.assertTrue(errorMessage, findElement(key).isDisplayed());
    }
//
//    protected void clickElementWithSelectedSize(String key) {
//        findsElements(key).get(sizeJobList - 1).click();
//    }



    protected String getCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
    protected void checkUrlContains(String expectedPart) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("URL does not contain expected value: " + expectedPart, currentUrl.contains(expectedPart));
    }

    protected void checkDepartmentContains(String locatorKey, String expectedDepartment) {
        String departmentText = findElement(locatorKey).getText().replace(" /", "").trim();
        Assert.assertTrue("Department does not contain expected value: " + expectedDepartment, departmentText.contains(expectedDepartment));
    }

}
