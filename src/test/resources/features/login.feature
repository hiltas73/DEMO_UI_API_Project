Feature: Successful Login

  Scenario: Verify login with google email
    Given user navigate to the url
    When user enters google email
    Then user should login to main page