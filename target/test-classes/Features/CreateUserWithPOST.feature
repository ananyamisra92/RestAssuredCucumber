Feature: Feature to create user using POST method

  Scenario Outline: Create user and assert the name via POST method 
    Given URL, NAME and JOB is given "<url>" "<name>" "<job>"
    Then POST Endpoint is triggered
    And responseCode is validated for created statusCode
    And Response Body is validated for Name "<name>" and job "<job>"
    
   Examples: 
     |url|name|job|
     |https://reqres.in/api/users|Thomas|QA|
     |https://reqres.in/api/users|Ananya|QA|
     |https://reqres.in/api/users|Abhilash|DEV|
     |https://reqres.in/api/users|Rahul|DevOps|