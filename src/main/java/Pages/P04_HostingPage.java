package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_HostingPage {
    WebDriver driver;
    WebDriverWait wait;

    public P04_HostingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By SelectPowerPlanBtn = By.xpath(("(//div[2]/div[1]/div/div[3]/a)[1]"));

    public P04_HostingPage waitForPageLoad() {
        wait.until(ExpectedConditions.urlContains("shared-hosting"));
        return this;
    }

    public P02_DomainSearchPage ClickSelectPowerPlan() {
        WebElement SelectButton= wait.until(ExpectedConditions.elementToBeClickable(SelectPowerPlanBtn));
        SelectButton.click();
        wait.until(ExpectedConditions.urlContains("checkout"));
        wait.until(ExpectedConditions.titleContains("Secure Order Process"));


        /*
        try {
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
        }*/
        return new P02_DomainSearchPage(driver);

    }

  /*  public P04_HostingPage selectLaunchPlan() {
        WebElement button = Utility.Waits.waitForClickable(driver, launchPlanBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
        return this;
    }*/

    public P01_HomePage goToCart() {
       return new P01_HomePage(driver);
    }
}