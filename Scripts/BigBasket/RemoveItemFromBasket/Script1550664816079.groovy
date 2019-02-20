import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.junit.After as After
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.interactions.Mouse as Mouse
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.bigbasket.com/')

WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/a_Login'))

WebUI.setText(findTestObject('Object Repository/Page_Online Grocery Shopping and On/input_OR_email'), 'nivedita.hbti@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Online Grocery Shopping and On/input_Please enter valid email'), 
    'LqVTzjb8H0GS29zWb5N07g==')

WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/button_LOGIN'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'), 
    15)

items = WebUI.getText(findTestObject('Object Repository/BigBasket/Page_Online Grocery Shopping and On/span_0 items'))

count = Integer.parseInt(items.replace(' items', '').trim())

println('Count is : ' + count)

WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'))

WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/a_My Basket No Items'))

WebUI.waitForPageLoad(15)

//Thread.sleep(5000)
WebDriver driver = DriverFactory.getWebDriver()

//   driver.findElement(By.xpath("//a[@id[contains(.,'remove')]]"))
if (count > 0) {
    Removebutton = driver.findElements(By.xpath('//a[@id[contains(.,\'remove\')]]'))

    int noOfRemoveButton = Removebutton.size()

    println('no of items with remove buttons.. ' + noOfRemoveButton)

    for (i = 0; i < noOfRemoveButton; i++) {
        Removebutton[i].click()

        println((('Element Remove button : ' + i) + ': ') + (Removebutton[i]))

        WebUI.waitForPageLoad(15) //WebUI.waitForElementClickable(findTestObject('Basket/button_CONTINUE SHOPPING'), 15)
    }
}

Thread.sleep(5000)

WebElement ele1 = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/BigBasket/Basket/button_CONTINUE SHOPPING'), 
    15)

ele1.click()

WebUI.closeBrowser()