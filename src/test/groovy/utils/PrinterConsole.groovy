package utils

import geb.navigator.Navigator

/**
 * Created by asobieska on 2/27/2015.
 */
class PrinterConsole {

    public static printElement(Navigator navigator, String indents){
        println(indents + "tag: " + navigator.tag()
                + ", classes:" + navigator.classes().toArray())
        println(indents + "elements:")
        navigator.allElements().each { elem ->
            println(indents + "  " + elem.tagName)
        }
    }

    public static printElementWithChildren(Navigator navigator){
        println(navigator.tag() + "[")
        navigator.children().each { elem ->
            printElement(elem, "    ")
        }
        println("](" + navigator.tag()+ ")")
    }

    public static printElementHead(Navigator navigator){
        println(navigator.firstElement().text)
    }
}
