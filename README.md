          InMotion Hosting Automation Project

📝 Project Description
Automated testing for InMotion Hosting website covering domain search, cart management, and hosting plan selection using Selenium WebDriver with Java.

🛠️ Tools & Technologies Used
•	Java 21
•	Selenium WebDriver 4.25.0
•	TestNG 7.11.0
•	Maven for dependency management
•	WebDriverManager 5.9.2 for browser driver management
•	IntelliJ IDEA as IDE

📁 Project Structure
src/
├── Pages/
│   ├── P01_HomePage.java          # Home page actions
│   ├── P02_DomainSearchPage.java  # Domain search functionality
│   ├── P03_CartPage.java          # Shopping cart operations
│   └── P04_HostingPage.java       # Hosting plan selection
├── Testcases/
│   ├── Test_Base.java             # Base test configuration
│   ├── TC01_DomainSearchTest.java # Domain search test scenarios
│   ├── TC02_CartManagementTest.java # Cart operations tests
│   └── TC03_HostingPlanTest.java  # Hosting plan tests
└── util/
└── Utility.java              

# Helper methods (Waits, Verifications, Screenshots)
✅ Test Scenarios Covered
1. Domain Search Tests
   •	Search for available domain
   •	Search for unavailable domain (negative test)
   •	Verify pricing display
2. Cart Management Tests
   •	Add domain to cart
   •	Verify cart items
   •	Cart persistence after page refresh
   •	Remove domain from cart
3. Hosting Plan Tests
   •	Add Power Plan to cart
   •	Update to Launch Plan
   •	Verify final cart with domain and hosting
   🚀 How to Run Tests
   Prerequisites
1.	Java JDK 21 installed
2.	Maven installed
3.	Chrome browser installed
      Steps to Execute
1.	Clone the repository
2.	Open project in IntelliJ IDEA
3.	Run Maven clean install:
4.	mvn clean install
5.	Run test suite:
6.	mvn test
      Run Individual Test
      Right-click on specific test class → Run
      📸 Screenshots
      Screenshots are automatically saved in screenshots/ folder:
      •	domain_search_result.png - Domain search results
      •	unavailable_domain_result.png - Unavailable domain message
      •	domain_in_cart.png - Domain added to cart
      •	domain_removed.png - After removing domain
      •	hosting_plan_in_cart.png - Hosting plan in cart
      •	updated_hosting_plan.png - Updated hosting plan
      •	final_cart_view.png - Final cart with all items
      🎯 Key Features
      •	Page Object Model (POM) design pattern
      •	Fluent interface with method chaining
      •	Explicit waits for stable execution
      •	Screenshot capture for verification
      •	Clean and maintainable code structure
      •	Comprehensive test coverage
      📊 Test Execution Order
      Tests run in priority order:
1.	Search available domain
2.	Search unavailable domain
3.	Add domain to cart
4.	Verify cart persistence
5.	Remove domain
6.	Add hosting plan
7.	Update hosting plan
8.	Final cart verification
      🔧 Configuration
      •	Default browser: Chrome
      •	Wait timeout: 30 seconds
      •	Base URL: https://www.inmotionhosting.com/
      📝 Notes
      •	Tests are independent and can run separately
      •	Cart state is maintained between related tests
      •	All assertions use TestNG Assert methods
      •	Error handling through explicit waits
      👤 Author
      Software QC Engineer - Automation Testing
      📅 Last Updated
      October 2025

