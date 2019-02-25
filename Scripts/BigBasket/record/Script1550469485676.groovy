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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver


WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Online Grocery Shopping and On/a_My Orders'))

WebElement deliveryStatusOfFirstElement= WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/OrderSummary/PastOrders_Header_DeliveryStatus') ,15).get(1)
deliveryStatus= deliveryStatusOfFirstElement.getText()

println("delivery Status is : " +deliveryStatus)
assert deliveryStatus.equals("Delivered on")

WebElement deliveryDateAndTimeOfFirstElement= WebUiCommonHelper.findWebElements( findTestObject('Object Repository/BigBasket/OrderSummary/PastOrders_Header_DeliveryDateTime'), 15).get(1)

deliveryDateAndTime= deliveryDateAndTimeOfFirstElement.getText()

println("Delivery date and time is : " +deliveryDateAndTime)

WebUI.click( findTestObject('Object Repository/BigBasket/OrderSummary/PastOrders_Header_ViewNoItems'))

WebDriver driver= DriverFactory.getWebDriver()
abc='MBO'
driver.findElement(By.xpath("//div[contains(.,'Order ID: ')]/a[contains(@href,'${abc}')]"))

WebUI.click(findTestObject('BigBasket/OrderSummary/PastOrders_Header_ViewNoItems'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/div_Your delivery addressNived'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/span_Your delivery address'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/span_Your delivery slot'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/span_Amount to Pay'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/span_Mon 18 Feb 2019 between 0'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/span_Rs. 1182.00'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/span_Mode of Payment'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/span_Payment Gateway'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/div_CONTINUE SHOPPING'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/div_INVOICE LIST Order Stateme'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/li_'))

WebUI.click(findTestObject('BigBasket/OrderSummary/PastOrders_Header_DeliveryDateTime'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/div_Delivery Address'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/div_Delivery AddressNivedita S'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/div_Payment Information'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/div_Payment InformationPayment'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/div_Order Summary'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/div_Order SummaryDelivery Char'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/Page_Best Online Grocery Store in I/span_View more details'))

WebUI.closeBrowser()

