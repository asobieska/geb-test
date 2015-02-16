package pages

/**
 * Created by asobieska on 2/16/2015.
 */
class NewPasswordPage extends OlxAbstractPage{
    static content = {
        emailFieldNewPasswordPage { $("#mainForm input[name='register[email]']")}
        newPasswordField { $("#mainForm input[name='register[password]']")}
        repeatPasswordField { $("#mainForm input[name='register[password2]']")}
        changeButton { $("#se_userSignIn")}

    }

    def changePassword(email, newPassword, repeatPassword) {
        emailFieldNewPasswordPage.value(email)
        newPasswordField.value(newPassword)
        repeatPasswordField.value(repeatPassword)
    }

    def changePasswordButton(){
        waitFor { changeButton()}
    }

    def isActivateMessageForNewPassword(){
        waitFor { $("#body-container strong").text() == "Teraz musisz aktywować swoje nowe hasło!"}
    }
}
