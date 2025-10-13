package Testcases;

import Pages.P01_HomePage;
import org.testng.annotations.Test;
import static drivers.DriverHolder.getDriver;

public class TC01_HomePageTest extends Test_Base {

    @Test(priority = 1, description = "Verify home page loads correctly")
    public void testHomePageLoad() {
        P01_HomePage homePage = new P01_HomePage(getDriver());

        homePage.acceptCookies()
                .waitForHomePageToLoad()
                .verifyPageTitle()
                .verifyTopMenuItems();
    }



    @Test(priority = 2, description = "SearchDomains")
    public void SearchforaDomain() {
        P01_HomePage homePage = new P01_HomePage(getDriver());

        homePage.SearchDomain("myautomationtest123");

    }
}