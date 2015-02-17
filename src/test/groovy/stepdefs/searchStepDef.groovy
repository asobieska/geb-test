package stepdefs

import static cucumber.api.groovy.EN.And
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When


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
    myPage.searchButtonInMainPage()
}
Then(~/^He check result$/) { ->
    myPage.isTitleContains("Moda w Gdynia")
}

//Scenario2
When(~/^He write only one letter "(.*?)" in a search bar$/) { String oneLetter ->
    myPage.predictiveSearchInMyPage(oneLetter)
}

And(~/^He looking for "(.*?)" in a search list$/) { String findValueSearch ->
    myPage.findValueSearchInMyPage(findValueSearch)
}

And(~/^He check result on predictive search$/) { ->
    myPage.isTitleContains("Lampa")
}
