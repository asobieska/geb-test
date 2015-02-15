package pages
/**
 * Created by asobieska on 2/12/2015.
 */
class LoginPage extends OlxAbstractPage{
    static content = {
        emailField {$("#loginForm input[name='login[email]']")}
        passwordField {$("#loginForm input[name='login[password]']")}
        loginButton {$("#se_userLogin")}
        logOutButton {$("#topLoginLink")}
    }

    def logIn(String email, String password){
        emailField.value(email)
        passwordField.value(password)
    }

    def logInButton(){
        loginButton.click()
    }

    def isErrorMessageForEmailVisible(){
        waitFor {$("label.error[for='userEmail']").text() == "To pole jest wymagane"}
    }

    def isErrorMessageForPasswordVisible(){
       waitFor {$("label.error[for='userPass']")}
    }

}

