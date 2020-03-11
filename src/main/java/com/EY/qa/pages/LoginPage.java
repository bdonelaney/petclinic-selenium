package com.EY.qa.pages;

import com.EY.qa.framework.ReadProperties;
import com.EY.qa.framework.SetupTestDriver;
import com.EY.qa.framework.WebApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Aruna on 9/15/16.
 */
public class LoginPage {
    // Page Object for Login Page.
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    private static Map<String, String> data;
    private static WebDriver driver;
    private static int timeout = 5;

    /* Constructors */
    public LoginPage() {
    }

    public LoginPage(WebDriver aDriver) {
        this.driver = aDriver;
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage(WebDriver aDriver, Map<String, String> data) {
        this(aDriver);
        this.data = data;
    }

    public LoginPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }


    /**
     * Login with specified credentials.
     */
    public void login(String uname, String passwd) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elem = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
        elem.sendKeys(uname);

        elem = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
        elem.sendKeys(passwd);

        elem = driver.findElement(By.id("login"));
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
    }

    public void logout() {

    }


    /**
     * Login with configured credentials
     */
    public void login() {
        Properties props = ReadProperties.getProperties();
        String username = props.get("username").toString();
        String password = props.get("password").toString();
        login(username, password);
    }

    public boolean verifyMainPage() throws MalformedURLException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elem = driver.findElement(By.id("loggedInBanner"));
        wait.until(ExpectedConditions.visibilityOf(elem));
        return true;
    }

}
