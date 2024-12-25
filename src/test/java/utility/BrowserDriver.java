package utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserDriver {

    public static WebDriver driver;
    public BrowserDriver() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver");
        this.driver = new ChromeDriver();
    }
    public void close() {
        if(driver != null){
            driver.quit();
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
}
