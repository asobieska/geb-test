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
    loginPage = myPage.goToLoginPage()
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
//Scenario3
When(~/^He fill email "(.*?)" wrong and password "(.*?)" good$/) { String email, String password ->
    loginPage.logIn(email, password)
}

And(~/^He fill email "(.*?)" good and password "(.*?)" wrong$/) { String email, String password ->
    loginPage.logIn(email, password)
}

Then(~/^He is receive a message "(.*?)" for field "(.*?)"$/) { String message, String field ->
    if (field == "email")
        loginPage.isErrorMessageForEmail(message)
    if (field == "password")
        loginPage.isErrorMessageForPassword(message)
}

//Scenario4
When(~/^Click on radio button to remember the user$/) { ->
    loginPage.checkRememberMe()
}

//Scenario5
When(~/^He click on the Zapomniales hasła$/) { ->
    loginPage.forgottenPasswordLink()
    newPasswordPage = loginPage.goToNewPasswordPage()
    assert newPasswordPage.isTitleContains("Nowe hasło")
}

And(~/^He fill email "(.*?)" and nowe haslo "(.*?)" and powtorz haslo "(.*?)"$/) { String email, String newPassword, String repeatPassword ->
    newPasswordPage.changePassword(email, newPassword, repeatPassword)
}

And(~/^He click on the Zmien button$/) { ->
    newPasswordPage.changePasswordButton()
}

Then(~/^Password is change$/) { ->
    assert newPasswordPage.isActivateMessageForNewPassword()
}

//Scenario6
Then(~/^He is receive a message for field Powtorz haslo$/) { ->
    assert newPasswordPage.isErrorMessageForRepeatPasswordIncorrect()
}

//Scenario7
And(~/^He click on the facebook link$/) { ->
    loginPage.logInFacebookButton()
}

When(~/^He check is on facebook page$/) { ->
    assert loginPage.isTitleContains("Log into Facebook")
}

And(~/^He fill facebook email "(.*?)" and facebook password "(.*?)"$/) { String facebookEmail, String facebookPassw ->
    loginPage.logInFacebookPage(facebookEmail,facebookPassw)
}

And(~/^He click on the Log In$/) { ->
    loginPage.logInFacebookPageButton()
}

Then(~/^He is receive a message Incorrect Email$/) { ->
    assert loginPage.isErrorMessageForFacebookEmail()
}




