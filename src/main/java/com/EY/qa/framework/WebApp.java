package com.EY.qa.framework;


import com.EY.qa.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.URL;

/**
 * Created by Aruna on 6/20/2016.
 */
public class WebApp {


    public static WebDriver driver =null;
    private static WebApp instance = null;
    private static final int timeout = 5;
    private static final String pageLoadedText = "Login with Username and Password";

    /* Logging variables */
    private static final Logger log = LogManager.getLogger(WebApp.class);

    /* Properties */
    private static Properties props = ReadProperties.getProperties();
    private static final String url = props.getProperty("url");
    private static final String username = props.getProperty("username");
    private static final String password = props.getProperty("password");
    private static boolean loggedIn = false;
     static String baseURL, nodeURL;

    /* Private constructor - only one instance possible for this class */
    private WebApp() {

        instance = this;
    }
    public static WebApp getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new WebApp();
            return instance;
        }
    }

    public static String getBaseUrl() {
        return url;
    }

    public static WebDriver initializeDriver() throws MalformedURLException {
        if (driver != null) {
         driver.quit();
            }
//        if (driver != null) {
//            return driver;
       // } else {
            nodeURL = System.getenv("SELENIUM_ADDRESS") != null ? System.getenv("SELENIUM_ADDRESS"):"http://localhost:4444" + "/wd/hub";
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            System.out.println("browser is set as " + System.getProperty("browser"));
            capability.setBrowserName(System.getProperty("browser"));
            ChromeOptions options = new ChromeOptions();
            //options.setExperimentalOption("useAutomationExtension", false);
            //capability.setPlatform(Platform.WIN10);
            capability.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new RemoteWebDriver(new URL(nodeURL), capability);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            // driver.manage().window().maximize();
            driver.get("http://127.0.0.1:3333/");
            loggedIn = false;
            return driver;

    }

    public static WebDriver getDriver()  throws MalformedURLException{
        if (driver == null) {
            SetupTestDriver SetupTestDriver = new SetupTestDriver();
            driver = SetupTestDriver.getDriver();
            //driver = initializeDriver();
        }
        return driver;
    }

    public static LoginPage gotoLoginPage() throws MalformedURLException {
        //driver = getDriver();
        driver = initializeDriver();
        driver.manage().deleteAllCookies();
        loggedIn = false;
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        verifyPageLoaded();
        return loginPage;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            loggedIn = false;
        }
    }

    public static void clicklogout() {
    }

    protected void finalize() throws Throwable {
        quitDriver();
        super.finalize();
    }

    public static void resetDriver()  throws MalformedURLException{
        driver = getDriver();
        driver.manage().deleteAllCookies();
        loggedIn = false;
        driver.get(url);
    }

    public static void verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return;
    }

    public static void stopDriver() {
        if (driver != null) {
            driver.close();
            //driver.quit();
            try {
                Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            driver = null;
        }
       // driver.quit();
        driver = null;

    }
}
