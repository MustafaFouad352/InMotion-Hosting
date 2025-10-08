package drivers;

import org.openqa.selenium.WebDriver;

public class DriverHolder {
    //webdriver define as threadlocal
    public static final ThreadLocal<WebDriver>driver=new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return driver.get();
    }
    public static void setDriver(WebDriver driver){
        DriverHolder.driver.set(driver);
    }
    public static void removeDriver() {
        driver.remove();
    }
}
