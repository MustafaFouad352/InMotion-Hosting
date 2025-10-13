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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    private final By availableMsg = By.xpath("(//div/div/div[2]/div)");
    private final By price = By.xpath("(//div[2]/div[1]/div)[2]");
    private final By addToCartBtn = By.xpath("(//div[2]/div[2])[3]");
    private  final By NewHostingSelet = By.id("mat-input-0");
    private  final By CLICKNewHostingSelet = By.xpath("(//div/div[2]/central-progress-button/button/span[1])[1]");
    private final By unavailableMsg = By.xpath("(//div[2]/div[2]/button/span[1])[1]");



    public P02_DomainSearchPage VerifyAvailable() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(availableMsg));
        Assert.assertTrue(msg.isDisplayed());
        return this;
    }
    public P02_DomainSearchPage VerifyUnAvailable() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(unavailableMsg));
        Assert.assertTrue(msg.isDisplayed());
        return this;
    }


    public P02_DomainSearchPage verifyPrice() {
        WebElement priceElement = driver.findElement(price);
        String priceText = priceElement.getText().trim();
        Assert.assertTrue(priceText.contains("$"), " Expected price to contain '$', but found: ");
        return this;
    }


    public P02_DomainSearchPage addToCart() {
        WebElement button = Utility.Waits.waitForClickable(driver, addToCartBtn);
        button.click();
        Utility.Waits.waitForVisibility(driver, By.xpath("(//div/div/div[2]/div[2])[39]"));
        return this;
    }


    public P02_DomainSearchPage goToCart() {
        new P01_HomePage(driver).Cart();
        return this;
    }
    public P02_DomainSearchPage selectPurchaseNewHosting() {
        WebElement radio = wait.until(ExpectedConditions.elementToBeClickable(NewHostingSelet));
        radio.sendKeys("myautomationtest123");
        WebElement Clickradio = wait.until(ExpectedConditions.elementToBeClickable(CLICKNewHostingSelet));
        Clickradio.click();
        WebElement button = Utility.Waits.waitForClickable(driver, addToCartBtn);
        button.click();
        Utility.Waits.waitForVisibility(driver, By.xpath("(//div/div/div[2]/div[2])[39]"));
        return this;
     }

}