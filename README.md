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
Copy code
git clone https://github.com/NaveenKumar1918/Fitpeo-TestSuite.

Navigate to the Project Directory: Open the project in Eclipse or your preferred IDE.
Ensure Dependencies Are Loaded: If you’re using Eclipse, Maven should automatically download all the necessary dependencies from the pom.xml. If not, right-click the project and select Maven > Update Project.
Verify WebDriver Location: The chromedriver file for Chrome version 131 is already included in the chromedriver folder. Make sure the path to this folder is correctly set in your tests if needed.
Run the Tests: The tests are configured in the fitpeo_test.xml TestNG suite file. To run the tests, follow these steps:
Right-click on fitpeo_test.xml.
Select Run As > TestNG Suite

Locate the Report Folder:
After running your tests, the Extent Reports folder should be generated within the project directory. This folder contains the test results in an HTML format.
