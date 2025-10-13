package Testcases;

import Pages.P01_HomePage;
import Pages.P02_DomainSearchPage;
import org.testng.annotations.Test;
import static drivers.DriverHolder.getDriver;

public class TC02_DomainSearchTest extends Test_Base {

    @Test(priority = 3, description = "Verify domain search for available domain")
    public void testSearchAvailableAndAddDomain() {
        P01_HomePage homePage = new P01_HomePage(getDriver());
        P02_DomainSearchPage searchPage = new P02_DomainSearchPage(getDriver());

        homePage.acceptCookies()
                        .waitForHomePageToLoad()
                                .verifyPageTitle()
                .SearchDomain("myautomationtest123")
        ;

        searchPage.VerifyAvailable()
                .verifyPrice()
                .addToCart()
                .goToCart();
    }

 /*   @Test(priority = 2, description = "Verify domain search for unavailable domain")
    public void SestSearchUnavailableDomain() {
        P01_HomePage homePage = new P01_HomePage(getDriver());
        P02_DomainSearchPage searchPage = new P02_DomainSearchPage(getDriver());

        homePage.ClickOnDomains();

        searchPage.waitForPageLoad()
                .enterDomain("google.com")
                .clickSearch();
    }*/
}

