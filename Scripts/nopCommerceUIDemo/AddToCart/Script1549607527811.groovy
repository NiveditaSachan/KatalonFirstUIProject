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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By

WebUI.openBrowser('')

ChromeOptions options = new ChromeOptions()

options.addArguments('disable-infobars')

WebDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl('http://demo.nopcommerce.com/camera-photo')

WebUI.click(findTestObject('Object Repository/nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Camera/input_From 630.00_button-2 pro'))

WebUI.click(findTestObject('Object Repository/nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Nikon/input_Qty_add-to-cart-button-1'))

WebUI.verifyElementPresent(findTestObject('nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Nikon/a_1 item(s)'), 10)

//(findTestObject('Object Repository/nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Nikon/a_1 item(s)'))
WebUI.verifyElementPresent(findTestObject('nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Shoppi/span_Shopping cart'), 
    10)

//WebUI.getText(findTestObject('Object Repository/nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Shoppi/span_Shopping cart'))
TestObject to = findTestObject('Object Repository/nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Shoppi/span_Shopping cart')

to.findProperty('xpath').setValue('//div[@id=\'bar-notification\']/p')

println(WebUI.getText(to))

to.findProperty('xpath').setValue('//div[@id=\'bar-notification\']/span')

WebUI.click(to)

WebUI.scrollToElement(findTestObject('nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Nikon/a_1 item(s)'), 10)

WebUI.waitForElementVisible(findTestObject('nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Nikon/a_1 item(s)'), 0)

WebUI.mouseOver(findTestObject('nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Nikon/a_1 item(s)'))

WebUI.verifyElementPresent(findTestObject('nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Nikon/a_1 item(s)'), 10)

WebUI.waitForElementVisible(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Nikon/btn_GoToCart'), 25)

WebUI.click(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Nikon/btn_GoToCart'))

WebUI.verifyElementPresent(findTestObject('Object Repository/nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Shoppi/img'), 
    10)

WebUI.verifyElementPresent(findTestObject('Object Repository/nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Shoppi/td_Nikon D5500 DSLR - Black'), 
    10)

WebUI.verifyElementPresent(findTestObject('Object Repository/nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Shoppi/td_Price'), 
    10)

WebUI.verifyElementPresent(findTestObject('Object Repository/nopCommerce_OR/AddToCart/Page_nopCommerce demo store. Shoppi/td_Total'), 
    10)

WebUI.click(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Shoppi/chk_IAgree'))

WebUI.click(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Shoppi/button_Checkout'))

WebUI.setText(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Login/txtBox_Email'), 'nivedita@gmail.com')

//WebUI.click(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Login/btn_Login'))
WebUI.setText(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Login/txtBox_Password'), '@qwerty1')

//WebUI.submit(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Login/LoginForm'))
WebUI.click(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Login/btn_LoginButton'))

quantity = WebUI.getText(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Shoppi/txtBox_Quantity'))

prodTotal = WebUI.getText(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Shoppi/td_Total'))

Subtotal = WebUI.getText(findTestObject('nopCommerce_OR/CheckOut/Page_nopCommerce demo store. Shoppi/span_Subtotal'))

TotalProductPrice = (Integer.parseInt(quantity) * Integer.parseInt(prodTotal))

WebUI.verifyEqual(Integer.parseInt(Subtotal), TotalProductPrice)

//WebUI.closeBrowser()
driver.close()

