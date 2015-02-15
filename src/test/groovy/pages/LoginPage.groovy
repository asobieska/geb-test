package pages


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
        waitFor { $("label.f_checkbox[for='user-remember']").click() }
    }
}

