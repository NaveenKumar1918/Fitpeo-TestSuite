package com.fitpeo.test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fitpeo.pages.HomePage;
import com.fitpeo.pages.RevenueCalculatorPage;

public class StartTestScript{
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	private final int updateValue1=820;
	private final int updateValue2=560;
	private final String homePageUrl ="https://www.fitpeo.com/";
	private final String reveniumCalculatorPageUrl = "https://www.fitpeo.com/revenue-calculator";
	private final String expectedTotalRecurringReimbursementPrice="$110700";
	
	@Test
	public void runTest() throws InterruptedException {
		browserSetup();
		setupExtentReport();
		navigateToFitPeoHomePage();
		navigateToRevenueCalculator();
		scrollDownToTheSlidersection();
		adjustSliderTargetValue(updateValue1);
		updateTheTextField(updateValue2);
		validateSliderValue(updateValue2);
		selectCPTCodes();
		validateTotalRecurringReimbursement();
		saveExtentReport();
		closeBrowser();
	}
	
	@SuppressWarnings("deprecation")
	public void browserSetup() {
		System.setProperty("webdriver.chrome.driver", "./chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void setupExtentReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentReport/testreport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test = extent.createTest("FitPeo_TestCases");
	}

	public String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = "./images/" + screenshotName + ".png";
			File finalDestination = new File(destination);
			// Copy the screenshot to the specified location
			FileHandler.copy(source, finalDestination);
			return finalDestination.getAbsolutePath();
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
			return null;
		}
	}

	public void navigateToFitPeoHomePage() {
		try {
			driver.get(homePageUrl);
			if(driver.getCurrentUrl().equals(homePageUrl)) {
				String screenshot = captureScreenshot(driver, "navigateToFitPeoHomePage");
				test.pass("Successfully navigated to FitPeo homepage.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}
			else {
				String screenshot = captureScreenshot(driver, "navigateToFitPeoHomePage");
				test.fail("It is not navigated to FitPeo homepage.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}
		} catch (Exception e) {
			String screenshot = captureScreenshot(driver, "navigateToFitPeoHomePage_Error");
			test.fail("Failed to navigate to FitPeo homepage. Error: " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		}
	}

	public void navigateToRevenueCalculator() {
		try {
			HomePage.clickNavBarRevenueCalculator(driver, test);
			if(driver.getCurrentUrl().equals(reveniumCalculatorPageUrl)) {
				String screenshot = captureScreenshot(driver, "navigateToRevenueCalculator");
				test.pass("Successfully navigated to the Revenue Calculator page.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}else {
				String screenshot = captureScreenshot(driver, "navigateToRevenueCalculator");
				test.pass("It is not navigated to the Revenue Calculator page.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}

		} catch (Exception e) {
			String screenshot = captureScreenshot(driver, "navigateToFitPeoHomePage_Error");
			test.fail("Failed to navigate to the Revenue Calculator page. Error: " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		}
	}

	public void scrollDownToTheSlidersection() {
		try {
			RevenueCalculatorPage.scrollToSliderViewPort(driver);
			test.info("Successfully scroll to slider view port in 'Revenue Calculator Page'");
			String screenshot = captureScreenshot(driver, "scrollDownToTheSlidersection");
			test.pass("Successfully scroll down to the silder section in  Revenue Calculator page.",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		} catch (Exception e) {
			String screenshot = captureScreenshot(driver, "scrollDownToTheSlidersection_Error");
			test.fail("Not successfully scroll down to the silder section in Revenue Calculator page.Error: "
					+ e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		}
	}

	public void adjustSliderTargetValue(int targetvalue) {
		try {
			if(RevenueCalculatorPage.adjustSliderToTargetValue(driver, test, targetvalue)) {
				String screenshot = captureScreenshot(driver, "adjustSliderTargetValue");
				test.pass(
						"Slider successfully adjusted to target value: "+ targetvalue + " on the Revenue Calculator page.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}else {
				String screenshot = captureScreenshot(driver, "adjustSliderTargetValue");
				test.fail(
						"Slider adjustment failed. Final value: "+ targetvalue + " on the Revenue Calculator page.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}			
		} catch (Exception e) {
			String screenshot = captureScreenshot(driver, "adjustSliderTargetValue_Error");
			test.fail("Unable to adjust slider to target value. Exception: "
					+ e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		}
	}

	public void updateTheTextField(int targetvalue) {
		try {
			RevenueCalculatorPage.enterValueTextFiled(driver, test, targetvalue);	
			if(RevenueCalculatorPage.sliderButtonValue(driver) == targetvalue) {
				String screenshot = captureScreenshot(driver, "updateTheTextField");
				test.pass(
						"Text field updated to "+targetvalue+" and the slider adjusted accordingly.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}else {
				System.out.println("the value "+RevenueCalculatorPage.getTextBoxValue(driver) + " "+ targetvalue
						+" "+ RevenueCalculatorPage.sliderButtonValue(driver)+" "+targetvalue);
				String screenshot = captureScreenshot(driver, "updateTheTextField");
				test.fail(
						": Text field updated to "+targetvalue+" but the slider did not adjust correctly.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}

		}catch (Exception e) {
			e.printStackTrace();
			String screenshot = captureScreenshot(driver, "updateTheTextField");
			test.fail("Unable to update text field or adjust the slider due to  Exception: "
					+ e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		}
	}
	public void validateSliderValue(int updateValue) {
		try {
			int currentvalue= RevenueCalculatorPage.sliderButtonValue(driver);
			if(currentvalue == updateValue) {
				String screenshot = captureScreenshot(driver, "validateSliderValue");
				test.pass(
						" The slider successfully updated its position to reflect the value "+updateValue+" entered in the text field.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}else {
				String screenshot = captureScreenshot(driver, "validateSliderValue");
				test.fail(
						"The slider failed to update its position for the entered value "+updateValue+" entered in the text field.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}
		}catch(Exception e) {
			String screenshot = captureScreenshot(driver, "validateSliderValue");
			test.fail(
					" An error occurred while validating the slider update functionality errorMessage:"+e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());

		}
	}
	public void selectCPTCodes() {
		try {
			RevenueCalculatorPage.enterValueTextFiled(driver, test, updateValue1);
			if(RevenueCalculatorPage.selectCPT99091CheckBox(driver, test)&&
					RevenueCalculatorPage.selectCPT99453CheckBox(driver, test)&&
					RevenueCalculatorPage.selectCPT99454CheckBox(driver, test)&&
					RevenueCalculatorPage.selectCPT99474CheckBox(driver, test)) {

				String screenshot = captureScreenshot(driver, "selectCPTCodes");
				test.pass(
						"All required CPT codes are selected as expected.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}else {
				String screenshot = captureScreenshot(driver, "selectCPTCodes");
				test.fail(
						"All required CPT codes are not selected as expected.",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			}
		}catch(Exception e) {
			String screenshot = captureScreenshot(driver, "selectCPTCodes	");
			test.fail(
					" An error occurred while selecting required CPT codes are not selected as expected. errorMessage:"+e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());

		}
	}
	public void validateTotalRecurringReimbursement() {
		try {
			String currentTotalRecurringReimbursementPrice = RevenueCalculatorPage.getTotalRecurringReimbursementPriceValue(driver,test);
			if(expectedTotalRecurringReimbursementPrice.equals(currentTotalRecurringReimbursementPrice)){
				String screenshot = captureScreenshot(driver, "validateTotalRecurringReimbursement");
				test.pass(
						"The header displays the correct value: " + currentTotalRecurringReimbursementPrice + 
						" as Expected Value: " + expectedTotalRecurringReimbursementPrice + ".",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());

			}
			else {
				String screenshot = captureScreenshot(driver, "validateTotalRecurringReimbursement");
				test.fail(
						"The header displays an incorrect value: " + currentTotalRecurringReimbursementPrice + 
						". Expected Value: " + expectedTotalRecurringReimbursementPrice + ".",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());

			}
		}catch(Exception e){
			String screenshot = captureScreenshot(driver, "validateTotalRecurringReimbursement");
			test.fail(
					"An error occurred during validation. Exception: " + e.getMessage() + ".",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());

		}
	}
	public void saveExtentReport() {
		try {
			if (extent != null) {
				extent.flush();
			}
		} catch (Exception e) {
			System.out.println("The extent report in null we can't save the report " + e.getMessage());
		}
	}

	public void closeBrowser() {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println("We can't close the browser " + e.getMessage());
		}

	}
}
