#F2 - TBA38 - Search
Feature: First use for a search bar
  Predictive search for a search bar
  Change main categories if your position is subcategories
  Categories selection

#Scenario1
  Scenario: First use for a search bar
    Given User is on olx.pl page
    When He write "moda" in a search bar
    And He write "Gdynia" in a country
    And He clics on the Szukaj
    Then He check result Moda w Gdynia

    #Scenario1a
  @nowy
  Scenario Outline: First use for a search bar
    Given User is on olx.pl page
    When He write what looking for "<value>" in a search bar
    And He write city "<city>" where you looking for
    And He clics on the Szukaj
    Then He check result:
  """
  <value> w <city>
  """
    Examples:
    |value    |city   |
    |moda     |Gdynia |
    |lampa    |Sopot  |

#Scenario2
  Scenario: Predictive search for a search bar
    Given User is on olx.pl page
    When He write only one letter "l" in a search bar
    And He looking for "lampa" in a search list
    Then He clics on the Szukaj
    And He check result on predictive search

#Scenario3 - TBA73
  Scenario: Change main categories if your position is subcategories
    Given User is on olx.pl page
    And He choose main category Motoryzacja
    And He see subcategories from Motoryzacja
    When He change main categories and choose main categories Praca in the left site
    Then He see new subcategories from Praca

#Scenario4 - TBA68

  Scenario: Categories selection
    Given User is on olx.pl page
    When He should see the main page category
    |category   |subcategory            |
    |Motoryzacja|Samochody osobowe      |
    |Motoryzacja|Motocykle i Skutery    |
    |Motoryzacja|Dostawcze i Ciężarowe  |
    And He choose main category Motoryzacja
    Then He see subcategories from Motoryzacja


