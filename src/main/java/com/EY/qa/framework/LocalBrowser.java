package com.EY.qa.framework;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Properties;


/**
 * This class creates a static web browser instance that other classes/tests can use
 */
public class LocalBrowser {

    private static String browser;
    private static WebDriver driver;
    private static Properties props = ReadProperties.getProperties();

    public static WebDriver initializeDriver() {
        browser = props.getProperty("browser");
        if (browser == "firefox") {
            driver = new FirefoxDriver();
        } else if (browser == "chrome") {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser == "ie") {
            driver = new InternetExplorerDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver80.exe");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void open(String url) {
        driver.get(url);
    }

    public static void close() {
        driver.close();
    }
}
