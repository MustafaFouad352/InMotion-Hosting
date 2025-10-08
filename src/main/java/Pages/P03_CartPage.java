package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Utility;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class P03_CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By cartItems = By.cssSelector(".cart-item");
    private final By removeBtn = By.xpath("//button[contains(@class,'remove')]");
    private final By totalPrice = By.xpath("//*[contains(text(),'Total')]");

    public P03_CartPage waitForPageLoad() {
        wait.until(ExpectedConditions.urlContains("cart"));
        return this;
    }

    public P03_CartPage verifyDomainInCart(String domain) {

            try {
                boolean found = false;

                if (driver.getPageSource().contains(domain)) {
                    found = true;
                }

                List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '" + domain + "')]"));
                if (!elements.isEmpty()) {
                    found = true;
                }

                Assert.assertTrue(found, "Failed " + domain);
                System.out.println("Done " + domain);

            } catch (Exception e) {
                Assert.fail("Failed " + e.getMessage());
            }
            return this;
    }

    public P03_CartPage verifyHostingPlanInCart(String planName) {
        By planLocator = By.xpath("//*[contains(text(),'" + planName + "')]");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(planLocator));
        Assert.assertTrue(element.isDisplayed());
        return this;
    }

    public P03_CartPage verifyPriceInCart() {
        WebElement price = driver.findElement(By.xpath("//*[contains(text(),'$')]"));
        Assert.assertTrue(price.isDisplayed());
        return this;
    }

    public P03_CartPage takeScreenshot(String name) throws IOException {
        Utility.Screenshots.takeScreenshot(driver, name);
        return this;
    }

    public P03_CartPage refreshPage() {
        driver.navigate().refresh();
        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public P03_CartPage removeDomain() {
        List<WebElement> removeButtons = driver.findElements(removeBtn);
        if (!removeButtons.isEmpty()) {
            removeButtons.get(0).click();
            wait.until(ExpectedConditions.stalenessOf(removeButtons.get(0)));
        }
        return this;
    }

    public P03_CartPage verifyDomainRemoved(String domain) {
        List<WebElement> items = driver.findElements(By.xpath("//*[contains(text(),'" + domain + "')]"));
        Assert.assertTrue(items.isEmpty());
        return this;
    }

    public P03_CartPage verifyOnlyHostingRemains() {
        List<WebElement> items = driver.findElements(cartItems);
        Assert.assertTrue(items.size() == 1);
        return this;
    }
}