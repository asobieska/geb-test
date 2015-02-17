package pages

import geb.Page

class olxPage extends Page {
    static url = '/'
    static at = { waitFor { title.contains('OLX') } }
    static content = {
        loginLink(to: LoginPage) {  $('#topLoginLink') }
        searchValue { $("#searchmain input[name='q']") }
        searchCityField { $("#locationBox input[type='text']") }
        searchButton { $("#searchmain input[type='submit']")}
        SearchResult { $(".offerslist h1") }
    }
    def goToLoginPage(){
        loginLink.click()
        browser.page

    }

    def searchValueInMainPage(String lookingText){
        searchValue.value(lookingText)
    }

    def searchCityFieldInMainPage(String lookingCity){
        searchCityField.value(lookingCity)
    }

    def searchButtonInMainPage(){
        waitFor {searchButton.click()}
    }

//    def isSearchResultVisible(String searchValue, String searchCity){
//        waitFor { SearchResult.text() == ("Ogłoszenia" + searchValue + "- OLX.pl -" + searchCity) }
//    }
//    def isSearchResultVisible() {
//        waitFor { SearchResult.text() == "Ogłoszenia Sopot - OLX.pl - moda" }
//    }
}