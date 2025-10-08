package Testcases;

import Pages.P01_HomePage;
import Pages.P02_DomainSearchPage;
import Pages.P03_CartPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static drivers.DriverHolder.getDriver;

public class TC03_CartManagementTest extends Test_Base {

    @Test(priority = 3, description = "Add domain to cart and verify")
    public void testAddDomainToCart() throws IOException {
        P01_HomePage homePage = new P01_HomePage(getDriver());
        P02_DomainSearchPage searchPage = new P02_DomainSearchPage(getDriver());
        P03_CartPage cartPage = new P03_CartPage(getDriver());

        homePage.acceptCookies()
                .ClickOnDomains();

        searchPage.waitForPageLoad()
                .enterDomain("myautomationtest123")
                .clickSearch()
                .waitForResults()
                .addToCart()
                .goToCart();

        cartPage.waitForPageLoad()
                .verifyDomainInCart("myautomationtest123")
                .verifyPriceInCart()
                .takeScreenshot("domain_in_cart");
    }

    @Test(priority = 4, description = "Verify cart persistence after refresh")
    public void testCartPersistence() {
        P03_CartPage cartPage = new P03_CartPage(getDriver());

        cartPage.refreshPage()
                .verifyDomainInCart("myautomationtest123")
                .verifyPriceInCart();
    }

    @Test(priority = 5, description = "Remove domain from cart")
    public void testRemoveDomainFromCart() throws IOException {
        P03_CartPage cartPage = new P03_CartPage(getDriver());

        cartPage.removeDomain()
                .verifyDomainRemoved("myautomationtest123")
                .takeScreenshot("domain_removed");
    }
}
