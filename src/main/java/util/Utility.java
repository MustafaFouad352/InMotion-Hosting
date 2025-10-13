package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;

public class Utility {

    public static class Waits {
        private static final int DEFAULT_TIMEOUT = 20;

        public static WebElement waitForVisibility(WebDriver driver, By locator) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        public static WebElement waitForClickable(WebDriver driver, By locator) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }

        public static boolean waitForInvisibility(WebDriver driver, By locator) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }
    }

   /* public static class Verifications {

        public static void verifyTextContains(String actual, String expected) {
            Assert.assertTrue(actual.contains(expected),
                    "Expected text to contain: '" + expected + "' but got: '" + actual + "'");
        }

        public static void verifyEquals(String actual, String expected) {
            Assert.assertEquals(actual, expected,
                    "Expected: '" + expected + "' but got: '" + actual + "'");
        }

        public static void verifyListContainsAll(List<String> actualList, String... expectedItems) {
            for (String item : expectedItems) {
                Assert.assertTrue(actualList.contains(item),
                        "List should contain: '" + item + "'");
            }
        }

        public static void verifyElementDisplayed(WebElement element) {
            Assert.assertTrue(element.isDisplayed(), "Element should be displayed");
        }
    }
*/
    public static class Screenshots {

        public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File("screenshots/" + fileName + ".png");

            destination.getParentFile().mkdirs();

            source.toPath();
            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
    public static class Debug {
        public static void printPageInfo(WebDriver driver, String stepName) {
            System.out.println("=== " + stepName + " ===");
            System.out.println("URL: " + driver.getCurrentUrl());
            System.out.println("Title: " + driver.getTitle());
            System.out.println("======================");
        }

        public static void takeScreenshot(WebDriver driver, String testName) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("screenshots/" + testName + ".png"));
            } catch (Exception e) {
                System.out.println("Faild screenshot: " + e.getMessage());
            }
        }
    }
}