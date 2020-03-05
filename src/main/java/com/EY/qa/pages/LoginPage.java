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
    private static final String pageLoadedText = "Login with Username and Password";

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

    public LoginPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
        }
        return this;
    }

    @FindBy(name="username")
    WebElement username;

    @FindBy(id="login")
    WebElement loginBtn;

    @FindBy(xpath = "/html/body/nav/div[2]/ul[2]/li/a")
    WebElement logoutBtn;

    @FindBy(name="password")
    WebElement password;
    @FindBy(linkText="Click here")
    WebElement clickHere;
    @FindBy(className="btn btn-warning")
    WebElement delete;

    @FindBy(className="navbar-brand")
    WebElement eyhome;

    @FindBy(xpath = "/html/body/div/div/a")
    WebElement addtodo;

    /**
     * Login with specified credentials.
     */
    public void login(String uname, String passwd) {
        username.click();
        username.sendKeys(uname);
        //loginBtn.click();
        //verifyPageLoaded();

        password.click();
        password.sendKeys(passwd);
        loginBtn.click();
        //verifyPageLoaded();
    }

    public void logout() {
        logoutBtn.click();
        //verifyPageLoaded();
    }

    public void todo() {
        clickHere.click();
        //verifyPageLoaded();
    }
//	@FindBy(css="")
//	private WebElement webElement;
//	@FindBy(css="")
//	private WebElement webElement;

    /**
     * Login with configured credentials
     */
    public void login() {
        Properties props = ReadProperties.getProperties();
        String username = "admin";
        String password = "admin";
        login(username, password);
    }

    public boolean verifyMainPage() throws MalformedURLException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elem = driver.findElement(By.id("loggedInBanner"));
        wait.until(ExpectedConditions.visibilityOf(elem));
        return true;
    }

    public void delete() {
        delete.click();
    }

    public void eyhome() {
        eyhome.click();
    }

    public void addtodo() {
        addtodo.click();
    }
}
