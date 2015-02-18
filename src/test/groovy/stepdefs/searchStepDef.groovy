package stepdefs

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

//Scenario2 - jeszcze dobrze nie działa, trzeba poprawic krok He looking for "(.*?)" in a search list$/
When(~/^He write only one letter "(.*?)" in a search bar$/) { String oneLetter ->
    myPage.predictiveSearchInMyPage(oneLetter)
}

And(~/^He looking for "(.*?)" in a search list$/) { String findValueSearch ->
    myPage.findValueSearchInMyPage(findValueSearch)
}

And(~/^He check result on predictive search$/) { ->
    myPage.isTitleContains("Lampa")
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