# 🚀 InMotion Hosting - Automated Testing Project

## 📋 Project Overview
This project is a comprehensive automated testing framework for InMotion Hosting website. It implements end-to-end test scenarios including domain search, hosting plan selection, and cart management using Selenium WebDriver with Java and TestNG framework, following Page Object Model (POM) design pattern.

### 🎯 Test Coverage
- **Home Page Navigation** - Verify page loading and menu items
- **Domain Search** - Test domain availability checking
- **Cart Management** - Add/remove domains and verify persistence
- **Hosting Plans** - Select and manage hosting plans
- **End-to-End Flows** - Complete user journey testing

---

## 🛠️ Tools & Technologies Used

### Core Technologies
- **Java 11+** - Programming language
- **Selenium WebDriver 4.x** - Browser automation framework
- **TestNG** - Testing framework for test execution and reporting
- **Maven** - Dependency management and build tool

### Additional Libraries & Tools
- **WebDriverManager** - Automatic browser driver management
- **Apache POI** (Optional) - For Excel data-driven testing
- **ExtentReports/Allure** - Advanced HTML test reporting
- **Log4j/SLF4J** - Logging framework

### Design Patterns
- **Page Object Model (POM)** - Separates page logic from test logic
- **Fluent Interface Pattern** - Method chaining for readable tests
- **Singleton Pattern** - Driver management

### Browsers Supported
- ✅ Chrome/Chromium
- ✅ Firefox
- ✅ Edge
- ✅ Safari (macOS only)

---

## 📁 Project Structure

```
InMotion-Automation/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Pages/                      # Page Object Model classes
│   │       │   ├── P01_HomePage.java       # Home page actions
│   │       │   ├── P02_DomainSearchPage.java
│   │       │   ├── P03_CartPage.java
│   │       │   └── P04_HostingPage.java
│   │       │
│   │       ├── drivers/                    # WebDriver management
│   │       │   └── DriverHolder.java       # Driver singleton
│   │       │
│   │       └── util/                       # Utility classes
│   │           ├── Utility.java            # Helper methods
│   │           └── Screenshots.java        # Screenshot utilities
│   │
│   └── test/
│       └── java/
│           └── Testcases/                  # Test classes
│               ├── Test_Base.java          # Base test configuration
│               ├── TC01_HomePageTest.java
│               ├── TC02_DomainSearchTest.java
│               ├── TC03_CartManagementTest.java
│               └── TC04_HostingPlanTest.java
│
├── test-output/                            # TestNG reports
├── screenshots/                            # Test execution screenshots
├── logs/                                   # Execution logs
├── pom.xml                                 # Maven dependencies
├── testng.xml                              # TestNG suite configuration
└── README.md                               # Project documentation
```

---

## ⚙️ Installation & Setup

### Prerequisites
Ensure you have the following installed on your machine:
- ✅ **Java JDK 11 or higher** ([Download](https://www.oracle.com/java/technologies/downloads/))
- ✅ **Maven 3.6+** ([Download](https://maven.apache.org/download.cgi))
- ✅ **IDE** (IntelliJ IDEA / Eclipse / VS Code)
- ✅ **Git** (for cloning repository)

### Verify Installation
```bash
# Check Java version
java -version

# Check Maven version
mvn -version
```

---

## 📥 Step 1: Clone the Repository

```bash
# Clone the project
git clone <repository-url>

# Navigate to project directory
cd InMotion-Automation
```

---

## 📦 Step 2: Install Dependencies

```bash
# Download all Maven dependencies
mvn clean install

# Or just download dependencies without running tests
mvn clean install -DskipTests
```

This will download:
- Selenium WebDriver
- TestNG
- WebDriverManager
- All other required libraries

---

## 🔧 Step 3: Configure the Project

### Update `pom.xml` (if needed)
```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>
    
    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
    </dependency>
    
    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.6.2</version>
    </dependency>
</dependencies>
```

### Create/Update `testng.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="InMotion Hosting Test Suite">
    <test name="All Tests">
        <classes>
            <class name="Testcases.TC01_HomePageTest"/>
            <class name="Testcases.TC02_DomainSearchTest"/>
            <class name="Testcases.TC03_CartManagementTest"/>
            <class name="Testcases.TC04_HostingPlanTest"/>
        </classes>
    </test>
</suite>
```

---

## 🚀 Steps to Execute Tests

### Method 1: Run via Maven (Recommended)

```bash
# Run all tests
mvn clean test

# Run with specific TestNG suite
mvn clean test -DsuiteXmlFile=testng.xml

# Run with custom properties
mvn clean test -Dbrowser=chrome -Dheadless=false
```

### Method 2: Run via TestNG XML

```bash
# Right-click on testng.xml and select "Run"
# Or use command line:
mvn test -Dtestng.xml=testng.xml
```

### Method 3: Run via IDE

**IntelliJ IDEA:**
1. Right-click on `testng.xml` → Run
2. Or right-click on test class → Run
3. Or use the green play button next to @Test annotation

**Eclipse:**
1. Right-click on `testng.xml` → Run As → TestNG Suite
2. Or right-click on test class → Run As → TestNG Test

### Method 4: Run Specific Test Classes

```bash
# Run single test class
mvn test -Dtest=TC01_HomePageTest

# Run multiple test classes
mvn test -Dtest=TC01_HomePageTest,TC02_DomainSearchTest

# Run specific test method
mvn test -Dtest=TC01_HomePageTest#testHomePageLoad
```

### Method 5: Run with Different Browsers

```bash
# Chrome (default)
mvn test -Dbrowser=chrome

# Firefox
mvn test -Dbrowser=firefox

# Edge
mvn test -Dbrowser=edge

# Headless Chrome
mvn test -Dbrowser=chrome -Dheadless=true
```

---

## 📊 Test Execution Flow

### Test Suite Execution Order

```
1️⃣ TC01_HomePageTest
   ├── testHomePageLoad() - Verify home page loads
   └── testNavigateToWebHosting() - Navigate to hosting page

2️⃣ TC02_DomainSearchTest
   └── testSearchAvailableDomain() - Search for available domain

3️⃣ TC03_CartManagementTest
   ├── testAddDomainToCart() - Add domain to cart
   ├── testCartPersistence() - Verify cart after refresh
   └── testRemoveDomainFromCart() - Remove domain from cart

4️⃣ TC04_HostingPlanTest
   ├── testAddHostingPlan() - Add hosting plan to cart
   ├── testUpdateHostingPlan() - Update hosting plan
   └── testFinalCartVerification() - Verify final cart content
```

---

## 📝 Test Scenarios Explained

### 🏠 Home Page Tests (TC01)
- **Accept cookies** and verify page loads correctly
- **Verify page title** contains "InMotion Hosting"
- **Check top menu items** (Domains, Hosting, WordPress)
- **Navigate to different sections**

### 🔍 Domain Search Tests (TC02)
- **Hover on Web Hosting** menu
- **Click on Domains** section
- **Enter domain name** for search
- **Verify search results** appear

### 🛒 Cart Management Tests (TC03)
- **Add domain to cart** and verify it appears
- **Take screenshots** of cart state
- **Refresh page** and verify cart persistence
- **Remove items** from cart and verify removal

### 🖥️ Hosting Plan Tests (TC04)
- **Select Power hosting plan**
- **Navigate to cart** and verify plan added
- **Update to different plan** (Launch)
- **Verify final cart** with both domain and hosting

---

## 📸 Screenshots & Reports

### Screenshots Location
```
screenshots/
├── domain_in_cart.png
├── domain_removed.png
├── hosting_plan_in_cart.png
├── updated_hosting_plan.png
└── final_cart_view.png
```

### TestNG Reports
After execution, find reports at:
```
test-output/
├── index.html              # Main TestNG report
├── emailable-report.html   # Email-friendly report
└── testng-results.xml      # XML results
```

### Open Reports
```bash
# Windows
start test-output/index.html

# Mac
open test-output/index.html

# Linux
xdg-open test-output/index.html
```

---

## 🔍 Key Features

### 1️⃣ Fluent Interface Pattern
```java
homePage.acceptCookies()
        .waitForHomePageToLoad()
        .verifyPageTitle()
        .HoverOnWebHosting()
        .ClickOnDomains();
```

### 2️⃣ Explicit Waits
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOfElementLocated(element));
```

### 3️⃣ Smart Locators
```java
// Multiple fallback locators
By searchInput = By.xpath("//input[@type='search' or contains(@placeholder, 'domain')]");
```

### 4️⃣ Error Handling
```java
try {
    element.click();
} catch (Exception e) {
    driver.get("fallback-url");
}
```

### 5️⃣ Screenshot on Failure
Automatically captures screenshots when tests fail.

---

## 🐛 Troubleshooting

### Common Issues & Solutions

#### ❌ Issue 1: CDP Version Warning
```
WARNING: Unable to find CDP implementation matching 140
WARNING: Unable to find version of CDP to use for 140.0.7339.208
```

**Solution:**
```xml
<!-- Add to pom.xml -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-devtools-v140</artifactId>
    <version>4.25.0</version>
</dependency>
```

Or update Selenium to latest version:
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.26.0</version> <!-- Latest version -->
</dependency>
```

#### ❌ Issue 2: TimeoutException - Element Not Found
```
TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath
```

**Root Causes & Solutions:**

**A) Page Not Fully Loaded**
```java
// Add page load wait in Test_Base or before finding elements
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

// Wait for page ready state
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(webDriver -> ((JavascriptExecutor) webDriver)
    .executeScript("return document.readyState").equals("complete"));
```

**B) Element Locator is Incorrect**
```java
// Update in P01_HomePage.java
// OLD (might be wrong):
private final By Pagetitle = By.xpath("//div/nav/div/div[2]/a");

// TRY these alternatives:
private final By Pagetitle = By.cssSelector("nav a.logo");
private final By Pagetitle = By.xpath("//nav//a[contains(@class,'logo')]");
private final By Pagetitle = By.xpath("//a[@aria-label='InMotion Hosting']");

// Or use more flexible locator:
private final By Pagetitle = By.xpath("//nav//a | //header//a");
```

**C) Increase Wait Time**
```java
// In P01_HomePage constructor
public P01_HomePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Increase from 30 to 60
}
```

**D) Check if Element is in iFrame**
```java
// If element is inside iframe
driver.switchTo().frame("iframe-name-or-index");
WebElement element = driver.findElement(locator);
driver.switchTo().defaultContent(); // Switch back
```

**E) Handle Cookie Popup First**
```java
// Make sure acceptCookies() works properly
public P01_HomePage acceptCookies() {
    try {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement acceptButton = shortWait.until(
            ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))
        );
        acceptButton.click();
        Thread.sleep(1000); // Give time for popup to close
    } catch (Exception e) {
        System.out.println("Cookie popup not found or already accepted");
    }
    return this;
}
```

#### ❌ Issue 3: Random Test Failures

**Solution - Add Retry Logic:**
```java
// Create RetryAnalyzer.java
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}

// Use in test:
@Test(retryAnalyzer = RetryAnalyzer.class)
public void testHomePageLoad() {
    // test code
}
```

#### ❌ Issue 4: Browser Opens but Doesn't Navigate

**Solution:**
```java
// In Test_Base setup method
@BeforeMethod
public void setup() {
    WebDriverManager.chromedriver().setup();
    
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--disable-blink-features=AutomationControlled");
    options.addArguments("--disable-notifications");
    options.addArguments("--disable-popup-blocking");
    
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    
    driver.get("https://www.inmotionhosting.com/");
}
```

### Quick Fixes Summary

| Issue | Quick Fix |
|-------|-----------|
| **CDP Warning** | Update Selenium version or add CDP dependency |
| **Element Not Found** | Increase wait time, verify locator, check for iframes |
| **Page Load Timeout** | Add `pageLoadTimeout(60 seconds)` |
| **Random Failures** | Implement RetryAnalyzer |
| **Cookie Popup Blocking** | Ensure acceptCookies() runs first with proper wait |
| **Slow Internet** | Increase all timeout values |

### Debug Mode
```bash
# Run with verbose output
mvn test -X

# Run single test for debugging
mvn test -Dtest=TC01_HomePageTest#testHomePageLoad

# Run with custom timeout
mvn test -Dtimeout=60

# Enable Selenium logging
mvn test -Dselenium.logger.level=FINE
```

### Recommended Utility Method Updates

Add to `Utility.java`:
```java
public static void waitForPageLoad(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    wait.until(webDriver -> 
        ((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState")
            .equals("complete")
    );
}

public static WebElement waitForElementWithMultipleLocators(WebDriver driver, By... locators) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    for (By locator : locators) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            continue;
        }
    }
    throw new NoSuchElementException("Element not found with any provided locator");
}
```

---

## 🔧 Quick Fixes for Current Issues

### Fix 1: Update Locator in P01_HomePage.java
```java
// Replace the Pagetitle locator with more reliable one
private final By Pagetitle = By.xpath("//nav//a | //header//img | //a[contains(@href,'inmotionhosting')]");

// Update waitForHomePageToLoad method
public P01_HomePage waitForHomePageToLoad() {
    // Wait for page to fully load
    new WebDriverWait(driver, Duration.ofSeconds(60))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState").equals("complete"));
    
    // Wait for navigation to be visible
    wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("nav")));
    
    return this;
}
```

### Fix 2: Update Test_Base.java Setup
```java
@BeforeMethod
public void setup() {
    WebDriverManager.chromedriver().setup();
    
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--disable-blink-features=AutomationControlled");
    options.addArguments("--remote-allow-origins=*");
    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
    
    driver = new ChromeDriver(options);
    DriverHolder.setDriver(driver);
    
    // Set timeouts
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
    
    // Navigate to website
    driver.get("https://www.inmotionhosting.com/");
    
    // Wait for full page load
    new WebDriverWait(driver, Duration.ofSeconds(60))
        .until(d -> ((JavascriptExecutor) d)
            .executeScript("return document.readyState").equals("complete"));
}
```

### Fix 3: Update pom.xml Dependencies
```xml
<dependencies>
    <!-- Selenium WebDriver - Latest -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.26.0</version>
    </dependency>
    
    <!-- WebDriverManager - Latest -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.9.2</version>
    </dependency>
    
    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.10.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Fix 4: Alternative Approach - Use CSS Selectors
```java
// More stable locators in P01_HomePage.java
private final By navigation = By.cssSelector("nav, header");
private final By logo = By.cssSelector("a[href*='inmotionhosting'], img[alt*='InMotion']");
private final By cookieButton = By.cssSelector("#onetrust-accept-btn-handler, [id*='cookie'] button");
```

### Fix 5: Enhanced Wait Utility
```java
// Add to Utility.java
public static class Waits {
    
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        // First wait for page load
        new WebDriverWait(driver, Duration.ofSeconds(60))
            .until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState").equals("complete"));
        
        // Then wait for element
        return new WebDriverWait(driver, Duration.ofSeconds(60))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static WebElement waitForClickable(WebDriver driver, By locator) {
        waitForVisibility(driver, locator);
        return new WebDriverWait(driver, Duration.ofSeconds(30))
            .until(ExpectedConditions.elementToBeClickable(locator));
    }
}
```

---

## ✅ Best Practices Implemented

1. ✅ **Page Object Model (POM)** - Separation of concerns
2. ✅ **Fluent Interface** - Readable test code
3. ✅ **Explicit Waits** - No Thread.sleep() usage
4. ✅ **Multiple Locators** - Fallback strategies
5. ✅ **Smart Element Handling** - JavaScript executors when needed
6. ✅ **Screenshot Capture** - Visual verification
7. ✅ **Proper Exception Handling** - Graceful failures
8. ✅ **Test Independence** - Each test runs standalone
9. ✅ **Clear Assertions** - Descriptive error messages
10. ✅ **Logging & Reporting** - Track execution flow

---

## 📈 Extending the Framework

### Adding New Test Cases
```java
@Test(priority = 9, description = "Your test description")
public void testNewFeature() {
    // Your test code here
}
```

### Adding New Page Objects
```java
public class P05_NewPage {
    WebDriver driver;
    WebDriverWait wait;
    
    public P05_NewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    
    // Add your page methods here
}
```

---

## 📞 Support & Maintenance

### Project Information
- **Website Under Test:** [InMotion Hosting](https://www.inmotionhosting.com/)
- **Framework Version:** 1.0
- **Last Updated:** October 2025

### For Issues or Questions
- Create an issue in the repository
- Review existing test documentation
- Check TestNG reports for detailed logs

---

## 🎓 Learning Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- [Maven Guide](https://maven.apache.org/guides/)
- [Page Object Model Pattern](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

---

## 📄 License

This project is created for educational and testing purposes.

---

**Happy Testing! 🚀**
