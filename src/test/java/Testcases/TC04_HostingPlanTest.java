package Testcases;

import Pages.P01_HomePage;
import Pages.P02_DomainSearchPage;
import Pages.P03_CartPage;
import Pages.P04_HostingPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static drivers.DriverHolder.getDriver;

public class TC04_HostingPlanTest extends Test_Base {

    @Test(priority = 6, description = "Add hosting plan to cart")
    public void testAddHostingPlan() throws IOException {
        P01_HomePage homePage = new P01_HomePage(getDriver());
        P02_DomainSearchPage searchDomain =new P02_DomainSearchPage(getDriver());
        P04_HostingPage hostingPage = new P04_HostingPage(getDriver());
        P03_CartPage cartPage = new P03_CartPage(getDriver());

        homePage.goToWebHosting();

        hostingPage.waitForPageLoad()
                .selectPowerPlan()
                .goToCart();

        cartPage.waitForPageLoad()
                .verifyHostingPlanInCart("Power")
                .takeScreenshot("hosting_plan_in_cart");
    }

    @Test(priority = 7, description = "Update hosting plan")
    public void testUpdateHostingPlan() throws IOException {
        P01_HomePage homePage = new P01_HomePage(getDriver());
        P04_HostingPage hostingPage = new P04_HostingPage(getDriver());
        P03_CartPage cartPage = new P03_CartPage(getDriver());

        cartPage.removeDomain();

        homePage.goToWebHosting();

        hostingPage.waitForPageLoad()
                .selectPowerPlan()
                .goToCart();

        cartPage.waitForPageLoad()
                .verifyHostingPlanInCart("Launch")
                .takeScreenshot("updated_hosting_plan");
    }

    @Test(priority = 8, description = "Verify final cart content")
    public void testFinalCartVerification() throws IOException {
        P02_DomainSearchPage searchPage = new P02_DomainSearchPage(getDriver());
        P03_CartPage cartPage = new P03_CartPage(getDriver());
        P01_HomePage homePage = new P01_HomePage(getDriver());

        homePage.ClickOnDomains();

        searchPage.enterDomain("myautomationtest123")
                .clickSearch()
                .waitForResults()
                .addToCart()
                .goToCart();

        cartPage.verifyDomainInCart("myautomationtest123")
                .verifyHostingPlanInCart("Launch")
                .verifyPriceInCart()
                .takeScreenshot("final_cart_view");
    }
}