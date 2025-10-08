package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Utility;

import java.time.Duration;
import java.util.List;

public class P04_HostingPage {
    WebDriver driver;
    WebDriverWait wait;

    public P04_HostingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    private final By powerPlanBtn = By.xpath("//*[contains(text(), 'Power')]//ancestor::div[1]//button | //*[contains(text(), 'Power')]/following::button[1]");
    private final By launchPlanBtn = By.xpath("//*[contains(text(), 'Launch')]//ancestor::div[1]//button | //*[contains(text(), 'Launch')]/following::button[1]");

    public P04_HostingPage waitForPageLoad() {
        wait.until(ExpectedConditions.urlContains("hosting"));
        return this;
    }

    public P04_HostingPage selectPowerPlan() {
        try {
            // ابحث عن أي زر Buy بالقرب من كلمة Power
            List<WebElement> buyButtons = driver.findElements(By.xpath("//button[contains(text(), 'Buy') or contains(text(), 'شراء')]"));

            for (WebElement button : buyButtons) {
                String surroundingText = button.findElement(By.xpath("./ancestor::div[1]")).getText();
                if (surroundingText.contains("Power")) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
                    Thread.sleep(1000);
                    button.click();
                    Thread.sleep(3000);
                    System.out.println("PowerDone");
                    return this;
                }
            }


            driver.get("https://www.inmotionhosting.com/web-hosting/power");

        } catch (Exception e) {
            System.out.println("otherpane Power");
            driver.get("https://www.inmotionhosting.com/web-hosting/power");
        }
        return this;
    }

    public P04_HostingPage selectLaunchPlan() {
        WebElement button = Utility.Waits.waitForClickable(driver, launchPlanBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
        return this;
    }

    public P04_HostingPage goToCart() {
        driver.get("https://www.inmotionhosting.com/cart");
        wait.until(ExpectedConditions.urlContains("cart"));
        return this;
    }
}