package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class P01_HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By Pagetitle = By.xpath("//div/nav/div/div[2]/a");
    private final By WebHosting = By.id("webHostingDropDown");
    private final By TopMenuItems = By.xpath("(//ul[1])[4]");
    private final By domainsMenu = By.xpath("//a[contains(text(),'Domains') or @id='domainsDropDown']");
    private final By domainSearchLink = By.xpath("//a[contains(text(),'Domain Name Search') or contains(@href,'domain-search')]");

    public P01_HomePage waitForHomePageToLoad() {
        Utility.Waits.waitForVisibility(driver, Pagetitle);
        return this;
    }

    public P01_HomePage verifyPageTitle() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("InMotion Hosting"),
                "Page title should contain 'InMotion Hosting'");
        return this;
    }

    public P01_HomePage acceptCookies() {
        try {
            WebElement acceptButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            acceptButton.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptButton));
        } catch (Exception ignored) {}
        return this;
    }

    public P01_HomePage verifyTopMenuItems() {

        try {
            // طريقة بسيطة للتحقق من وجود النصوص في الصفحة
            String pageContent = driver.getPageSource();

            Assert.assertTrue(pageContent.contains("Domains") || pageContent.contains("DOMAINS"),
                    "Notfonded");
            Assert.assertTrue(pageContent.contains("Hosting") || pageContent.contains("HOSTING"),
                    " اnot foundedHosting");
            Assert.assertTrue(pageContent.contains("WordPress") || pageContent.contains("WORDPRESS"),
                    " not foundedWordPress ");

            System.out.println(" Succesfuil");

        } catch (Exception e) {
            Assert.fail(" Faild" + e.getMessage());
        }
        return this;
    }

    public P01_HomePage HoverOnWebHosting() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(WebHosting));
        new Actions(driver).moveToElement(element).perform();
        return this;
    }

    public P01_HomePage ClickOnDomains() {
        try {

            WebElement domainsLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(),'Domains')]")));
            domainsLink.click();
        } catch (Exception e) {

            driver.get("https://www.inmotionhosting.com/domains/");
        }

        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

        return this;
    }
    public P01_HomePage goToWebHosting() {
        driver.get("https://www.inmotionhosting.com/web-hosting");
        wait.until(ExpectedConditions.urlContains("hosting"));
        return this;
    }
}