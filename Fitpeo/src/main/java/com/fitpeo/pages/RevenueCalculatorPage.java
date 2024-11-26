package com.fitpeo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import com.fitpeo.seleniumbase.SeleniumBase;

public class RevenueCalculatorPage {

	//locator
	public static By sliderView = By.cssSelector("div.MuiGrid-root.MuiGrid-container");
	public static By sliderButton = By.xpath("//input[@aria-orientation='horizontal']");
	public static By textBox = By.cssSelector(".MuiInputBase-input");
	public static By checkBoxCPT99091 = By.xpath("//div[p[text()='CPT-99091']]//input[@type='checkbox']");
	public static By checkBoxCPT99453= By.xpath("//div[p[text()='CPT-99453']]//input[@type='checkbox']");
	public static By checkBoxCPT99454= By.xpath("//div[p[text()='CPT-99454']]//input[@type='checkbox']");
	public static By checkBoxCPT99474= By.xpath("//div[p[text()='CPT-99474']]//input[@type='checkbox']"); 
	public static By totalRecurringReimbursementPrice = By.xpath("(//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-1lnu3ao']//p)[last()]");
	
	public static WebElement findingElements(WebDriver driver, By locator) {
		return SeleniumBase.returnElementAfterWaits(driver, locator, 30, SeleniumBase.WaitTypes.VISIBILITY_OF_ELEMENT);
	}
	
	public static void scrollToSliderViewPort(WebDriver driver) {
	    SeleniumBase.scrollToElement(driver, sliderView);
	}
	
	public static Integer getPositionOfSliderButton(WebDriver driver, ExtentTest test) {
	    Integer position = findingElements(driver, sliderButton).getLocation().getX();
	    test.info("Slider button position: " + position);
	    return position;
	}

	public static Integer sliderButtonValue(WebDriver driver) {
	    return Integer.parseInt(findingElements(driver, sliderButton).getAttribute("value"));
	}

	public static Integer getTextBoxValue(WebDriver driver) {
	    return Integer.parseInt(findingElements(driver, textBox).getText());
	}

	public static boolean adjustSliderToTargetValue(WebDriver driver, ExtentTest test, int targetValue) {
	    WebElement element = findingElements(driver, sliderButton);
	    Actions action = new Actions(driver);
	    
	    test.info("Adjusting slider to target value: " + targetValue);

	    while(sliderButtonValue(driver) < targetValue) {
	        action.clickAndHold(element).moveByOffset(14, 0).build().perform();
	    }

	    if(sliderButtonValue(driver) > targetValue) {
	        while(sliderButtonValue(driver) > targetValue) {
	            element.sendKeys(Keys.ARROW_LEFT);
	        }
	    } else if(sliderButtonValue(driver) < targetValue) {
	        while(sliderButtonValue(driver) < targetValue) {
	            element.sendKeys(Keys.ARROW_RIGHT);
	        }
	    }
	    scrollToSliderViewPort(driver);
	    
	    if(sliderButtonValue(driver) == targetValue) {
	    	test.info("Successfuly Adjusted slider to target value: " + targetValue);
	        return true;
	    } else {
	    	test.info("It is not Adjusted slider to target value: " + targetValue);
	        return false;
	    }
	}

	public static void enterValueTextFiled(WebDriver driver, ExtentTest test, int targetValue) {
	    String value = Integer.toString(targetValue);
	    SeleniumBase.enterText(driver, textBox, value);
	    test.info("Entered value: " + targetValue + " into the text box.");
	}

	public static boolean selectCPT99091CheckBox(WebDriver driver, ExtentTest test) {
	    try {
	        SeleniumBase.clickElement(driver, checkBoxCPT99091);
	        test.pass("Successfully selected CPT-99091 checkbox.");
	        return true;
	    } catch(Exception e) {
	        test.fail("Failed to select CPT-99091 checkbox: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return false;
	}

	public static boolean selectCPT99453CheckBox(WebDriver driver, ExtentTest test) {
	    try {
	        SeleniumBase.clickElement(driver, checkBoxCPT99453);
	        test.pass("Successfully selected CPT-99453 checkbox.");
	        return true;
	    } catch(Exception e) {
	        test.fail("Failed to select CPT-99453 checkbox: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return false;
	}

	public static boolean selectCPT99454CheckBox(WebDriver driver, ExtentTest test) {
	    try {
	        SeleniumBase.clickElement(driver, checkBoxCPT99454);
	        test.pass("Successfully selected CPT-99454 checkbox.");
	        return true;
	    } catch(Exception e) {
	        test.fail("Failed to select CPT-99454 checkbox: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return false;
	}

	public static boolean selectCPT99474CheckBox(WebDriver driver, ExtentTest test) {
	    try {
	        SeleniumBase.clickElement(driver, checkBoxCPT99474);
	        test.pass("Successfully selected CPT-99474 checkbox.");
	        return true;
	    } catch(Exception e) {
	        test.fail("Failed to select CPT-99474 checkbox: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return false;
	}

	public static String getTotalRecurringReimbursementPriceValue(WebDriver driver, ExtentTest test) {
	    String priceValue = SeleniumBase.getElementText(findingElements(driver, totalRecurringReimbursementPrice));
	    test.info("Total Recurring Reimbursement Price: " + priceValue);
	    return priceValue;
	}

}



