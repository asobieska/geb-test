package pages

import org.openqa.selenium.Keys

class olxPage extends OlxAbstractPage {
    static url = '/'
    static at = { waitFor { title.contains('OLX') } }
    static content = {
        loginLink(to: LoginPage) { $('#topLoginLink') }
        searchValue { $("#searchmain input[name='q']") }
        searchCityField { $("#locationBox input[type='text']").jquery.mouseover() }
        searchButton { $("#searchmain input[type='submit']")}
        hintsList { $('ul.suggestsearchmain') }
        findValueSearch { $("#autosuggest-div li").first() }
        tabsContainer { $("#tabs-container ")}
        wszystkieResultTab { tabsContainer.find("li").first() }
        viewSelector { $("#viewSelector") }
        galeryResultView { viewSelector.find("#gallery") }
        galeryBigResultView { viewSelector.find("#galleryBig") }
        formOrderGallery { $("#targetorder-select-gallery") }
        listResultView { viewSelector.find("#list") }
        sortCheapest { formOrderGallery.find(text: contains("Najtańsze")) }
        sortMostExpensive { formOrderGallery.find(text: contains("Najdroższe")) }
        searchValueInResultPage { $(".clearbox  input[name='q']") }
        linkCategoryNavigator { $("div.inner li span") }
        checkboxPhotoOnly { $("#photo-only")}
        listChooseCategory { $("ul.subcategories a.category-choose", text: contains("Wynajem")) }
        listCountRoom { $("#f-two_rooms") }
//        categoryCounter { $(".combospace #choosecat").jquery.mouseover() }
    }

    def goToLoginPage(){
        loginLink.click()
        browser.page
    }

    def setSearchValue(String lookingText){
        searchValue << lookingText
    }

    def setSearchCity(String lookingCity){
        searchCityField.value(lookingCity)
        Thread.sleep(500)
        searchCityField << Keys.chord(Keys.CONTROL, "enter")
    }

    def searchInOlxPage(){
        waitFor { searchButton.click() }
    }

    def isHintsListDisplayed(){
        waitFor { hintsList.isDisplayed() }
    }

    def chooseValueOnHintsList(String hint) {
       $("span", text: contains(hint.substring(1))).click()
    }

    def chooseCategoryInOlxPage(category){
        $("strong", text: contains(category)).click()
    }

    def checkSubcategoryInMainCategory(subcategory){
        $("span", text: contains(subcategory))
    }

    def chooseCategoryInCategoryPage(categoryLeftSite){
         $("#leftMenu a", text: contains(categoryLeftSite)).click()
    }

    def navigatePrivatResultView(tabPrywatne) {
        waitFor { tabsContainer.find("li span", text: contains(tabPrywatne)).click() }
    }

    def navigateFirmaResultView(tabFirma) {
        waitFor { tabsContainer.find("li span", text: contains(tabFirma)).click() }
    }

    def navigateWszystkieResultView(tabWszystkie) {
       waitFor { tabsContainer.find("li span.fbold", text: contains(tabWszystkie)).click() }
    }

    def viewGaleriaResultView() {
        waitFor { galeryResultView.click() }
    }

    def viewDuzeZdjeciaResultView() {
        waitFor { galeryBigResultView.click() }
    }

    def viewListaResultView() {
        waitFor { listResultView.click() }
    }

    def displayedSortInResultView() {
        def sortList = formOrderGallery.find(text: contains("Najnowsze")).jquery.mouseover()
        sortList.click()
    }

    def sortNajtanszeResultView() {
        sortCheapest.click()
    }

    def sortMostExpensiveResultView() {
        sortMostExpensive.click()
    }

    def chooseLinkCategory(category){
        linkCategoryNavigator.find( text: contains(category)).click()
    }

    def chooseLinkSubcategory(subcategory){
        linkCategoryNavigator.find( text: contains(subcategory)).click()
    }

    def checkPhotoOnly() {
       waitFor { checkboxPhotoOnly.click() }
    }

    def chooseListCategory() {
        def listCategory = $(".category-item .category").jquery.mouseover()
        waitFor { listCategory.click() }
        Thread.sleep(500)
        waitFor { listChooseCategory.isDisplayed()
            listChooseCategory.click() }
    }

    def chooseListLiczbaPokoi() {
        def listLiczbaPokoi = $("#param_rooms").jquery.mouseover()
        waitFor { listLiczbaPokoi.click() }
        waitFor(5, 1) { listCountRoom.isDisplayed() }
        listCountRoom.click()
    }

    def searchInResultPage() {
        $("ul.search-submit").click()
    }
    def getCategoryCounter(String categoryName){
        def listCategoryCounter = $(".combospace #choosecat").jquery.mouseover()
        waitFor { listCategoryCounter.click() }
        def categoryListItem = $("li", text: contains(categoryName))
        def categoryCounter = categoryListItem.find("span.counterCategory").text()
        categoryCounter
    }

    def getResultsCounter(){
        def counter = wszystkieResultTab.find("span span.color-2")
        def resultsCounter = counter.text()
        resultsCounter
    }
}