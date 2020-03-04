Feature: Validate the SOAP Service

  @soapService @cicd @service
  Scenario: User calls SOAP web service to Validate
    Given  that SOAP service is runnng at url  "http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL"
    Then the status SOAP code is 200