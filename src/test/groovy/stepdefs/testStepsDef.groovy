package stepdefs

import pages.olxPage
import static cucumber.api.groovy.EN.*

import geb.Browser

browser = new Browser()

Given(~/^User is on olx.pl page$/) { ->
    to olxPage
    myPage = page
}

And(~/^He is clicks on the Moj OLX$/) {  ->
    myPage.goToLoginPage()
    loginPage = page
}

When(~/^He fill email "(.*?)" and password "(.*?)"$/) { String email, String password ->
    loginPage.logIn(email, password)
}

And(~/^Clicks on the Zaloguj sie button$/) {  ->
    loginPage.logInButton()
}

Then(~/^He check you are logged$/) { ->
    waitFor {browser.title == "Mój OLX • OLX.pl (dawniej Tablica.pl)"}
    assert loginPage.isTitleContains("Mój OLX")
}

//Scenario2
Then(~/^He is informed that he has to provide email and password$/) { ->
    assert loginPage.isErrorMessageForEmailVisible()
    assert loginPage.isErrorMessageForPasswordVisible()
}

Then(~/^He is not logged in$/) { ->
    assert myPage.at
}






