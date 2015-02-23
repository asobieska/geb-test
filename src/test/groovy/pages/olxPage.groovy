package pages


class olxPage extends OlxAbstractPage {
    static url = '/'
    static at = { waitFor { title.contains('OLX') } }
    static content = {
        loginLink(to: LoginPage) {  $('#topLoginLink') }
        searchValue { $("#searchmain input[name='q']") }
        searchCityField { $("#locationBox input[type='text']") }
        searchButton { $("#searchmain input[type='submit']")}
        hintsList { $('ul.suggestsearchmain') }
        findValueSearch { $("#autosuggest-div li").first() }

    }
    def goToLoginPage(){
        loginLink.click()
        browser.page
    }

    def setSearchValue(String lookingText){
        searchValue << lookingText
    }

    def searchCityFieldInMainPage(String lookingCity){
        searchCityField.value(lookingCity)
        searchCityField.click()
    }

    def goToResultSearchPage(){
        waitFor { searchButton.click() }
        browser.page
    }

    def isHintsListDisplayed(){
        waitFor { hintsList.isDisplayed() }
    }

    def chooseValueOnHintsList(String hint) {
       $("span", text: contains(hint.substring(1))).click()
    }

    def chooseCategoryInOlxPage(category){
       waitFor { $("strong", text: contains(category)).click() }
    }

    def checkSubcategoryInMainCategory(subcategory){
        waitFor { $("span", text: contains(subcategory)) }
    }

    def chooseCategoryInCategoryPage(categoryLeftSite){
         waitFor { $("#leftMenu a", text: contains(categoryLeftSite)).click() }
    }

}