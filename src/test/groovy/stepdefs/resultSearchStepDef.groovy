package stepdefs
import static cucumber.api.groovy.EN.*
/**
 * Created by asobieska on 2/20/2015.
 */

//Scenario5
When (~/^He change view on galeria$/) { ->
    myPage.viewGaleriaResultView()
}

And (~/^He change view on duze zdjecia$/) { ->
    myPage.viewDuzeZdjeciaResultView()
}

Then (~/^He change view on lista$/) { ->
    myPage.viewListaResultView()
}

//Scenario6
When (~/^He change navigate on the Prywatne$/) { ->
    myPage.navigatePrivatResultView()
}

And (~/^He change navigate on the Firma$/) { ->
    myPage.navigateFirmaResultView()
}

Then (~/^He change navigate is on Wszystkie$/) { ->
    myPage.navigateWszystkieResultView()
}

//Scenario7
When (~/^He change sort on the Najtańsze$/) { ->
    myPage.pomocnicza()
    myPage.sortNajtanszeResultView()
}

//Scenario8
When (~/^He change sort on the Najdroższe/) { ->
    myPage.pomocnicza()
    myPage.sortMostExpensiveResultView()
}