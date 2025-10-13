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

    public P03_CartPage waitForPageLoad() {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("checkout"),
                ExpectedConditions.titleContains("Order")));
        return this;
    }

    public P03_CartPage VerifyCart() {
        WebElement domains = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/payment-form/div/div[4]")));
        WebElement PriceCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div/div[2]/div[2]/span)[2]")));
        Assert.assertTrue(domains.getText().contains("myautomationtest123"), "Domain not found in cart!");
        Assert.assertTrue(PriceCart.getText().contains("$38.99"), "Price not matched!");
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[4]/td[3]/div/span[1]/mat-icon")));
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
}

          /*
          public P03_CartPage verifyOnlyHostingRemains() {
        List<WebElement> items = driver.findElements(cartItems);
        Assert.assertTrue(items.size() == 1);
        return this;    }*/
