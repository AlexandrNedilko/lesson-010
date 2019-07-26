package secondhand;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import secondhand.utils.Config;
import secondhand.utils.DriverFactory;
import secondhand.utils.EnumDriverFactory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public WebDriver driver2;
    private final Properties config = Config.loadProperties("src/main/resources/test.properties");

    @Before
    public void setup(){
        System.out.println(config.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.driver", config.getProperty("chromedriver"));

       // driver = new ChromeDriver();
        driver = new DriverFactory().getDriver("CHROME");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseurl"));


/*
        System.setProperty("webdriver.chrome.driver", config.getProperty("firefoxdriver"));
        driver2 = EnumDriverFactory.FIREFOX.create(); // for example but do not have driver for FireFox
        driver2.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver2.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver2.manage().window().maximize();
        driver2.get(config.getProperty("baseurl"));*/
    }


    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        //TestHelper.sleep5Seconds();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}

