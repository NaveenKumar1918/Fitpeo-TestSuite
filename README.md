FitPeo Automation Script

Overview:

The FitPeo Automation Script is a test automation project that validates the functionality of the FitPeo website. The script covers various use cases, including navigation and interaction with the Revenue Calculator page. The script uses Selenium WebDriver for browser automation and TestNG for running the tests.
This project includes detailed test reports generated using Extent Reports, and it captures screenshots for each test run, including passed, failed, and error scenarios.

Features:

1.Automates testing for the FitPeo website.
2.Validates key functionality, including the Revenue Calculator page.
3.Generates Extent Reports with test results and screenshots.
4.Uses Selenium WebDriver for browser automation.
5.Includes test automation framework powered by TestNG.
6.Uses Maven to handle dependencies and build the project.

Prerequisites:
Before running the automation tests, ensure that the following are set up on your system:
1. Browser:
Chrome browser version 131.
Ensure that your browser version matches the required version for compatibility with the WebDriver.
2. WebDriver:
ChromeDriver version 131 (matching the browser version).
The chromedriver is already included in the chromedriver folder in the project. Ensure the driver is accessible from the project directory.
3. Java:
JDK 8 or higher installed and properly configured on your system.
4. Build Tool:
Maven should be installed on your system. Maven is used to handle dependencies and build the project.
If you don't have Maven installed, you can download it from Maven's official website and follow the installation instructions.
5. IDE:
Eclipse (or any preferred IDE).
If using Eclipse, ensure Maven integration is enabled, which can be done by installing the Maven for Eclipse plugin if not already installed.
6. Extent Reports:
Extent Reports is used to generate detailed HTML reports for test results. It is included via Maven dependencies in the project.
7. TestNG:
TestNG is used to run the tests. It is also included via Maven dependencies.
Running the Tests
Clone the Repository: Clone the FitPeo Automation Script repository to your local machine.

bash
Copy code:
git clone https://github.com/NaveenKumar1918/Fitpeo-TestSuite.

 How to Run the Tests
1. Navigate to the Project Directory
Open your project in Eclipse or your preferred IDE. Make sure you have the project set up correctly in your workspace.
2. Ensure Dependencies Are Loaded
If you're using Eclipse, Maven should automatically download the necessary dependencies from your pom.xml file.
To verify, right-click the project in the Project Explorer and select Maven > Update Project. This will ensure all dependencies are downloaded and up-to-date.
3. Verify WebDriver Location
Ensure that the chromedriver for Chrome version 131 is included in the chromedriver folder within your project.
Verify that the path to this chromedriver is correctly referenced in your test scripts. If you're using Selenium, the System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); should point to the correct location.
4. Run the Tests
To run the FitPeo test automation script, follow these steps:

Locate the TestNG Suite File: Ensure that the fitpeo_test.xml TestNG suite file is in your project structure.

Right-click on the fitpeo_test.xml file in the Project Explorer.
Run As > TestNG Suite
This will trigger TestNG to execute all the test cases defined within the fitpeo_test.xml suite file.

5. Viewing the Report
Once the tests are executed, an Extent Report will be generated in the extent-reports/ folder within your project directory.
You can open the report.html file in any browser to view the detailed results of the test run, including pass/fail statuses, duration, and screenshots of the tests.

