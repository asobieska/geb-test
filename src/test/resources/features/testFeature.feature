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

#Scenario3
  Scenario Outline: Log in - wrong email or password provided
    Given User is on olx.pl page
    And He is clicks on the Moj OLX
    When He fill email "<email>" wrong and password "<password>" good
    And He fill email "<email>" good and password "<password>" wrong
    And Clicks on the Zaloguj sie button
    Then He is receive a message "<message>" for field "<field>"
    And He is not logged in

  Examples: Variations of invalid login data
  | email                | password        | message                       |field       |
  | wrongemail           | mnb098          | Niepoprawny format e-mail     |email       |
  | olx_test@op.pl       | wrongpassword   | nieprawidłowy login lub hasło |password    |

#Scenario4
  Scenario: Log in and remember the User
    Given User is on olx.pl page
    And He is clicks on the Moj OLX
    When He fill email "olx_test@op.pl" and password "mnb098"
    And Click on radio button to remember the user
    And Clicks on the Zaloguj sie button
    Then He check you are logged
