package stepdefs

import cucumber.api.PendingException
import pages.olxPage
import static cucumber.api.groovy.EN.*

import geb.Browser

browser = new Browser()


Given(~/^User is on olx.pl page$/) { ->
    to olxPage
    myPage = page
}

And(~/^He is clicks on the Moj OLX$/) {  ->
    loginPage = myPage.goToLoginPage()
}

When(~/^He fill email "(.*?)" and password "(.*?)"$/) { String email, String password ->
    loginPage.logIn(email, password)
}
And(~/^Clicks on the Zaloguj sie button$/) {  ->
    loginPage.logInButton()
}
Then(~/^He check you are logged$/) { ->

}







