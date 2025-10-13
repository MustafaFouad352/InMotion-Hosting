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
     // Locators
    private final By Pagetitle = By.xpath("//div/div[1]/div/div/div[1]/h2");
    private final By domainSearchField = By.id("domain_search_domain");
    private final By domainSearchButton = By.id("domain_submit");
    private final By AllHosting = By.id("allHostingDropDown");
    private final By SharedHosting = By.xpath("(//div[1]/a/div/div/span[1])[3]");
    private final By linkHome = By.xpath("(//div/div/div[1]/h2/a/img)[1]");
    private final By Carticon = By.xpath("//ul[1]/div/a");





    public P01_HomePage acceptCookies() {
        WebElement acceptButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
        acceptButton.click();
        wait.until(ExpectedConditions.invisibilityOf(acceptButton));
        return this;
    }
    public P01_HomePage waitForHomePageToLoad() {
        Utility.Waits.waitForVisibility(driver, Pagetitle);
        return this;
    }

    public P01_HomePage verifyPageTitle() {
        String actualTitle = driver.getTitle();
        assert actualTitle != null;
        Assert.assertTrue(actualTitle.contains("InMotion Hosting"),
                "Page title should contain 'InMotion Hosting'");
        return this;
    }



    public P01_HomePage verifyTopMenuItems() {

            String pageContent = driver.getPageSource();

        assert pageContent != null;
        Assert.assertTrue(pageContent.contains("VPS Hosting") ,
                    "Notfonded");
            Assert.assertTrue(pageContent.contains("All Hosting") ,
                    "not founded AllHosting");
            Assert.assertTrue(pageContent.contains("Hosting for WordPress") ,
                    " not founded Hosting for WordPress ");
        Assert.assertTrue(pageContent.contains("Dedicated Servers") ,
                " Dedicated Servers ");

        return this;
    }

    /*
    public P01_HomePage HoverOnWebHosting() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(WebHosting));
        new Actions(driver).moveToElement(element).perform();
        return this;
    }
    */
    public P01_HomePage SearchDomain(String DomainName) {
      /*  try {

            WebElement domainsLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(),'Domains')]")));
            domainsLink.click();
        } catch (Exception e) {

            driver.get("https://www.inmotionhosting.com/domains/");
        }

        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
*/
        WebElement SearchField = wait.until(ExpectedConditions.elementToBeClickable(domainSearchField));
        WebElement SearchButton = wait.until(ExpectedConditions.elementToBeClickable(domainSearchButton));
        SearchField.click();
        SearchField.sendKeys(DomainName);
        SearchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tld0")));
        return this;
    }
    public P01_HomePage Cart() {
        WebElement HomeButton = wait.until(ExpectedConditions.elementToBeClickable(linkHome));
        HomeButton.click();
        WebElement CartButton=wait.until(ExpectedConditions.elementToBeClickable(Carticon));
        CartButton.click();
        wait.until(ExpectedConditions.urlContains("complete"));
        return this;
    }

    public P01_HomePage goToWebHosting() {
        WebElement AllHostingButton = wait.until(ExpectedConditions.elementToBeClickable(AllHosting));
        AllHostingButton.click();
        WebElement SharedHostingButton = wait.until(ExpectedConditions.elementToBeClickable(SharedHosting));
        SharedHostingButton.click();
        return this;
    }
}