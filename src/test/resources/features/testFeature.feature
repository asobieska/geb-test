#F1 - TBA28, 33, 53 - Log in by email, Forgotten password, Log in with facebook.
Feature: Log in and do not remember the User
  Log in - empty form
  Log in - wrong email or password provided
  Log in and remember the User

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
#Scenario5
  Scenario:Forgotten password
    Given User is on olx.pl page
    And He is clicks on the Moj OLX
    When He click on the Zapomniales hasła
    And He fill email "olx_test@op.pl" and nowe haslo "alama" and powtorz haslo "alama"
    And He click on the Zmien button
    Then password is change

