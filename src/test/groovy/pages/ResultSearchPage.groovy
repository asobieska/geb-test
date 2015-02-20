package pages

/**
 * Created by asobieska on 2/20/2015.
 */
class ResultSearchPage extends OlxAbstractPage {
    static content = {
        privatResultTab { $("#tabs-container li").first().next() }
        firmaResultTab { $("#tabs-container li").last() }
        wszystkieResultTab { $("#tabs-container li").first() }
        galeryResultView { $("#viewSelector #gallery") }
        galeryBigResultView { $("#viewSelector #galleryBig") }
        listResultView { $("#viewSelector #list") }
        dispayedSortInResultView { $("#form-order-gallery [title='Najnowsze']").jquery.mouseover() }
        sortCheapest { $("#form-order-gallery li").first().next() }
        sortMostExpensive { $("#form-order-gallery li").last() }

    }

    def navigatePrivatResultView() {
        waitFor(10,1) { privatResultTab.click() }
    }

    def navigateFirmaResultView() {
        waitFor(10,1) { firmaResultTab.click() }
    }

    def navigateWszystkieResultView() {
        waitFor(10,1) { wszystkieResultTab.click() }
    }

    def viewGaleriaResultView() {
        waitFor(10,1) { galeryResultView.click() }
    }

    def viewDuzeZdjeciaResultView() {
        waitFor(10,1) { galeryBigResultView.click() }
    }

    def viewListaResultView() {
        waitFor(10,1) { listResultView.click() }
    }

    def pomocnicza() {
        dispayedSortInResultView.click()
    }

    def sortNajtanszeResultView() {
        sortCheapest.click()
    }

    def sortMostExpensiveResultView() {
        sortMostExpensive.click()
    }
}
