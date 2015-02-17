package pages

import geb.Page

class olxPage extends OlxAbstractPage {
    static url = '/'
    static at = { waitFor { title.contains('OLX') } }
    static content = {
        loginLink(to: LoginPage) {  $('#topLoginLink') }
        searchValue { $("#searchmain input[name='q']") }
        searchCityField { $("#locationBox input[type='text']") }
        searchButton { $("#searchmain input[type='submit']")}
        predictiveSearch { $("#searchmain input[name='q']") }
        findValueSearch { $("#autosuggest-div > ul > li:nth-child(6) > a") }
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

    def predictiveSearchInMyPage(String oneLetter){
        waitFor { predictiveSearch.value(oneLetter) }
    }

    def findValueSearchInMyPage(findValueInList){
       waitFor { findValueSearch.click(findValueInList) }
    }
}