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
import org.apache.pdfbox.pdfparser.PDFParser
import org.apache.pdfbox.text.PDFTextStripper
import org.testng.Assert
import com.kms.katalon.core.annotation.Keyword
import com.Lemoney.ReadFromPDFFile  as ReadFromPDFFile

	WebUI.openBrowser('')
	
	WebUI.navigateToUrl('https://www.bigbasket.com/')
	
	WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/a_Login'))
	
	WebUI.setText(findTestObject('Object Repository/Page_Online Grocery Shopping and On/input_OR_email'), 'nivedita.hbti@gmail.com')
	
	WebUI.setEncryptedText(findTestObject('Object Repository/Page_Online Grocery Shopping and On/input_Please enter valid email'), 
	    'LqVTzjb8H0GS29zWb5N07g==')
	
	WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/button_LOGIN'))
	
	//Go To My Orders Page
	
	WebUI.waitForPageLoad(15)
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'), 
	    15)
	Thread.sleep(2000)
	
	WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'))
	
	WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/UserNivedita_MyOrders'))
	
	WebUI.waitForPageLoad(15)
	
	//Click on First Order in My Orders Screen
	WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/OrderSummary_MyOrders'))
	
	Thread.sleep(2000)
	
	WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/PastOrders_Header_ViewNoItems'))
	
	WebUI.waitForPageLoad(15)
	
	WebUI.waitForElementPresent(findTestObject('BigBasket/OrderSummary/OrderDetails/OrderDetails_Btn_SHOP FROM THIS OREDR'), 15)
	WebUI.scrollToElement(findTestObject('BigBasket/OrderSummary/OrderDetails/OrderDetails_Btn_SHOP FROM THIS OREDR') , 15)
	WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/OrderDetails/OrderDetails_Btn_VIEW PAYMENT DETAILS'))	
	
	Thread.sleep(5000)
	String pdfText = CustomKeywords.'com.Lemoney.ReadFromPDFFile.ReadPDF'('file:///Users/nivedita/Downloads/MBO-71816640-260219.pdf')
	
	println(pdfText)
	println( "......................" + pdfText.contains("Order ID : 71816640 / Standard Delivery"))
	println(  "......................" + pdfText.contains('Orders under this transaction'))
	
	WebUI.closeBrowser()
	
	
	
	
	
	