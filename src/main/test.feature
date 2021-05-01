Feature: fetching User Details

 Scenario: testing the get call for User Details

  Given url 'https://loaclhost'
  When method GET
  Then status 200
