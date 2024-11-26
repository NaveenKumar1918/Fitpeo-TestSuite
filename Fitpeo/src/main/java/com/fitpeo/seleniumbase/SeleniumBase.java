package com.fitpeo.seleniumbase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumBase {
	
    // Enum for wait types
    public static enum WaitTypes {
        ELEMENT_TO_BE_VISIBLE,
        ELEMENT_TO_BE_CLICKABLE,
        ELEMENT_TO_BE_PRESENT,
        ELEMENT_TO_BE_SELECTED,
        VISIBILITY_OF_ELEMENT
    }

    /**
     * Handles different wait types using a switch case and returns the WebElement.
     *
     * @param driver           The WebDriver instance.
     * @param locator          The locator of the element.
     * @param timeoutInSeconds The time in seconds to wait.
     * @param waitType         The type of wait to perform (specified using the WaitType enum).
     * @return 
     * @return The WebElement that satisfies the wait condition.
     */
    public static WebElement returnElementAfterWaits(WebDriver driver, By locator, int timeoutInSeconds, WaitTypes waitType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        WebElement element;

        switch (waitType) {
            case VISIBILITY_OF_ELEMENT:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                return element;

            case ELEMENT_TO_BE_CLICKABLE:
                element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                return element;

            case ELEMENT_TO_BE_PRESENT:
                element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                return element;

            case ELEMENT_TO_BE_SELECTED:
                wait.until(ExpectedConditions.elementToBeSelected(locator));
                return driver.findElement(locator); // Return element after it's selected

            default:
                throw new UnsupportedOperationException("Unsupported wait type: " + waitType);
        }
    }
    /**
     * Scrolls the page to bring the specified element into view using JavaScriptExecutor.
     *
     * @param driver  The WebDriver instance.
     * @param locator The locator of the element to scroll into view.
     */
    public static void scrollToElement(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.err.println("Error while scrolling to element: " + e.getMessage());
            throw e;
        }
    }
    
    // Common method to click on an element
    public static void clickElement(WebDriver driver, final By locator) {
    	Actions action = new Actions(driver);
    	WebElement ele=driver.findElement(locator);
    	action.click(ele).build().perform();;
    }

    public static void clickElement(WebDriver driver, final WebElement element) {
    	Actions action = new Actions(driver);
    	action.click(element).build().perform();;
    }

    // Common method to enter text in a text box
    public static void enterText(WebDriver driver, final By locator, final String text) {
        final WebElement element = driver.findElement(locator);
        element.click();
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(text);
    }

    public static void enterText(final WebElement element, final String text) {
    	element.click();
        element.clear();
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(text);
    }

    // Common method to get text from an element
    public static String getElementText(WebDriver driver, final By locator) {
        return driver.findElement(locator).getText();
    }

    public static String getElementText(final WebElement element) {
        return element.getText();
    }

    // Common method to verify if an element is displayed
    public static boolean isElementDisplayed(WebDriver driver, final By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public static boolean isElementDisplayed(final WebElement element) {
        return element.isDisplayed();
    }

    // Method to accept the alert (click OK)
    public static void acceptAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert(); // Switch to alert
        alert.accept(); // Accept the alert
        
    }

    // Method to dismiss the alert (click Cancel)
    public static void dismissAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert(); // Switch to alert
        alert.dismiss(); // Dismiss the alert
       
    }

    // Method to get the alert text
    public static String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert(); // Switch to alert
        return alert.getText(); // Get alert text
    }

    // Method sto refresh the current page
    public static void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    // Method to get the current URL's last segment
    public static String currentURL(WebDriver driver) {
        String urlString = driver.getCurrentUrl();
        return urlString;
    }

}

