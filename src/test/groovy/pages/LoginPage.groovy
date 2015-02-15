package pages

import geb.navigator.Navigator

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
    }

    def logIn(String email, String password){
        emailField.value(email)
        passwordField.value(password)
    }

    def logInButton(){
        loginButton.click()
    }

    def isErrorMessageForEmailVisible(){
        waitFor { errorMessageForEmail.text() == "To pole jest wymagane" }
    }

    def isErrorMessageForPasswordVisible(){
       waitFor { errorMessageForPassword }
    }

}

