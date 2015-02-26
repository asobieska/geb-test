package pages
import utils.Messeges

/**
 * Created by asobieska on 2/16/2015.
 */
class NewPasswordPage extends OlxAbstractPage{
    static content = {
        emailFieldNewPasswordPage { $("#mainForm input[name='register[email]']")}
        newPasswordField { $("#mainForm input[name='register[password]']")}
        repeatPasswordField { $("#mainForm input[name='register[password2]']")}
        changeButton { $("#se_userSignIn")}
        errorMessageForRepeatPassword { $("label.error[for='userPass-repeat']")}

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
        waitFor { $("#body-container strong").text() == Messeges.ACTIVATE_ACCOUNT }
    }

    def isErrorMessageForRepeatPasswordIncorrect(){
        errorMessageForRepeatPassword().text() == Messeges.VALIDATA_PASSWORD_AND_REPEAT_PASSWORD
    }
}
