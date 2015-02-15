package stepdefs

import geb.Browser
import geb.binding.BindingUpdater

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

Before() {
    b = new Browser()
    bindingUpdater = new BindingUpdater(binding, b)
    bindingUpdater.initialize()
    b.clearCookies()
}

After() {
    //println("Clearing cache and closing browser...")
    //def cachedDriver = CachingDriverFactory.clearCacheAndQuitDriver()
    bindingUpdater.remove()
}