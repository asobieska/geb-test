package pages
import geb.Page
/**
 * Created by asobieska on 2/12/2015.
 */
class LoginPage extends Page{
    static content = {
        emailField {$("#loginForm input[name='login[email]']")}
        passwordField {$("#loginForm input[name='login[password]']")}
        loginButton {$("#se_userLogin")}
        titleAfterLogIn {$("title").text() == "Mój OLX • OLX.pl (dawniej Tablica.pl)"}
        logOutButton {$("#topLoginLink")}
        displayed {$("#userLoginBox")}
        loginOutList {$("#login-box-logout")}
    }

    def logIn(String email, String password){
        emailField.value(email)
        passwordField.value(password)
    }

    def logInButton(){
        loginButton.click()
    }

    def logOut(){
        logOutButton.click()
        waitFor{ displayed.isDisplayed()}
        loginOutList.click()
    }
}

