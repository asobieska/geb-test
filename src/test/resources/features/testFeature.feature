Feature: Log in and do not remember the User
  Log in - empty form
#Scenario1
  Scenario: Log in and do not remember the User
    Given User is on olx.pl page
    And He is clicks on the Moj OLX
    When He fill email "olx_test@op.pl" and password "mnb098"
    And Clicks on the Zaloguj sie button
    Then He check you are logged
#Scenario2
  Scenario: Log in - empty form
    Given User is on olx.pl page
    And He is clicks on the Moj OLX
    When Clicks on the Zaloguj sie button
    Then He is informed that he has to provide email and password
    And He is not logged in

