Feature: Feature to DELETE user

  Scenario Outline: DELETE user and assert ResponseBody
    Given URL and ID are given "<url>" "<ID>"
    Then DELETE Endpoint is triggered
    And responseCode is validated for noContent statusCode
    
   Examples: 
     |url|ID|
     |https://reqres.in/api/users|322|
     |https://reqres.in/api/users|333|
     |https://reqres.in/api/users|12|
     |https://reqres.in/api/users|32|
     |https://reqres.in/api/users|45|