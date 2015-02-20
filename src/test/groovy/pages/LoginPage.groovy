package pages

import utils.Messeges

/**
 * Created by asobieska on 2/12/2015.
 */
class LoginPage extends OlxAbstractPage{
    static content = {
        emailField { $("#loginForm input[name='login[email]']") }
        passwordField { $("#loginForm input[name='login[password]']") }
        loginButton { $("#se_userLogin") }
        logOutButton { $("#topLoginLink") }
        errorMessageForEmail  { $("label.error[for='userEmail']") }
        errorMessageForPassword { $("label.error[for='userPass']") }
        checkZapamietajMnie { $("label.f_checkbox[for='user-remember']") }
        zapomnialesHasla { $("#newpassword") }
        forgottenPasswordLink (to: NewPasswordPage) { $("#newpassword") }
        facebookButton { $(".button span.icon")}
        facebookEmailField { $(".form_row input[name='email']") }
        facebookPassField { $(".form_row input[name='pass']") }
        facebookPageButton { $("#loginbutton") }
        errorMessageForFacebookLogIn { $("#login_form .login_error_box .fwb") }
    }


    def logIn(String email, String password){
        emailField.value(email)
        passwordField.value(password)
    }

    def logInButton(){
        loginButton.click()
    }

    def isErrorMessageForEmailVisible(){
        waitFor { errorMessageForEmail.text() == Messeges.FIELD_IS_REQUIRED }
    }

    def isErrorMessageForEmail(message){
        waitFor { errorMessageForEmail.text() == message }
    }

    def isErrorMessageForPasswordVisible(){
       waitFor { errorMessageForPassword }
    }

    def isErrorMessageForPassword(message){
        waitFor { errorMessageForPassword.text() == message }
    }
    def checkRememberMe(){
        waitFor { checkZapamietajMnie.click() }
    }

    def goToNewPasswordPage(){
        waitFor { forgottenPasswordLink.click() }
        browser.page
    }

    def logInFacebookButton(){
        facebookButton.click()
    }

    def logInFacebookPage(String facebookEmail, String facebookPassword){
        facebookEmailField.value(facebookEmail)
        facebookPassField.value(facebookPassword)
    }

    def logInFacebookPageButton(){
        facebookPageButton.click()
    }

    def isErrorMessageForFacebookEmail(){
        waitFor { errorMessageForFacebookLogIn.text() == "Incorrect Email" }
    }
}

