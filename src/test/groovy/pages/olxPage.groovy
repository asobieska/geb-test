package pages

import geb.navigator.Navigator
import org.openqa.selenium.Keys


class olxPage extends OlxAbstractPage {
    static url = '/'
    static at = { waitFor { title.contains('OLX') } }
    static content = {
        loginLink(to: LoginPage) {  $('#topLoginLink') }
        searchValue { $("#searchmain input[name='q']") }
        searchCityField { $("#locationBox input[type='text']").jquery.mouseover() }
        searchButton { $("#searchmain input[type='submit']")}
        hintsList { $('ul.suggestsearchmain') }
        findValueSearch { $("#autosuggest-div li").first() }
        privatResultTab { $("#tabs-container li").first().next() }
        firmaResultTab { $("#tabs-container li").last() }
        wszystkieResultTab { $("#tabs-container li").first() }
        galeryResultView { $("#viewSelector #gallery") }
        galeryBigResultView { $("#viewSelector #galleryBig") }
        sortList { $("#form-order-gallery", text: contains("Najnowsze")).jquery.mouseover() }
        listResultView { $("#viewSelector #list") }
        sortCheapest { $("#form-order-gallery li").first().next() }
        sortMostExpensive { $("#form-order-gallery li").last() }
        searchValueInResultPage { $(".clearbox  input[name='q']") }
//        checkboxPhotoOnly { $("label.small[for='photo-only']")}
        checkboxPhotoOnly { $("#photo-only")}
        listCategory { $("span.3rd-category-choose-label", text: contains('Wybierz kategorię')).jquery.mouseover() }

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

    def displayedSortInResultView() {
        sortList.click()
    }

    def sortNajtanszeResultView() {
        sortCheapest.click()
    }

    def sortMostExpensiveResultView() {
        sortMostExpensive.click()
    }

    def chooseLinkCategory(category){
        $("#topLink ul span", text: contains(category)).click()
    }

    def chooseLinkSubcategory(subcategory){
        $("#topLink ul span", text: contains(subcategory)).click()
    }

    def checkPhotoOnly() {
       waitFor { checkboxPhotoOnly.click() }
    }

    def chooseListCategory(){
        listCategory.click()
        waitFor { $("ul li a.category-choose", text: contains("Wynajem")) }

    }
}