Feature: Feature to validate a single user with GET

  Scenario Outline: Assert ID and first name of a user
    Given URL and ID are given "<url>" "<ID>"
    Then GET API is Triggered
    And Response is validated for success StatusCode
    And Firstname "<FirstName>" and ID "<ID>" is validated
    
   Examples: 
      | ID | url | FirstName|
      | 2   |  https://reqres.in/api/users |Janet|
      | 1   |  https://reqres.in/api/users |George|
      | 3   |  https://reqres.in/api/users |Emma|
      | 4   |  https://reqres.in/api/users |Eve|