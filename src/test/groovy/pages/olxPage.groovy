package pages

import geb.Page

class olxPage extends Page {
    static url = '/'
    static at = { waitFor { title.contains('OLX') } }
    static content = {
        loginLink(to: LoginPage) {  $('#topLoginLink') }
    }
    def goToLoginPage(){
        loginLink.click()
    }
}