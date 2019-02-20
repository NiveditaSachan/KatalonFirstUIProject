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

WebUI.setText(findTestObject('Object Repository/Page_Online Grocery Shopping and On/input_Shop for Rs.or moreand g'), 'Daal')

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Online Grocery Shopping and On/SearchIcon'), 10)

WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/SearchIcon'))

WebUI.waitForPageLoad(10)

WebUI.scrollToElement(findTestObject('Object Repository/Page_Best Online Grocery Store in I/btn_ADD_item'), 10)

'This is ADD button in Key word search results to add product to basket'
//WebElement ele = driver.findElement(By.xpath("(//button[@class='btn btn-add col-xs-9'][contains(text(),'Add')])[1]"))
WebElement ele = WebUiCommonHelper.findWebElements( findTestObject('Object Repository/BigBasket/Basket/ADD button'), 15).get(1)

println("ele............."+ ele)
// Using JavaScript Executer to clickon an element whichis not clickable
WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor jse = ((driver) as JavascriptExecutor)

jse.executeScript('arguments[0].click()', ele)

Thread.sleep(3000)

WebElement bigBasketLogo = driver.findElement(By.xpath("//div[@id='st-trigger-effects']/a[@title='Bigbasket']"))

jse.executeScript('arguments[0].click()', bigBasketLogo)

WebUI.waitForElementClickable(findTestObject('Basket/BigBasketLogo'), 15)

WebUI.click(findTestObject('Object Repository/Page_Best Online Grocery Store in I/noOfItemInBasket'))

noOfItemInBasket = WebUI.getText(findTestObject('Object Repository/Page_Best Online Grocery Store in I/noOfItemInBasket'))

println('no Of Item In Basket ...' + noOfItemInBasket)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Best Online Grocery Store in I/div_ QuantityAddRemove'), 
    10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Best Online Grocery Store in I/div_ProductPriceRs'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Best Online Grocery Store in I/SubTotalInRs'), 10)

price = WebUI.getText(findTestObject('Object Repository/Page_Best Online Grocery Store in I/SubTotalInRs'))

println('Price is : ' + price)

///
///
// not clicking on viewbasket and checkout button
WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'))

WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/a_My Basket No Items'))

WebUI.scrollToElement(findTestObject('BigBasket/Basket/CHECKOUT'), 15)

//WebUI.click(findTestObject('BigBasket/Basket/CHECKOUT'))

WebUiCommonHelper.findWebElement(findTestObject('Page_Online Grocery Shopping and On/button_View Basket  Checkout'), 15).click()

//WebUI.click(findTestObject('Page_Online Grocery Shopping and On/button_View Basket  Checkout'))

WebUI.verifyElementPresent(findTestObject('Page_Best Online Grocery Store in I/span_Default Address'), 10)

WebUI.verifyElementPresent(findTestObject('Page_Best Online Grocery Store in I/div_Default Address    Home - '), 10)

WebUI.verifyElementPresent(findTestObject('Page_Best Online Grocery Store in I/div_Default Delivery Option   '), 10)

WebUI.click(findTestObject('Object Repository/Page_Best Online Grocery Store in I/span_Note Selecting the slot m'))

WebUI.closeBrowser()

