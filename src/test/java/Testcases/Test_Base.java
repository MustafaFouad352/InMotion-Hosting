package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;
import static drivers.DriverHolder.removeDriver;

public class Test_Base {
    WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setupBrowser(@Optional("chrome") String browser) {
        setDriver(getNewInstance(browser));
        getDriver().get("https://www.inmotionhosting.com/");
    }

    @AfterTest
    public void tearDown() {
        getDriver().quit();
        removeDriver();
    }
}
