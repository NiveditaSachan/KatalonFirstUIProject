import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import javax.xml.ws.wsaddressing.W3CEndpointReference.Address

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
import internal.GlobalVariable as GlobalVariable


WebUI.openBrowser('')

	WebUI.navigateToUrl('https://www.bigbasket.com/')
	
	WebUI.click(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/a_Login'))
	
	WebUI.setText(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/input_OR_email'), 'nivedita.hbti@gmail.com')
	
	WebUI.setEncryptedText(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/input_Please enter valid email'), 
	    'LqVTzjb8H0GS29zWb5N07g==')
	
	WebUI.click(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/button_LOGIN'))
	
	//Go To My Orders Page
	
	WebUI.waitForElementClickable(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/span_UserAccount'), 
	    15)
	
	Thread.sleep(2000)
	
	WebUI.click(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/span_UserAccount'))
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/UserNivedita_MyOrders'))
	
	WebUI.waitForPageLoad(15)
	
	//Click on First Order in My Orders Screen
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/OrderSummary_MyOrders'))
	
	// Get the Delivery status of first Order
	
	WebElement deliveryStatusOfFirstElement = WebUiCommonHelper.findWebElements(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/PastOrders_Header_DeliveryStatus'), 
	    15).get(1)
	
	deliveryStatus = deliveryStatusOfFirstElement.getText()
	
	println('delivery Status is : ' + deliveryStatus)
	
	assert deliveryStatus.equals('Delivered on')
	
	WebElement deliveryDateAndTimeOfFirstElement = WebUiCommonHelper.findWebElements(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/PastOrders_Header_DeliveryDateTime'), 
	    15).get(1)
	
	deliveryDateAndTime = deliveryDateAndTimeOfFirstElement.getText()
	
	println('Delivery date and time is : ' + deliveryDateAndTime)
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	
	
	//This is to give Variable XPATH Where I could give order ID as Variable
	// Value of var1 is 26-02-2019 . See Variables
	driver.findElement(By.xpath("//div[contains(.,'Order ID: ')]/a[contains(@href,'$var1')]")).isDisplayed()
		
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/PastOrders_Header_ViewNoItems'))
	
	WebUI.waitForPageLoad(15)
	
	
	Thread.sleep(3000)
	
	WebUI.verifyElementPresent(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/OrderDetails/OrderDetails_DeliveryAddress_Header') , 15)
	
	List<WebElement> deliveryAddress= WebUiCommonHelper.findWebElements( findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/OrderDetails/OrderDetails_UsersDeliveryAddress') , 15)
	
	println("deliveryAddress "+ deliveryAddress)
	
	UserName=  deliveryAddress.get(1).getText()
	phoneNumber= deliveryAddress.get(2).getText()
	AddressLine1= deliveryAddress.get(3).getText()
	AddressLine2= deliveryAddress.get(4).getText()
	AddressLine3= deliveryAddress.get(5).getText()
	AddressLine4= deliveryAddress.get(6).getText()
	
	println(" Address is : " + UserName + "\n" +phoneNumber+ "\n" +AddressLine1+ "\n" +AddressLine2+ "\n" +AddressLine3+ "\n" +AddressLine4) 
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/OrderDetails/OrderDetails_Btn_CONTINUE SHOPPING') )
	
	WebUI.waitForPageLoad(15)
	
	WebUI.verifyElementPresent( findTestObject('TestFolder/nopCommerce_OR/BigBasket/Basket/BigBasketLogo'), 15)
	
	WebUI.waitForElementClickable(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/span_UserAccount'),
		15)
	
	Thread.sleep(2000)
	
	WebUI.click(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/span_UserAccount'))
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/UserNivedita_MyOrders'))
	
	WebUI.waitForPageLoad(15)
	
	Thread.sleep(2000)
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/OrderSummary_MyOrders'))
	
	WebUI.waitForPageLoad(15)
	
	Thread.sleep(2000)	
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/PastOrders_Header_ViewNoItems'))
	
	WebUI.waitForPageLoad(15)
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/OrderDetails/OrderDetails_Btn_SHOP FROM THIS OREDR') )
	
	WebUI.waitForPageLoad(15)
	
	WebUI.verifyElementPresent( findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/ShopFromThisOrder_OrderID_Header'), 15)
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/ShopFromThisOrder_Btn_AddToBasket') )
	
	WebUI.verifyElementPresent( findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/ShopFromBasket_Alert_SelectAtleastOne'), 15)

	WebUI.click( findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/ShopFromBasket_Alert_Btn_OK'))
	
	List<WebElement> FruitAndVegCheckboxes= WebUiCommonHelper.findWebElements((findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/ShopFromBasket_CheckBox_FruitsAndVegetables')) , 15)
	
	FruitAndVegCheckbox= FruitAndVegCheckboxes.get(1).click()
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/ShopFromThisOrder_Btn_AddToBasket') )
	
	Thread.sleep(1000)

	//WebUI.acceptAlert(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/ShopFromBasket_Alert_Btn_OK') )
	
	WebUI.waitForPageLoad(15)
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/ShopFromBasket_CheckBox_SelectAll'))
	
	List<WebElement> IemsCountFruitsAndVeg= WebUiCommonHelper.findWebElements( findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/ShopFromBasket_AllFruitsAndVegetableCount'), 15)
	
	println("Iems Count Fruits And Veg : " + IemsCountFruitsAndVeg.size())
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/OrderSummary/ShopFromThisOrder_Btn_AddToBasket') )
	
	Thread.sleep(2000)	
	
	basketCount=Integer.parseInt(WebUI.getText(findTestObject('TestFolder/nopCommerce_OR/BigBasket/Basket/ItemCount') ).replace(" items", "").trim()) 
	
	assert basketCount==IemsCountFruitsAndVeg.size()
	
	
WebUI.closeBrowser()

