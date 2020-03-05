package com.EY.qa.runners;

import com.EY.qa.framework.SetupTestDriver;
import com.EY.qa.framework.WebApp;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.EY.qa.framework.SetupTestDriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import java.net.MalformedURLException;

/**
 * Created by Aruna on 08/07/19.
 */
@CucumberOptions(features = "src/main/resources/features/",
        plugin = {"pretty" ,
                "json:target/cucumber.json"},
        glue = "com.EY.qa.steps",
        tags ={},
        monochrome = true)


public class AllFeaturesRunner extends AbstractTestNGCucumberTests {

    //@AfterMethod
//    public void takeScreenshot(Method m, ITestContext ctx) throws IOException {
//        long epochTime = new Date().getTime();
//        FileUtils.moveFile(((TakesScreenshot) WebApp.getDriver()).getScreenshotAs(OutputType.FILE), new File("screenshot" + epochTime + m.getName() + ".png"));
//        System.out.println("wrote screenshot" + epochTime + ".png");
//    }

}
