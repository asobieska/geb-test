package pages

import geb.Page

/**
 * Created by Aneta on 2015-02-14.
 */
class OlxAbstractPage extends Page {
    def isTitleContains(partOfTheTitle){
        browser.title.contains(partOfTheTitle)
    }
}
