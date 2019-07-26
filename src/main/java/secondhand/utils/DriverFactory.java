package secondhand.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    //public static final WebDriver DEFAULT_FF = new ChromeDriver();

    public static WebDriver getDriver(String name) {
        WebDriver driver = null;
        if ("FIREFOX".equalsIgnoreCase(name)) {
            driver = new FirefoxDriver();
        } else if ("CHROME".equalsIgnoreCase(name)) {
            driver = new ChromeDriver();
        } else if ("IE".equalsIgnoreCase(name)) {
            driver = new InternetExplorerDriver();
        } else {
            //driver = DEFAULT_FF;
        }
        return driver;
    }
}