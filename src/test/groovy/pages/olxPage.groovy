package pages


class olxPage extends OlxAbstractPage {
    static url = '/'
    static at = { waitFor { title.contains('OLX') } }
    static content = {
        loginLink(to: LoginPage) {  $('#topLoginLink') }
        searchValue { $("#searchmain input[name='q']") }
        searchCityField { $("#locationBox input[type='text']") }
        searchButton { $("#searchmain input[type='submit']")}
//        predictiveSearch { $("#searchmain input[name='q']") }
//        findValueSearch { $("#autosuggest-div").eq("(nth-child(6)") }
        mainCategory { $("#maincat-grid #cat-5") }
        subCategory { $("#bottom5 #cat-84")}
        newMainCategory { $("#leftMenu #cat-4")}
        newSubcategory { $("#bottom4 #cat-52")}
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

    def searchInMainPage(){
        waitFor {searchButton.click()}
    }

    def predictiveSearchInMyPage(String oneLetter){
        waitFor { predictiveSearch.value(oneLetter) }
    }

    def findValueSearchInMyPage(findValueInList){
       waitFor { findValueSearch.click(findValueInList) }
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