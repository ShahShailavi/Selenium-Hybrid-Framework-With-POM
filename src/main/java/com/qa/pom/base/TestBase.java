package com.qa.pom.base;

import com.qa.pom.util.TestUtil;
import com.qa.pom.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Properties property;
    public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase() {
        try {
            property = new Properties();
            FileInputStream fi = new FileInputStream("/Users/shailavishah/IdeaProjects/AutomationUsingHybridFramework/"
                    + "src/main/java/com/qa/pom/config/config.properties");
            property.load(fi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialization() {
        String browserName = property.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/shailavishah/IdeaProjects/AutomationUsingHybridFramework/"
                    + "src/Resource/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "executable");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.get(property.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);


    }
}
