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
        checkZapamietajMnie { $("label.f_checkbox[for='user-remember']") }
        zapomnialesHasla { $("#newpassword") }
        forgottenPasswordLink (to: NewPasswordPage) { (zapomnialesHasla) }
        emailFieldNewPasswordPage { $("#mainForm input[name='register[email]']")}
        newPasswordField { $("#mainForm input[name='register[password]']")}
        repeatPasswordField { $("#mainForm input[name='register[password2]']")}
        changeButton { $("#se_userSignIn")}
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
        waitFor { checkZapamietajMnie.click() }
    }

    def forgottenPasswordLink(){
       waitFor { zapomnialesHasla.click() }
    }

    def goToNewPasswordPage(){
        waitFor { forgottenPasswordLink.click() }
    }

    def changePassword(email, newPassword, repeatPassword) {
        emailFieldNewPasswordPage.value(email)
        newPasswordField.value(newPassword)
        repeatPasswordField.value(repeatPassword)
    }

    def changePasswordButton(){
        waitFor { changeButton().click() }
    }

    def isActivateMessageForNewPassword(){
        waitFor { $("#body-container strong").text() == "Teraz musisz aktywować swoje nowe hasło!"}
    }

}

