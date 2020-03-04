package com.EY.qa.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;

//public class SOAPStepDefinitions {
//
//    private Response response;
//    private ValidatableResponse json;
//    private RequestSpecification request;
//    int responseCode;
//
//    @Given("^that SOAP service is runnng at url  \"([^\"]*)\"$")
//    public void that_SOAP_service_is_runnng_at_url(String url) throws Throwable {
//        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//        int timeout =20000;
//        connection.setConnectTimeout(timeout);
//        connection.setReadTimeout(timeout);
//        connection.setRequestMethod("GET");
//         responseCode = connection.getResponseCode();
//    }
//
//
//    @Then("the status SOAP code is (\\d+)")
//    public void verify_status_code(int statusCode){
//
//        Assert.assertEquals(responseCode, statusCode);
//    }
//
//
//}
