Feature: Feature to PUT user

  Scenario Outline: PUT user and assert UpdatedAt
    Given URL, ID, NAME and JOB is given "<url>" "<ID>" "<name>" "<job>"
    Then PUT Endpoint is triggered
    And responseCode is validated for success statusCode
    And Response Body is validated for UpdatedAt is not null
    
   Examples: 
     |url|ID|name|job|
     |https://reqres.in/api/users|2|Ananya|QA|
     |https://reqres.in/api/users|3|Neha|QA|
     |https://reqres.in/api/users|5|Abhilash|DEV|
     |https://reqres.in/api/users|45|Ananya|FA|