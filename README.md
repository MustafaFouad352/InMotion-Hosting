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

| Issue | Solution |
|-------|----------|
| **Driver not found** | Install WebDriverManager: `mvn clean install` |
| **Element not found** | Increase wait time in WebDriverWait |
| **Tests fail randomly** | Add explicit waits, avoid implicit waits |
| **Maven dependency issues** | Run `mvn clean install -U` to force update |
| **Port already in use** | Kill existing browser processes |
| **Permission denied** | Run as administrator / use sudo |

### Debug Mode
```bash
# Run with verbose output
mvn test -X

# Run single test for debugging
mvn test -Dtest=TC01_HomePageTest#testHomePageLoad
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
