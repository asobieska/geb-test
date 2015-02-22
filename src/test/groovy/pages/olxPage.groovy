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
        categoryHint { $("ul.suggestsearchmain span.gray")}
        findValueSearch { $("#autosuggest-div li").first() }
        mainCategory { $("#maincat-grid #cat-5") }
        subCategory { $("#bottom5 #cat-84") }
        newMainCategory { $("#leftMenu #cat-4") }
        newSubcategory { $("#bottom4 #cat-52") }

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

    def resultCategory(){
        waitFor { $("small.breadcrumb", text: contains("Dom i Ogród")) }
    }

    def categoryInMyPage(){
       waitFor { mainCategory.click() }
    }

    def subCategoryInMyPage(){
        waitFor { subCategory.text().contains("Samochody") }
    }

    def newCategoryInMyPage(){
         waitFor { newMainCategory.click() }
    }

    def newSubcategoryInPage(){
       waitFor { newSubcategory.text().contains("Biurowa") }
    }
}