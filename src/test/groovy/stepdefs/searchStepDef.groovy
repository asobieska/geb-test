package stepdefs

import cucumber.api.DataTable

import static cucumber.api.groovy.EN.*

/**
 * Created by asobieska on 2/17/2015.
 */

//Scenario1
When(~/^He write "(.*?)" in a search bar$/) { String searchValue ->
    myPage.searchValueInMainPage(searchValue)
}

And(~/^He write "(.*?)" in a country$/) { String city ->
    myPage.searchCityFieldInMainPage(city)
}

And(~/^He clics on the Szukaj$/) { ->
    myPage.searchInMainPage()
}

Then(~/^He check result Moda w Gdynia$/) { ->
    myPage.isTitleContains("Moda w Gdynia")
}

//Scenario1a
When(~/^He write what looking for "(.*?)" in a search bar$/) { String searchValue ->
    myPage.searchValueInMainPage(searchValue)
}

And(~/^He write city "(.*?)" where you looking for$/) { String city ->
    myPage.searchCityFieldInMainPage(city)
}

Then(~/^He check result:$/) { String messege ->
    myPage.isTitleContains(messege)
}

//Scenario2 - jeszcze dobrze nie działa, trzeba poprawic krok He looking for "(.*?)" in a search list$/
When(~/^He write only one letter "(.*?)" in a search bar$/) { String oneLetter ->
    myPage.predictiveSearchInMyPage(oneLetter)
}

And(~/^He looking for Mercedes in a search list$/) {  ->
    myPage.findValueSearchInMyPage()
}

And(~/^He check result on predictive search$/) { ->
    myPage.isTitleContains("Mercedes")
}

//Scenario3
And(~/^He choose main category Motoryzacja$/) {  ->
    myPage.categoryInMyPage()
}

And(~/^He see subcategories from Motoryzacja$/) { ->
    assert myPage.subCategoryInMyPage()
}

When(~/^He change main categories and choose main categories Praca in the left site$/) {  ->
    myPage.newCategoryInMyPage()
}

Then(~/^He see new subcategories from Praca$/) { ->
   assert myPage.newSubcategoryInPage()
}

//Scenario4
When(~/^He should see the main page category$/) { DataTable categoryAndSubcategory ->
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
When (~/^He change navigate on the Prywatne$/) { ->
    myPage.navigatePrivatResultView()
}

And (~/^He change navigate on the Firma$/) { ->
    myPage.navigateFirmaResultView()
}

Then (~/^He change navigate is on Wszystkie$/) { ->
    myPage.navigateWszystkieResultView()
}

//Scenario7
When (~/^He change sort on the Najtańsze$/) { ->

}
And (~/^He change sort on the Najdroższe$/) { ->

}
Then (~/^He change sort on the Najnowsze$/) { ->

}



