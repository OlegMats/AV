Feature: AV login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given user is in 'Other' section
    When user is navigated to login form
    And user enters <email>, <password> and click on loginButton
    Then user is logged in

    Examples:
      | email                      | password     |
      | letmeshadowfiend@gmail.com | Oleg5969396! |
      | alex30121968@gmail.com     | Alex30121968 |
