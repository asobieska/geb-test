package stepdefs

import cucumber.api.DataTable

import static cucumber.api.groovy.EN.*

/**
 * Created by asobieska on 2/17/2015.
 */

//Scenario1
When(~/^He write "(.*?)" in a search bar$/) { String searchValue ->
    myPage.setSearchValue(searchValue)
}

And(~/^He write "(.*?)" in a country$/) { String city ->
    myPage.searchCityFieldInMainPage(city)
}

And(~/^He clicks on the Szukaj$/) { ->
//    myPage.searchInMainPage()
//    myPage.goToResultSearchPage()
}

Then(~/^He check result Moda w Gdynia$/) { ->
    myPage.isTitleContains("Moda w Gdynia")
}

//Scenario1a
When(~/^He write what looking for "(.*?)" in a search bar$/) { String searchValue ->
    myPage.setSearchValue(searchValue)
}

And(~/^He write city "(.*?)" where you looking for$/) { String city ->
    myPage.searchCityFieldInMainPage(city)
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
Then(~/^He check of category$/) { ->
    assert myPage.resultCategory()
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





