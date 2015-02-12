package pages

import geb.Page
import org.openqa.selenium.Keys

/**
 * Created by asobieska on 2/12/2015.
 */
class LoginPage extends Page{
    static content = {
        emailField {$("#loginForm input[name='login[email]']")}
        passwordField {$("#loginForm input[name='login[password]']")}
        loginButton {$("#se_userLogin")}
    }

    def logIn(String email, String password){
        emailField.value(email)
        passwordField.value(password)
    }

    def logInButton(){
        loginButton.click()
    }
}
