package com.EY.qa.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SetupTestDriver {
    private WebDriver driver = null;
    private String browser = null;
    private String os = null;
    private String node = null;
    private String env = null;
    Properties props = null;

    public  SetupTestDriver() throws MalformedURLException {

        this.props = ReadProperties.getProperties();

        this.browser = System.getProperty("browser") != null ? System.getProperty("browser"):"chrome";
        this.os =  System.getProperty("os") != null ? System.getProperty("os"):"windows";
        this.node = System.getenv("SELENIUM_ADDRESS") != null ? System.getenv("SELENIUM_ADDRESS"):"http://localhost:4444";
        this.env= System.getProperty("env") != null ? System.getProperty("env"):"dev";

        if(System.getenv("SELENIUM_LOCAL").equalsIgnoreCase("true")) {
            LocalBrowser localBrowser = new LocalBrowser();
            this.driver = localBrowser.initializeDriver();
        } else {
            if(browser.equalsIgnoreCase("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                this.driver = new RemoteWebDriver(new URL(node + "/wd/hub"), chromeOptions);
            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                this.driver = new RemoteWebDriver(new URL(node + "/wd/hub"), options);
            } else {
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                this.driver = new RemoteWebDriver(new URL(node +"/wd/hub"), capability);
                this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
        }

        Platform platform = Platform.fromString(os.toUpperCase());


        this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();



    }

    public String getOs() {
        return this.os;
    }

    public String getBrowser() {
        return this.browser;
    }

    public String getNode() {
        return this.node;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
    public Properties getProps() {
        return this.props;
    }
}