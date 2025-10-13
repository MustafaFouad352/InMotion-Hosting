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

        homePage.acceptCookies()
        .goToWebHosting();

        hostingPage.waitForPageLoad()
                .ClickSelectPowerPlan()
                .selectPurchaseNewHosting()
                .goToCart();

         cartPage.waitForPageLoad()
                 .refreshPage()
                 .verifyPriceInCart();




    }


    @Test(priority = 7, description = "Update hosting plan")
    public void testUpdateHostingPlan() throws IOException {
        P01_HomePage homePage = new P01_HomePage(getDriver());
        P04_HostingPage hostingPage = new P04_HostingPage(getDriver());
        P03_CartPage cartPage = new P03_CartPage(getDriver());

        cartPage.removeDomain()
                .takeScreenshot("updated_hosting_plan");
        homePage.goToWebHosting();

        hostingPage.waitForPageLoad()
                .goToCart();

      /*  cartPage.waitForPageLoad()
                .verifyHostingPlanInCart("Launch")
                .takeScreenshot("updated_hosting_plan");

       */
    }


    @Test(priority = 8, description = "Verify final cart content")
    public void testFinalCartVerification() throws IOException {
        P02_DomainSearchPage searchPage = new P02_DomainSearchPage(getDriver());
        P03_CartPage cartPage = new P03_CartPage(getDriver());
        P01_HomePage homePage = new P01_HomePage(getDriver());

        homePage.acceptCookies()
        .SearchDomain("myautomationtest123");
        searchPage.VerifyUnAvailable();



       /* searchPage.enterDomain("myautomationtest123")
                .clickSearch()
                .waitForResults()
                .addToCart()
                .goToCart();
*/
       /* cartPage.verifyDomainInCart("myautomationtest123")
                .verifyHostingPlanInCart("Launch")
                .verifyPriceInCart()
                .takeScreenshot("final_cart_view");
    }*/
        }
}