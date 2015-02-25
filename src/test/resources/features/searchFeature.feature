#F2 - TBA38 - Search
Feature: First use for a search bar
  Predictive search for a search bar
  Change main categories if your position is subcategories
  Categories selection


#Scenario1 working
  Scenario: First use for a search bar
    Given User is on olx.pl page
    When He write "moda" in a search bar
    And He write "Gdynia" in a city
    And He clicks on the Szukaj
    Then He check result Moda w Gdynia

#Scenario1a The same like above but other idea to implement scenario working
  Scenario Outline: First use for a search bar
    Given User is on olx.pl page
    When He write what looking for "<value>" in a search bar
    And He write city "<city>" where you looking for
    And He clicks on the Szukaj
    Then He check result:
  """
  <value> w <city>
  """
    Examples:
    |value    |city   |
    |moda     |Gdynia |
    |lampa    |Sopot  |

#Scenario2 - TBA43 working
  Scenario: Predictive search for a search bar
    Given User is on olx.pl page
    When He write only one letter "m" in a search bar
    And The list of hints is opened
    And  He choose "meble" on hints list
    And He clicks on the Szukaj
    Then He check phrase meble is on a result page

#Scenario3 - TBA73 working
  Scenario: Change main categories if your position is subcategories
    Given User is on olx.pl page
    And He choose main category "Motoryzacja"
    And He see subcategories "Samochody osobowe"
    When He change main categories and choose main categories "Praca" in the left site
    Then He see subcategories "Biurowa"

#Scenario5 - TBA48 working
  Scenario: Result view - change on view galeria, duze zdjecia and lista
    Given User is on olx.pl page
    And He write "moda" in a search bar
    And He write "Gdynia" in a city
    And He clicks on the Szukaj
    When He change view on galeria
    And He change view on duze zdjecia
    Then He change view on lista

#Scenario6 - TBA48 working
  Scenario: Result view - change on navigate Prywatne, Firma and Wszystkie
    Given User is on olx.pl page
    And He write "moda" in a search bar
    And He write "Gdynia" in a city
    And He clicks on the Szukaj
    When He change navigate on the Prywatne
    And He change navigate on the Firma
    Then He change navigate is on Wszystkie

#Scenario7 - TBA48 working
  Scenario: Result view - change on sort Najtańsze
    Given User is on olx.pl page
    And He write "moda" in a search bar
    And He write "Gdynia" in a city
    And He clicks on the Szukaj
    When He change sort on the Najtańsze
    Then He check result Moda w Gdynia

#Scenario8 - TBA48
  Scenario: Result view - change on sort Najdrozsze
    Given User is on olx.pl page
    And He write "moda" in a search bar
    And He write "Gdynia" in a city
    And He clicks on the Szukaj
    When He change sort on the Najdroższe
    Then He check result Moda w Gdynia

#Scenario9 - TBA63
  Scenario: Detailed search
    Given User is on olx.pl page
    And He write "pokoj" in a search bar
    And He write "Gdynia" in a city
    And He clicks on the Szukaj
    And He choose category "Nieruchomości" in a result page
    And He choose subcategory "Mieszkania" in a result page
    When He choose offer Tylko ze zdjeciem
    And He choose category Wynajem
    And He choose liczba pokoi: kawalerka
    Then He clicks on the search

#Scenario10 - TBA58 not implement yet
  @testing
  Scenario: Detailed search - results counter
    Given User is on olx.pl page
    And He write "alabaster" in a search bar
    And He write "Warszawa" in a city
    And He clicks on the Szukaj
    And He choose category "Dom i Ogrod" in a result page
    When He check counter result to navigate tabs wszystkie
    And He check counter of list category Dom i Ogrod
    Then He check empty result from category Praca










