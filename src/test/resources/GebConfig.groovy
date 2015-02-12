import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

/**
 * Created with IntelliJ IDEA.
 * User: kbaranowski
 * Date: 12.06.14
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
def driverInstance
driver = {
    //driverInstance = new FirefoxDriver()

    //System.setProperty('webdriver.ie.driver', 'src/binary/IE/IEDriverServer.exe')
    //driverInstance = new InternetExplorerDriver()

    System.setProperty('webdriver.chrome.driver', 'src/binary/Chrome/chromedriver.exe')
    driverInstance = new ChromeDriver()

    driverInstance.manage().window().maximize()
    driverInstance
}
    baseUrl = "https://olx.pl"
