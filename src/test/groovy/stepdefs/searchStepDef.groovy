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
//    myPage.searchInMainPage()
    myPage.goToResultSearchPage()
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

//Scenario2
When(~/^He write only one letter "(.*?)" in a search bar$/) { String arg1 ->
    keyword = arg1
    String oneLetter = keyword.substring(0,1)
    myPage.searchValueInMainPage(oneLetter)
    Thread.sleep(5000)
    myPage.predictiveSearchInMyPage()
    myPage.searchValueInMainPage.value(keyword)
    Thread.sleep(5000)
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





