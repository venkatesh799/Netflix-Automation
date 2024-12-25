Feature: Testing Netflix Login page
  Scenario: Verifying netflix login page elements displayed or not
    Given I open chrome browser
    When I navigate to "NETFLIX"
    Then I verify if "NETFLIX_LOGO" is displayed
    Then I click on "HOME_SIGN_IN" using xpath
    Then I verify if "SIGNIN_BUTTON" is displayed
    Then I verify if "FORGOT_PASSWORD" is displayed

  Scenario: Verifying invalid password or email warning displayed or not
    Given I open chrome browser
    When I navigate to "NETFLIX"
    Then I verify if "NETFLIX_LOGO" is displayed
    Then I click on "HOME_SIGN_IN" using xpath
    Then I verify if "SIGNIN_BUTTON" is displayed
    Then I verify if "FORGOT_PASSWORD" is displayed
    Then I enter "Hello" into field "EMAIL_FIELD"
    Then I enter "1234" into field "INPUT_PASSWORD"
    Then I click on "SIGNIN_BUTTON" using xpath
    Then I verify if "INCORRECT_PASSWORD" is displayed

  Scenario: Verifying forgot password functionality
    Given I open chrome browser
    When I navigate to "NETFLIX"
    Then I verify if "NETFLIX_LOGO" is displayed
    Then I click on "HOME_SIGN_IN" using xpath
    Then I verify if "SIGNIN_BUTTON" is displayed
    Then I click on "FORGOT_PASSWORD" using xpath
    Then I verify if "FORGOT_PASSWORD_INPUT" is displayed
    Then I verify if "EMAIL_ME" is displayed
#    Then I click on "RESET_BY_TEXT" using xpath
#    Then I verify if "US_PHONE_ICON" is displayed
#    Then I verify if "FORGOT_PASSWORD_INPUT" is displayed
#    Then I verify if "TEXT_ME" is displayed
