Feature: Log in - empty form

  Scenario: Log in and do not remember the User
    Given User is on olx.pl page
    And He is clicks on the Moj OLX
    When He fill email "olx_test@op.pl" and password "mnb098"
    And Clicks on the Zaloguj sie button
    Then He check you are logged
    And He click logged out
