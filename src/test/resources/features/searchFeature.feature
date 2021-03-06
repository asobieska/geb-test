#F2 - TBA38 - Search and category
Feature: First use for a search bar
  Predictive search for a search bar
  Change main categories if your position is subcategories
  Categories selection
  Result view - change on view galeria, duze zdjecia and lista
  Result view - change on navigate Prywatne, Firma and Wszystkie
  Result view - change on sort Najtańsze
  Result view - change on sort Najdroźsze
  Detailed search
  Results counter

  #Scenario5,6, 7, 8 TBA 48
  Background:
    Given User is on olx.pl page
    And He write "moda" in a search bar
    And He write "Gdynia" in a city
    And He clicks on the Szukaj

  Scenario: change on view galeria, duze zdjecia and lista
    When He change view on galeria
    And He change view on duze zdjecia
    Then He change view on lista
  @testing
  Scenario: change on navigate Prywatne, Firma and Wszystkie
    When He change navigate on the "Prywatne"
    And He change navigate on "Firma"
    Then He change navigate is on "Wszystkie"

  Scenario: change on sort Najtańsze
    When He change sort on the Najtańsze
    Then He check result Moda w Gdynia

  Scenario: change on sort Najdrozsze
    When He change sort on the Najdroższe
    Then He check result Moda w Gdynia


#Scenario1
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

#Scenario2 - TBA43
  Scenario: Predictive search for a search bar
    Given User is on olx.pl page
    When He write only one letter "m" in a search bar
    And The list of hints is opened
    And  He choose "meble" on hints list
    And He clicks on the Szukaj
    Then He check phrase meble is on a result page

#Scenario3 - TBA73
  Scenario: Change main categories if your position is subcategories
    Given User is on olx.pl page
    And He choose main category "Motoryzacja"
    And He see subcategories "Samochody osobowe"
    When He change main categories and choose main categories "Praca" in the left site
    Then He see subcategories "Biurowa"

#Scenario4
  Scenario Outline: Categories selection
    Given User is on olx.pl page
    When He choose main category "<category>"
    Then He see subcategories "<subcategory>"

    Examples:
    |category       |subcategory        |
    |Motoryzacja    |Samochody osobowe  |
    |Nieruchomości  |Mieszkania         |
    |Praca          |Biurowa            |
    |Dom i Ogród    |Meble              |
    |Elektronika    |Telefony komórkowe |
    |Moda           |Ubrania            |
    |Rolnictwo      |Ciągniki           |
    |Zwierzęta      |Psy                |
    |Dla Dzieci     |Zabawki            |
    |Sport i Hobby  |Kolekcje           |


#Scenario9 - TBA63
  Scenario: Detailed search, he cheek other options in a result page
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

#Scenario10 - TBA58
  @testing
  Scenario: Results counter
    Given User is on olx.pl page
    And He write "alabaster" in a search bar
    And He write "Warszawa" in a city
    When He clicks on the Szukaj
    And He choose category "Dom i Ogród" in a result page
    Then He compares counter from tab wszystkie and counter for category "Dom i Ogród"











