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

WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/UserNivedita_MyOrders'))

WebUI.waitForPageLoad(15)

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/OrderSummary_MyOrders'))

WebElement deliveryStatusOfFirstElement = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/OrderSummary/PastOrders_Header_DeliveryStatus'), 
    15).get(1)

deliveryStatus = deliveryStatusOfFirstElement.getText()

println('delivery Status is : ' + deliveryStatus)

assert deliveryStatus.equals('Delivered on')

WebElement deliveryDateAndTimeOfFirstElement = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/OrderSummary/PastOrders_Header_DeliveryDateTime'), 
    15).get(1)

deliveryDateAndTime = deliveryDateAndTimeOfFirstElement.getText()

println('Delivery date and time is : ' + deliveryDateAndTime)

WebDriver driver = DriverFactory.getWebDriver()

//This is to give Variable XPATH Where I could give order ID as Variable
driver.findElement(By.xpath("//div[contains(.,'Order ID: ')]/a[contains(@href,'$var1')]")).isDisplayed()

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/PastOrders_Header_ViewNoItems'))

WebUI.waitForPageLoad(15)

OrderAmount=Integer.parseInt(WebUI.getText(findTestObject('Object Repository/BigBasket/OrderSummary/PastOrders_Header_OrderSummary_OrderAmount'))) 

assert OrderAmount==GlobalVariable.TotalPayableAmount
Thread.sleep(3000)

WebUI.closeBrowser()

