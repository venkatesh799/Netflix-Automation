package utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.time.Duration;

public class WebActions {
    private WebDriver driver;

    public WebActions(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        try {
            driver.get(url);
            driver.manage().window().maximize();
            System.out.println("Navigated to "+url);
        }
        catch (Exception e) {
            System.out.println("Error while navigating to "+url);
            e.printStackTrace();
        }
    }

    public void waitForElementVisible(String elementName) {
        String xpath = Locators.getXpath(elementName);  // Get the XPath from Locators
        if (!xpath.isEmpty()) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait for 10 seconds
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));  // Wait for visibility
                System.out.println("Element " + elementName + " is visible.");
            } catch (TimeoutException e) {
                throw new TimeoutException("Timed out waiting for element: " + elementName + " to be visible.");
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException("Element with XPath: " + xpath + " not found.");
            } catch (Exception e) {
                throw new RuntimeException("Error while waiting for element: " + elementName, e);
            }
        } else {
            throw new NoSuchElementException("No XPath found for: " + elementName);
        }
    }

    // Click on an element if it's clickable
    public void clickElement(String elementName) {
        String xpath = Locators.getXpath(elementName);  // Get the XPath from Locators
        if (!xpath.isEmpty()) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait for 10 seconds
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));  // Wait for the element to be clickable
                element.click();  // Click the element
                System.out.println("Clicked on element: " + elementName);
            } catch (TimeoutException e) {
                throw new TimeoutException("Timed out waiting for element: " + elementName + " to be clickable.");
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException("Element with XPath: " + xpath + " not found.");
            } catch (ElementNotInteractableException e) {
                throw new ElementNotInteractableException("Element: " + elementName + " is not visible.");
            } catch (Exception e) {
                throw new RuntimeException("Error while clicking on element: " + elementName, e);
            }
        } else {
            throw new NoSuchElementException("No XPath found for: " + elementName);
        }
    }

    public void clickIfVisible(String elementName) {
        String xpath = Locators.getXpath(elementName); // Get XPath for the element
        if (xpath.isEmpty()) {
            System.out.println("No XPath found for element: " + elementName); // Log if no XPath is found
            return;  // Do nothing if XPath is not found
        }

        try {
            // Wait for the element to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))); // Wait for visibility

            if (element != null && element.isDisplayed()) {
                element.click(); // Click the element if it is visible
                System.out.println("Clicked on element: " + elementName);
            } else {
                System.out.println("Element: " + elementName + " is not visible. Doing nothing.");
            }

        } catch (TimeoutException e) {
            // Log the timeout scenario but do not throw an exception
            System.out.println("Timed out waiting for the element: " + elementName + " to be visible.");
        } catch (NoSuchElementException e) {
            // Log the missing element scenario but do not throw an exception
            System.out.println("Element with XPath: " + xpath + " not found.");
        } catch (Exception e) {
            // Catch any other unexpected errors and log them
            System.out.println("Error while clicking on element: " + elementName);
            e.printStackTrace();
        }
    }
    public void hoverOnElement(String elementName) throws Exception {
        String xpath = Locators.getXpath(elementName);  // Get the XPath for the element
        if (xpath.isEmpty()) {
            throw new NoSuchElementException("No XPath found for element: " + elementName);  // Throw exception if XPath not found
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait for 10 seconds
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));  // Wait for the element to be visible

            if (element != null && element.isDisplayed()) {
                Actions actions = new Actions(driver);  // Create a new Actions object
                actions.moveToElement(element).perform();  // Hover over the element
                System.out.println("Hovered over element: " + elementName);
            } else {
                throw new ElementNotInteractableException("Element: " + elementName + " is not interactable.");
            }
        } catch (TimeoutException e) {
            throw new TimeoutException("Timed out waiting for the element: " + elementName + " to be visible.");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element with XPath: " + xpath + " not found.");
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException("Element: " + elementName + " is not interactable.");
        } catch (Exception e) {
            throw new Exception("Error while hovering over element: " + elementName, e);
        }
    }

    public boolean verifyElementDisplayed(String elementName) throws Exception {
        String xpath = Locators.getXpath(elementName);  // Get the XPath for the element
        if (xpath.isEmpty()) {
            throw new NoSuchElementException("No XPath found for element: " + elementName);  // Throw exception if XPath not found
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait for 10 seconds
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));  // Wait for the element to be visible

            if (element != null && element.isDisplayed()) {
                System.out.println("Element: " + elementName + " is displayed.");
                return true;
            } else {
                System.out.println("Element: " + elementName + " is not displayed.");
                return false;
            }
        } catch (TimeoutException e) {
            throw new TimeoutException("Timed out waiting for the element: " + elementName + " to be visible.");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element with XPath: " + xpath + " not found.");
        } catch (Exception e) {
            throw new Exception("Error while verifying if element is displayed: " + elementName, e);
        }
    }
    public void enterTextIntoField(String text, String elementName) throws Exception {
        String xpath = Locators.getXpath(elementName);  // Get the XPath for the field
        if (xpath.isEmpty()) {
            throw new NoSuchElementException("No XPath found for element: " + elementName);  // Throw exception if XPath not found
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait for 10 seconds
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));  // Wait for the field to be visible

            if (element != null && element.isDisplayed()) {
                element.clear();  // Clear the field before entering text
                element.sendKeys(text);  // Enter the specified text into the field
                System.out.println("Entered text: " + text + " into field: " + elementName);
            } else {
                throw new ElementNotInteractableException("Field: " + elementName + " is not interactable.");
            }
        } catch (TimeoutException e) {
            throw new TimeoutException("Timed out waiting for the field: " + elementName + " to be visible.");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element with XPath: " + xpath + " not found.");
        } catch (Exception e) {
            throw new Exception("Error while entering text into field: " + elementName, e);
        }
    }
}