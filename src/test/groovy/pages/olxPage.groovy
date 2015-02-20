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

    def searchValueInMainPage(String lookingText){
        searchValue.value(lookingText)
    }

    def searchCityFieldInMainPage(String lookingCity){
        searchCityField.value(lookingCity)
        searchCityField.click()
    }

//    def searchInMainPage(){
//        waitFor { searchButton.click() }
//    }

    def goToResultSearchPage(){
        waitFor { searchButton.click() }
        browser.page
    }

    def predictiveSearchInMyPage(){
        waitFor { hintsList.isDisplayed() }

    }

    def findValueSearchInMyPage(){
       waitFor { findValueSearch.click() }
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