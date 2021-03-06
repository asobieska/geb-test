#F1 - TBA28, 33, 53 - Log in by email, Forgotten password, Log in with facebook.
Feature: Log in and do not remember the User
  Log in - empty form
  Log in - wrong email or password provided
  Log in and remember the User
  Forgotten password
  Repeat password is incorrect
  Log in with facebook - wrong email and password provided

  Background:
    Given User is on olx.pl page
    And He is clicks on the Moj OLX

#Scenario1
  Scenario: Log in and do not remember the User
    When He fill email "olx_test@op.pl" and password "mnb098"
    And Clicks on the Zaloguj sie button
    Then He check you are logged

#Scenario2
  Scenario: Log in - empty form
    When Clicks on the Zaloguj sie button
    Then He is informed that he has to provide email and password
    And He is not logged in

#Scenario3
  Scenario Outline: Log in - wrong email or password provided
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
    When He fill email "olx_test@op.pl" and password "mnb098"
    And Click on radio button to remember the user
    And Clicks on the Zaloguj sie button
    Then He check you are logged

#Scenario5 - TBA33
  Scenario: Change password - forgotten password
    When He click on the Zapomniales hasła
    And He fill email "olx_test@op.pl" and nowe haslo "alama" and powtorz haslo "alama"
    And He click on the Zmien button
    Then Password is change

#Scenario6
  Scenario: Change password - repeat password is incorrect
    When He click on the Zapomniales hasła
    And He fill email "olx_test@op.pl" and nowe haslo "aaaa" and powtorz haslo "pppp"
    And He click on the Zmien button
    Then He is receive a message for field Powtorz haslo

#Scenario7 - TBA53
  Scenario: Log in with facebook - wrong email and password provided
    And He click on the facebook link
    When He check is on facebook page
    And He fill facebook email "olx_test@op.pl" and facebook password "mnb098"
    And He click on the Log In
    Then He is receive a message Incorrect Email