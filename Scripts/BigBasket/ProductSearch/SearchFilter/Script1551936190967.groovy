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

WebUI.click(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/a_Login'))

WebUI.setText(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/input_OR_email'), 'nivedita.hbti@gmail.com')

WebUI.setEncryptedText(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/input_Please enter valid email'), 
    'LqVTzjb8H0GS29zWb5N07g==')

WebUI.click(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/button_LOGIN'))

WebUI.waitForElementClickable(findTestObject('TestFolder/test/Page_Online Grocery Shopping and On/Page_Online Grocery Shopping and On/span_UserAccount'),
	15)

WebUI.click( findTestObject('TestFolder/nopCommerce_OR/BigBasket/Search/OFFERS_TopMenu'))

WebUI.waitForElementPresent( findTestObject('TestFolder/nopCommerce_OR/BigBasket/Search/Filter/Filter_Price'), 15)

WebUI.click( findTestObject('TestFolder/nopCommerce_OR/BigBasket/Search/Filter/Filter_Price'))

List<WebElement> PriceOfProducts= WebUiCommonHelper.findWebElements(findTestObject('TestFolder/nopCommerce_OR/BigBasket/Search/Filter/ProductsPrice'), 15)
List<String> ProductPrice

println("PriceOfProducts.size() : " + PriceOfProducts.size())

	for(i=0;i<PriceOfProducts.size();i++)
		{
			ProductPrice.add(PriceOfProducts.get(i))			
		}
		
	for(i=0;i<10;i++){
		println("                  " + Integer.parseInt(ProductPrice.get(i)))
		}

		Thread.sleep(2000)



WebUI.closeBrowser()