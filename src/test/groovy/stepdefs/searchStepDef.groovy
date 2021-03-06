package stepdefs

import static cucumber.api.groovy.EN.*

/**
 * Created by asobieska on 2/17/2015.
 */

//Scenario1
When(~/^He write "(.*?)" in a search bar$/) { String searchValue ->
    myPage.setSearchValue(searchValue)
}

And(~/^He write "(.*?)" in a city$/) { String city ->
    myPage.setSearchCity(city)
}

And(~/^He clicks on the Szukaj$/) { ->
    myPage.searchInOlxPage()
}

Then(~/^He check result Moda w Gdynia$/) { ->
    myPage.isTitleContains("Moda w Gdynia")
}

//Scenario1a
When(~/^He write what looking for "(.*?)" in a search bar$/) { String searchValue ->
    myPage.setSearchValue(searchValue)
}

And(~/^He write city "(.*?)" where you looking for$/) { String city ->
    myPage.setSearchCity(city)
}

Then(~/^He check result:$/) { String messege ->
    myPage.isTitleContains(messege)
}

//Scenario2
When(~/^He write only one letter "(.*?)" in a search bar$/) { String firstLetter ->
    myPage.setSearchValue(firstLetter)
}

And (~/^The list of hints is opened$/) { ->
    myPage.isHintsListDisplayed()
}

And  (~/^He choose "(.*?)" on hints list$/) { String hint ->
    myPage.chooseValueOnHintsList(hint)
}

Then(~/^He check phrase meble is on a result page$/) { ->
    assert myPage.isTitleContains("Meble - OLX.pl")
}

//Scenario3
And(~/^He choose main category "(.*?)"$/) { String mainCategory ->
    myPage.chooseCategoryInOlxPage(mainCategory)
}

And(~/^He see subcategories "(.*?)"$/) { String subcategory ->
    assert myPage.checkSubcategoryInMainCategory(subcategory)
}

When(~/^He change main categories and choose main categories "(.*?)" in the left site$/) {  String newCategory->
    myPage.chooseCategoryInCategoryPage(newCategory)
}

//Scenario5
When (~/^He change view on galeria$/) { ->
    myPage.viewGaleriaResultView()
}

And (~/^He change view on duze zdjecia$/) { ->
    myPage.viewDuzeZdjeciaResultView()
}

Then (~/^He change view on lista$/) { ->
    myPage.viewListaResultView()
}

//Scenario6
When (~/^He change navigate on the "(.*?)"/) { String tabPrywatne ->
    myPage.navigatePrivatResultView(tabPrywatne)
}

And (~/^He change navigate on "(.*?)"$/) { String tabFirma ->
    myPage.navigateFirmaResultView(tabFirma)
}

Then (~/^He change navigate is on "(.*?)"$/) { String tabWszystkie ->
    myPage.navigateWszystkieResultView(tabWszystkie)
}

//Scenario7
When (~/^He change sort on the Najtańsze$/) { ->
    myPage.displayedSortInResultView()
    myPage.sortNajtanszeResultView()
}

//Scenario8
When (~/^He change sort on the Najdroższe/) { ->
    myPage.displayedSortInResultView()
    myPage.sortMostExpensiveResultView()
}

//Scenario9
And(~/^He choose category "(.*?)" in a result page$/) { String linkCategory ->
    myPage.chooseLinkCategory(linkCategory)
}

And(~/^He choose subcategory "(.*?)" in a result page$/) { String linkSubcategory->
    myPage.chooseLinkSubcategory(linkSubcategory)
}

When(~/^He choose offer Tylko ze zdjeciem$/) { ->
    myPage.checkPhotoOnly()
}

And(~/^He choose category Wynajem$/) { ->
    myPage.chooseListCategory()
}

And(~/^He choose liczba pokoi: kawalerka$/) { ->
    myPage.chooseListLiczbaPokoi()
}

Then(~/^He clicks on the search$/) { ->
    myPage.searchInResultPage()
}

//Scenario10
Then(~/^He compares counter from tab wszystkie and counter for category "(.*?)"$/) { String categoryName ->
    assert myPage.getResultsCounter() == myPage.getCategoryCounter(categoryName)
}








