Feature: Testing Netflix Home page
  Scenario: Verifying Netflix Homepage
    Given I open chrome browser
    When I navigate to "NETFLIX"
    Then I verify if "NETFLIX_LOGO" is displayed
    Then I verify if "HOMEPAGE_GETSTARTED" is displayed

  Scenario: Verifying spanish language working or not
    Given I open chrome browser
    When I navigate to "NETFLIX"
    Then I verify if "NETFLIX_LOGO" is displayed
    Then I click on "LANGUAGE_DROPDOWN" using xpath
    Then I verify if "SPANISH_LANGUAGE" is displayed
    Then I click on "SPANISH_LANGUAGE" using xpath
    Then I verify if "SPANISH_SIGNIN_BUTTON" is displayed

  Scenario: Verifying language change from spanish to english
    Given I open chrome browser
    When I navigate to "NETFLIX"
    Then I verify if "NETFLIX_LOGO" is displayed
    Then I click on "LANGUAGE_DROPDOWN" using xpath
    Then I verify if "SPANISH_LANGUAGE" is displayed
    Then I click on "SPANISH_LANGUAGE" using xpath
    Then I verify if "SPANISH_SIGNIN_BUTTON" is displayed
    Then I click on "LANGUAGE_DROPDOWN" using xpath
    Then I verify if "ENGLISH_LANGUAGE" is displayed
    Then I click on "ENGLISH_LANGUAGE" using xpath
    Then I verify if "HOME_SIGN_IN" is displayed

  Scenario: Verifying global trending movies working or not
    Given I open chrome browser
    When I navigate to "NETFLIX"
    Then I verify if "NETFLIX_LOGO" is displayed
    Then I verify if "COUNTRY_DROP_DOWN" is displayed
    Then I click on "COUNTRY_DROP_DOWN" using xpath
    Then I click on "GLOBAL_OPTION" using xpath
    Then I click on "DROP_DOWN_MOVIES" using xpath
    Then I verify if "MOVIES_OTHER_LANGUAGE" is displayed
    Then I click on "DROP_DOWN_MOVIES" using xpath
    Then I verify if "TVSHOWS_OTHER_LANGUAGE" is displayed