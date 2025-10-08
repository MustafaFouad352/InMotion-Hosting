# 🚀 Automation Testing Project

## 📋 Project Overview
This project is an automation testing framework built using Selenium WebDriver with Python. It implements automated test cases for web application testing with a focus on maintainability, scalability, and clear reporting.

---

## 🛠️ Tools Used

### Core Technologies
- **Python 3.x** - Programming language
- **Selenium WebDriver** - Browser automation tool
- **pytest** - Testing framework
- **unittest** - Python's built-in testing framework

### Additional Libraries
- **webdriver-manager** - Automatic driver management
- **pytest-html** - HTML test reports generation
- **Allure** - Advanced test reporting (optional)
- **logging** - Test execution logging

### Browsers Supported
- Chrome/Chromium
- Firefox
- Edge
- Safari (macOS only)

---

## 📁 Project Structure

```
project/
├── tests/                  # Test cases directory
│   ├── test_login.py
│   └── test_checkout.py
├── pages/                  # Page Object Model classes
│   ├── base_page.py
│   └── login_page.py
├── utils/                  # Utility functions
│   ├── helpers.py
│   └── config.py
├── data/                   # Test data files
│   └── test_data.json
├── reports/                # Test execution reports
├── drivers/                # WebDriver executables
├── requirements.txt        # Project dependencies
├── pytest.ini             # pytest configuration
└── README.md              # Project documentation
```

---

## ⚙️ Installation & Setup

### Prerequisites
- Python 3.8 or higher installed
- pip (Python package manager)
- Internet connection for downloading dependencies

### Step 1: Clone the Repository
```bash
git clone <repository-url>
cd <project-directory>
```

### Step 2: Create Virtual Environment
```bash
# Create virtual environment
python -m venv venv

# Activate virtual environment
# On Windows:
venv\Scripts\activate

# On macOS/Linux:
source venv/bin/activate
```

### Step 3: Install Dependencies
```bash
pip install -r requirements.txt
```

### Step 4: Verify Installation
```bash
python --version
pip list
```

---

## 🚀 Steps to Execute Tests

### Running All Tests
```bash
# Run all tests with pytest
pytest

# Run with verbose output
pytest -v

# Run with detailed output
pytest -vv
```

### Running Specific Tests
```bash
# Run specific test file
pytest tests/test_login.py

# Run specific test function
pytest tests/test_login.py::test_valid_login

# Run tests by marker
pytest -m smoke
```

### Running with Different Browsers
```bash
# Chrome (default)
pytest --browser=chrome

# Firefox
pytest --browser=firefox

# Edge
pytest --browser=edge
```

### Generating Reports
```bash
# Generate HTML report
pytest --html=reports/report.html --self-contained-html

# Generate Allure report
pytest --alluredir=reports/allure
allure serve reports/allure
```

### Running in Headless Mode
```bash
pytest --headless=true
```

### Parallel Execution
```bash
# Install pytest-xdist first
pip install pytest-xdist

# Run tests in parallel (4 workers)
pytest -n 4
```

---

## 📊 Test Execution Options

| Command | Description |
|---------|-------------|
| `pytest` | Run all tests |
| `pytest -v` | Verbose mode |
| `pytest -s` | Show print statements |
| `pytest -x` | Stop on first failure |
| `pytest --maxfail=3` | Stop after 3 failures |
| `pytest -k "login"` | Run tests matching keyword |
| `pytest --markers` | List all markers |

---

## 🔧 Configuration

### pytest.ini Configuration
```ini
[pytest]
markers =
    smoke: Smoke test cases
    regression: Regression test cases
    sanity: Sanity test cases

addopts = -v --strict-markers
testpaths = tests
python_files = test_*.py
python_classes = Test*
python_functions = test_*
```

### Environment Variables
Create a `.env` file in the project root:
```
BASE_URL=https://example.com
BROWSER=chrome
HEADLESS=false
TIMEOUT=10
```

---

## 📝 Writing New Tests

### Example Test Structure
```python
import pytest
from pages.login_page import LoginPage

class TestLogin:
    
    @pytest.fixture(autouse=True)
    def setup(self, driver):
        self.login_page = LoginPage(driver)
    
    @pytest.mark.smoke
    def test_valid_login(self):
        """Test login with valid credentials"""
        self.login_page.enter_username("testuser")
        self.login_page.enter_password("password123")
        self.login_page.click_login()
        assert self.login_page.is_logged_in()
```

---

## 🐛 Troubleshooting

### Common Issues

**Issue: Driver not found**
```bash
# Solution: Install webdriver-manager
pip install webdriver-manager
```

**Issue: Element not found**
- Increase wait time in config
- Check element locators
- Verify page load completion

**Issue: Tests failing randomly**
- Add explicit waits
- Check for dynamic content
- Use WebDriverWait

---

## 📈 Best Practices

1. **Use Page Object Model (POM)** - Separate page logic from tests
2. **Add Explicit Waits** - Avoid using time.sleep()
3. **Use Meaningful Names** - Clear test and method names
4. **Keep Tests Independent** - Each test should run standalone
5. **Use Fixtures** - Setup and teardown properly
6. **Add Logging** - Track test execution flow
7. **Handle Exceptions** - Proper error handling
8. **Version Control** - Commit regularly with clear messages

---

## 📞 Support & Contact

For issues, questions, or contributions:
- Create an issue in the repository
- Contact: your-email@example.com
- Documentation: [Wiki Link]

---

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## 🙏 Acknowledgments

- Selenium WebDriver Documentation
- pytest Documentation
- Python Testing Best Practices

---

**Last Updated:** October 2025
