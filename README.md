# 📱 Appium Automation Framework

An advanced and scalable Appium automation framework built using **Java**, **TestNG**, **Page Object Model (POM)**, and **Extent Reports**. It supports **parallel execution on multiple real/emulated Android devices** and can be easily integrated with **Jenkins**, **BrowserStack**, and **Slack** for CI/CD and reporting.

---

## 📦 Tech Stack

- **Language**: Java
- **Automation Tool**: Appium
- **Test Framework**: TestNG
- **Design Pattern**: Page Object Model (POM)
- **Reporting**: Extent Reports
- **Parallel Execution**: TestNG XML + ThreadLocal driver
- **Build Tool**: Maven
- **Device Support**: Real Devices & Emulators
- **CI/CD**: Jenkins (optional)
- **Cloud Device Labs**: BrowserStack / Sauce Labs (optional)

---

## 📁 Project Structure
```
AppiumFramework/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/                 # Base classes (Driver setup, utilities)
│   │   │   ├── config/               # Config data (Device, environment)
│   │   │   ├── pages/                # POM: Page classes (LoginPage.java)
│   │   │   ├── locators/             # Element locator definitions
│   │   │   ├── utils/                # Helper utilities (Waits, Screenshots)
│   │   │   └── tests/                # Test classes (LoginTest.java)
│   │   └── resources/                # Config.properties, testdata
│
├── testng.xml                        # TestNG suite
├── pom.xml                           # Maven dependencies
└── README.md
```

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 8 or above
- Maven
- Node.js & Appium Server
- Android SDK
- At least one emulator or real Android device connected via ADB

---

### 📥 Setup Instructions

```
# 1. Clone the project
git clone git@github.com:anishgurudev/MobileAutomationProject.git

# 2. Navigate to project folder
cd AppiumAutomationFramework

# 3. Install dependencies
mvn clean install

🧪 Running the Tests

✅ Single Device
 mvn test -Dsurefire.suiteXmlFiles=testng.xml
       
✅ Parallel Execution on Multiple Devices
 Ensure testng.xml includes multiple <test> blocks with device-specific parameters:

<suite name="ParallelSuite" parallel="tests" thread-count="2">
  <test name="Device1">
    <parameter name="deviceName" value="emulator-5554"/>
    <parameter name="platformVersion" value="11"/>
    <parameter name="udid" value="emulator-5554"/>
    <classes><class name="tests.LoginTest"/></classes>
  </test>
  <test name="Device2">
    <parameter name="deviceName" value="emulator-5556"/>
    <parameter name="platformVersion" value="10"/>
    <parameter name="udid" value="emulator-5556"/>
    <classes><class name="tests.LoginTest"/></classes>
  </test>
</suite>

📊 Test Reports
After execution, the Extent Report will be available at: /test-output/ExtentReport.html
Open it in any browser to view detailed test logs, status, and failure reasons.

🔧 Customize & Extend
✅ Add new page classes in pages/
✅ Add locators in locators/
✅ Add reusable methods in utils/
✅ Add more devices in devices.json

## Author
**Anish Kumar**  |  Lead Software Test Engineer

For questions, raise an issue or connect on [9036371870](9036371870).

---

## Contributions
Pull requests are welcome. For major changes, please open an issue first.

---

## License
This project is licensed under the me.
