package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import utility.BrowserDriver;
import utility.Locators;
import utility.WebActions;

public class BrowserSteps {

    private BrowserDriver browserDriver;
    private WebActions webActions;

    @Before
    public void setUp() {
        browserDriver = new BrowserDriver();
        webActions = new WebActions(browserDriver.getDriver());  // Initialize WebActions with WebDriver

    }
    @After
    public void teardown() {
        System.out.println("Closing Browser...");
        if (browserDriver != null) {
            browserDriver.close();
        }
        System.out.println("Browser closed.");
    }
    @Given("I open chrome browser")
    public void open_chrome_browser() {
        //browserDriver = new BrowserDriver();
        if(browserDriver.getDriver() != null) {
            System.out.println("Chrome browser opened sucessfully");
        }
    }
    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        String actual_url = Locators.getXpath(url);
        if (!actual_url.isEmpty()) {
            webActions.navigateTo(actual_url);  // Use the navigateTo function
        }
        else {
            System.out.println("No url found "+actual_url);
        }
    }

    @When("I wait for element {string} to visible")
    public void i_wait_for_element_to_visible(String elementName) throws Exception {
        webActions.waitForElementVisible(elementName);  // Wait for the element to be visible
    }

    @Then("I click on {string} using xpath")
    public void i_click_on_element_using_xpath(String elementName) throws Exception {
        webActions.clickElement(elementName);  // Click on the element using XPath
    }

    @Then("I click on xpath {string} if visible only")
    public void i_click_on_element_if_visible_using_xpath(String elementName) throws Exception{
        webActions.clickIfVisible(elementName);  // Click on the element if it is visible
    }

    @Then("I hover on {string}")
    public void i_hover_on_element(String elementName) throws Exception {
        webActions.hoverOnElement(elementName);  // Call the hover method
    }

    @Then("I verify if {string} is displayed")
    public void i_verify_if_element_is_displayed(String elementName) throws Exception {
        boolean isDisplayed = webActions.verifyElementDisplayed(elementName);  // Call the verifyElementDisplayed method
        if (!isDisplayed) {
            throw new AssertionError("Element " + elementName + " is not displayed.");
        }
    }
    @Then("I enter {string} into field {string}")
    public void i_enter_text(String text, String elementName) throws Exception {
       webActions.enterTextIntoField(text, elementName);  // Call the verifyElementDisplayed method
    }
}