#F2 - TBA38 - Search
Feature: First use for a search bar
  Predictive search for a search bar
#Scenario1
  Scenario: : First use for a search bar
    Given User is on olx.pl page
    When He write "moda" in a search bar
    And He write "Gdynia" in a country
    And He clics on the Szukaj
    Then He check result

#Scenario2
  @nowy
  Scenario: : Predictive search for a search bar
    Given User is on olx.pl page
    When He write only one letter "l" in a search bar
    And He looking for "lampa" in a search list
    Then He clics on the Szukaj
    And He check result on predictive search

