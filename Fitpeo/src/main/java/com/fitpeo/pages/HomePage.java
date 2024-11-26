package com.fitpeo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.fitpeo.seleniumbase.SeleniumBase;


public class HomePage{


    // Locators for the navigation bar items
    public static By navBarHome = By.xpath("//div[text()='Home']");
    public static By navBarProviders = By.xpath("//div[text()='Providers']");
    public static By navBarChronicCare = By.xpath("//div[text()='Chronic Care']");
    public static By navBarMedicalKit = By.xpath("//div[text()='Medical Kit']");
    public static By navBarCptCodes = By.xpath("//div[text()='CPT Codes']");
    public static By navBarRevenueCalculator = By.xpath("//div[text()='Revenue Calculator']");
    public static By navBarDownloadButton = By.xpath("//div[text()='Download']");

    // Common method to find elements after waiting for visibility
    public static WebElement findingElements(WebDriver driver, By locator) {
        return SeleniumBase.returnElementAfterWaits(driver, locator, 30, SeleniumBase.WaitTypes.VISIBILITY_OF_ELEMENT);
    }

    // Method to click on 'Home' in the navigation bar
    public static void clickNavBarHome(WebDriver driver, ExtentTest test) {
        SeleniumBase.clickElement(driver,findingElements(driver, navBarHome));
        test.info("Clicked 'Home' in navigation bar");
    }

    // Method to click on 'Providers' in the navigation bar
    public static void clickNavBarProviders(WebDriver driver, ExtentTest test) {
        SeleniumBase.clickElement(driver,findingElements(driver, navBarProviders));
        test.info("Clicked 'Providers' in navigation bar");
    }

    // Method to click on 'Chronic Care' in the navigation bar
    public static void clickNavBarChronicCare(WebDriver driver, ExtentTest test) {
        SeleniumBase.clickElement(driver,findingElements(driver, navBarChronicCare));
        test.info("Clicked 'Chronic Care' in navigation bar");
    }

    // Method to click on 'Medical Kit' in the navigation bar
    public static void clickNavBarMedicalKit(WebDriver driver, ExtentTest test) {
        SeleniumBase.clickElement(driver,findingElements(driver, navBarMedicalKit));
        test.info("Clicked 'Medical Kit' in navigation bar");
    }

    // Method to click on 'CPT Codes' in the navigation bar
    public static void clickNavBarCptCodes(WebDriver driver, ExtentTest test) {
        SeleniumBase.clickElement(driver,findingElements(driver, navBarCptCodes));
        test.info("Clicked 'CPT Codes' in navigation bar");
    }

    // Method to click on 'Revenue Calculator' in the navigation bar
    public static void clickNavBarRevenueCalculator(WebDriver driver, ExtentTest test) {
        SeleniumBase.clickElement(driver,findingElements(driver, navBarRevenueCalculator));
        test.info("Clicked 'Revenue Calculator' in navigation bar");
    }

    // Method to click on 'Download' in the navigation bar
    public static void clickNavBarDownloadButton(WebDriver driver, ExtentTest test) {
        SeleniumBase.clickElement(driver,findingElements(driver, navBarDownloadButton));
        test.info("Clicked 'Download' in navigation bar");
    }

	
	


}
