package com.EY.qa.steps;

import com.EY.qa.framework.WebApp;
import com.EY.qa.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Aruna on 08/07/19.
 */
public class TestSteps {
    //Cucumber test step definitions for Login Module.

    //Logging object
    private static final Logger log = LogManager.getLogger(TestSteps.class);
    private static WebDriver driver;
    private static WebApp webApp;
    private static LoginPage loginPage;


    @Given("^Browser is open$")
    public void main_page_is_loaded() throws Throwable {
        log.info("Given: Browser is open");

        webApp = WebApp.getInstance();
       // driver= setupTestDriver.getDriver();
    }

    @When("^I login into PetClinic$")
    public void i_login_into_the_webpage() throws Throwable {
        log.info("When: I login into PetClinic");
        loginPage = webApp.gotoLoginPage();
        loginPage.login();
    }

    @Then("^I am able to see the main page$")
    public void i_am_able_to_go_main_page() throws Throwable {
        log.info("Then: I am able to see the main page");
        loginPage.verifyMainPage();
    }

//    @Then("^exit the page$")
//    public void i_am_able_exit_page() throws Throwable {
//        log.info("Then: exit the page");
//        webApp.stopDriver();
//    }

    @Then("^Click on logout button$")
    public void i_am_able_logout_page() throws Throwable {
        log.info("Then: logout the page");
        //loginPage = webApp.gotoLoginPage();
        loginPage.logout();
    }

    @Then("^Click on Click Here Link$")
    public void i_am_able_ToDo_page() throws Throwable {
        log.info("Then: logout the page");
        //loginPage = webApp.gotoLoginPage();

    }

    @Then("^Click on Add a Todo Link$")
    public void click_on_Add_a_Todo_Link() throws Throwable {
        loginPage.addtodo();

    }


    @Then("^click on add link$")
    public void click_on_add_link() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Click on Delete Button$")
    public void click_on_Delete_Button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.delete();

    }

    @Then("^Click on EY Link$")
    public void click_on_EY_Button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.eyhome();

    }

    @Then("^Click on \"([^\"]*)\" Link$")
    public void click_on_Link(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
