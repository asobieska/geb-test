#F2 - TBA38 - Search
Feature: First use for a search bar
  Predictive search for a search bar
  Change main categories if your position is subcategories
  Categories selection
  Result view - change on view galeria, duze zdjecia and lista
  Result view - change on navigate Prywatne, Firma and Wszystkie
  Result view - change on sort Najtańsze
  Result view - change on sort Najdroższe

#Scenario1
  Scenario: First use for a search bar
    Given User is on olx.pl page
    When He write "moda" in a search bar
    And He write "Gdynia" in a country
    And He clics on the Szukaj
    Then He check result Moda w Gdynia

#Scenario1a
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

#Scenario2 - TBA43 not implement yet
  @nowy
  Scenario: Predictive search for a search bar
    Given User is on olx.pl page
    When He write only one letter "m" in a search bar
    And He looking for Mercedes in a search list
    Then He clics on the Szukaj
    And He check result on predictive search

#Scenario3 - TBA73
  Scenario: Change main categories if your position is subcategories
    Given User is on olx.pl page
    And He choose main category Motoryzacja
    And He see subcategories from Motoryzacja
    When He change main categories and choose main categories Praca in the left site
    Then He see new subcategories from Praca

#Scenario4 - TBA68 not implement yet
  Scenario: Categories selection
    Given User is on olx.pl page
    When He should see the main page category
    |category           |
    |Motoryzacja        |
    |Nieruchomości      |
    |Praca              |
    And He choose main category
    Then He see subcategories in main category
    |subcategory        |
    |Samochody osobowe  |
    |Mieszkania         |
    |Biurowa            |

#Scenario5 - TBA48
  Scenario: Result view - change on view galeria, duze zdjecia and lista
    Given User is on olx.pl page
    And He write "moda" in a search bar
    And He write "Gdynia" in a country
    And He clics on the Szukaj
    When He change view on galeria
    And He change view on duze zdjecia
    Then He change view on lista

#Scenario6 - TBA48
  Scenario: Result view - change on navigate Prywatne, Firma and Wszystkie
    Given User is on olx.pl page
    And He write "moda" in a search bar
    And He write "Gdynia" in a country
    And He clics on the Szukaj
    When He change navigate on the Prywatne
    And He change navigate on the Firma
    Then He change navigate is on Wszystkie

#Scenario7 - TBA48
  Scenario: Result view - change on sort Najtańsze
    Given User is on olx.pl page
    And He write "moda" in a search bar
    And He write "Gdynia" in a country
    And He clics on the Szukaj
    When He change sort on the Najtańsze
    Then He check result Moda w Gdynia

#Scenario8 - TBA48
  Scenario: Result view - change on sort Najdrozsze
    Given User is on olx.pl page
    And He write "moda" in a search bar
    And He write "Gdynia" in a country
    And He clics on the Szukaj
    When He change sort on the Najdroższe
    Then He check result Moda w Gdynia



