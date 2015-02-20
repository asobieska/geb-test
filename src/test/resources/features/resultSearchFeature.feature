#F3 - TBA48, 58, 63 - Manipulation on result Search
Feature: Result view - change on view galeria, duze zdjecia and lista
  Result view - change on navigate Prywatne, Firma and Wszystkie
  Result view - change on sort Najtańsze
  Result view - change on sort Najdrozsze
  Detailed search
  Detailed search - results counter

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

#Scenario9 - TBA63 not implement yet
  Scenario: Detailed search
    Given User is on olx.pl page
    And He choose main category Nieruchomosci
    And He choose subcategory Mieszkania
    And He write to pink to search bar
    When He choose offer tylko ze zdjeciem
    And He choose category Wynajem
    And He choose liczba pokoi: kawalerka
    Then He clics on search

#Scenario10 - TBA58 not implement yet
  Scenario: Detailed search - results counter
    Given User is on olx.pl page
    And He write "alabaster" in a search bar
    And He clics on the Szukaj
    And He choose a category to Dom i Ogrod
    When He check counter result to navigate tabs wszystkie and list of category Dom i Ogrod
    Then He check empty result from category Praca