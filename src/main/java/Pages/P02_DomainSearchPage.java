package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Utility;

import java.io.IOException;
import java.time.Duration;

import static drivers.DriverHolder.driver;

public class P02_DomainSearchPage {
    WebDriver driver;
    WebDriverWait wait;

    public P02_DomainSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    private final By searchInput = By.xpath("//input[@type='search' or contains(@placeholder, 'domain')]");
    private final By searchButton = By.xpath("//button[contains(text(), 'Search') or @type='submit']");
    private final By availableMsg = By.xpath("//div[contains(@class,'available') or contains(@class,'status')]//*[contains(text(),'available')]");
    private final By price = By.xpath("//*[contains(text(),'$')]");
    private final By addToCartBtn = By.xpath("//button[contains(text(),'Add to Cart')]");
    private final By viewCartBtn = By.xpath("//a[contains(text(),'View Cart')]");
    private final By unavailableMsg = By.xpath("//div[contains(@class,'unavailable') or contains(@class,'status')]//*[contains(text(),'unavailable')]");

    public P02_DomainSearchPage waitForPageLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        return this;
    }

    public P02_DomainSearchPage enterDomain(String domain) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        input.clear();
        input.sendKeys(domain);
        return this;
    }

    public P02_DomainSearchPage clickSearch() {
        WebElement button = Utility.Waits.waitForClickable(driver, searchButton);
        button.click();
        return this;
    }

    public P02_DomainSearchPage waitForResults() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            wait.until(driver -> {
                return driver.findElements(availableMsg).size() > 0 ||
                        driver.findElements(unavailableMsg).size() > 0;
            });

            System.out.println("Show search");

        } catch (TimeoutException e) {
            // debugging
            System.out.println("Page contant " + driver.getPageSource());
            Assert.fail("Don't Show on time ");
        }
        return this;
    }

    public boolean isDomainAvailable() {
        return driver.findElements(availableMsg).size() > 0;
    }


    public P02_DomainSearchPage verifyAvailable() {
        WebElement msg = driver.findElement(availableMsg);
        Assert.assertTrue(msg.isDisplayed());
        return this;
    }

    public P02_DomainSearchPage verifyUnavailable() {
        WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(),'unavailable') or contains(text(),'taken')]")));
        Assert.assertTrue(msg.isDisplayed());
        return this;
    }

    public P02_DomainSearchPage verifyPrice() {
        WebElement priceElement = driver.findElement(price);
        String priceText = priceElement.getText();
        Assert.assertTrue(priceText.contains("$"));
        return this;
    }

    public P02_DomainSearchPage takeScreenshot(String name) throws IOException {
        Utility.Screenshots.takeScreenshot(driver, name);
        return this;
    }

    public P02_DomainSearchPage addToCart() {
        WebElement button = Utility.Waits.waitForClickable(driver, addToCartBtn);
        button.click();
        return this;
    }

    public P02_DomainSearchPage goToCart() {
        WebElement button = Utility.Waits.waitForClickable(driver, viewCartBtn);
        button.click();
        return this;
    }
}