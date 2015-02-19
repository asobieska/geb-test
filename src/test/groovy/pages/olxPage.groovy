package pages


class olxPage extends OlxAbstractPage {
    static url = '/'
    static at = { waitFor { title.contains('OLX') } }
    static content = {
        loginLink(to: LoginPage) {  $('#topLoginLink') }
        searchValue { $("#searchmain input[name='q']") }
        searchCityField { $("#locationBox input[type='text']") }
        searchButton { $("#searchmain input[type='submit']")}
        predictiveSearch { $("#searchmain input[name='q']") }
        findValueSearch { $("#autosuggest-div li").first() }
        mainCategory { $("#maincat-grid #cat-5") }
        subCategory { $("#bottom5 #cat-84") }
        newMainCategory { $("#leftMenu #cat-4") }
        newSubcategory { $("#bottom4 #cat-52") }
        privatResultTab { $("#tabs-container li").first().next() }
        firmaResultTab { $("#tabs-container li").last() }
        wszystkieResultTab { $("#tabs-container li").first() }
        galeryResultView { $("#viewSelector #gallery") }
        galeryBigResultView { $("#viewSelector #galleryBig") }
        listResultView { $("#viewSelector #list") }
        dispayedSortInResultView { $("#form-order-gallery [title='Najnowsze']").jquery.mouseover() }
        sortCheapest { $("#form-order-gallery li").first().next() }
        sortMostExpensive { $("#form-order-gallery li").last() }
        sortLates { $("#form-order-gallery li").first() }
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

    def searchInMainPage(){
        waitFor(10,1) { searchButton.click() }
    }

    def predictiveSearchInMyPage(String oneLetter){
        waitFor { predictiveSearch << (oneLetter) }
        predictiveSearch.click()
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

    def navigatePrivatResultView() {
        waitFor(10,1) { privatResultTab.click() }
    }

    def navigateFirmaResultView() {
        waitFor(10,1) { firmaResultTab.click() }
    }

    def navigateWszystkieResultView() {
        waitFor(10,1) { wszystkieResultTab.click() }
    }

    def viewGaleriaResultView() {
        waitFor(10,1) { galeryResultView.click() }
    }

    def viewDuzeZdjeciaResultView() {
        waitFor(10,1) { galeryBigResultView.click() }
    }

    def viewListaResultView() {
        waitFor(10,1) { listResultView.click() }
    }

    def pomocnicza() {
        dispayedSortInResultView.click()
    }

    def sortNajtanszeResultView() {
        sortCheapest.click()
    }

    def sortMostExpensiveResultView() {
        sortMostExpensive.click()
    }


}