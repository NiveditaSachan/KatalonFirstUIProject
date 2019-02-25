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
		
		//WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Online Grocery Shopping and On/SearchIcon'), 10)
		Thread.sleep(1000)
		
		WebUI.waitForPageLoad(15)
		
		WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/SearchIcon'))
		
		WebUI.waitForPageLoad(10)
		
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Best Online Grocery Store in I/btn_ADD_item'), 10)
		
		//WebElement ele = driver.findElement(By.xpath("(//button[@class='btn btn-add col-xs-9'][contains(text(),'Add')])[1]"))
		'This is ADD button in Key word search results to add product to basket'
		WebElement ele = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/Basket/ADD button'), 15).get(
		    1)
		
		println('ele.............' + ele)
		
		// Using JavaScript Executer to clickon an element whichis not clickable
		WebDriver driver = DriverFactory.getWebDriver()
		
		JavascriptExecutor jse = ((driver) as JavascriptExecutor)
		
		jse.executeScript('arguments[0].click()', ele)
		
		Thread.sleep(3000)
		
		WebElement bigBasketLogo = driver.findElement(By.xpath('//div[@id=\'st-trigger-effects\']/a[@title=\'Bigbasket\']'))
		
		jse.executeScript('arguments[0].click()', bigBasketLogo)
		
		WebUI.waitForPageLoad(15)
		
		WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'))
		
		WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/a_My Basket No Items'))
		
		WebUI.waitForPageLoad(15)
		
		WebUI.scrollToElement(findTestObject('BigBasket/Basket/CHECKOUT'), 15)
		
		//WebUI.click(findTestObject('BigBasket/Basket/CHECKOUT'))
		WebUiCommonHelper.findWebElement(findTestObject('BigBasket/Basket/CHECKOUT'), 15).click()
		
		WebUI.waitForPageLoad(15)
		
		WebUI.verifyElementPresent( findTestObject('BigBasket/Checkout/Checkout_DeliveryAddressIcon'), 15)
		
		WebUI.verifyElementPresent( findTestObject('Object Repository/BigBasket/Checkout/Checkout_DeliveryAddressHeading'), 15)
		
		WebUI.verifyElementPresent( findTestObject('Object Repository/BigBasket/Checkout/Checkout_DeliveryAddress'), 15)
		
		WebUI.verifyElementPresent( findTestObject('Object Repository/BigBasket/Checkout/Checkout_Button_Change'), 15)
		
		WebUI.verifyElementPresent( findTestObject('Object Repository/BigBasket/Checkout/Checkout_DeliveryOptionsHeading'), 0)

		WebUI.verifyElementPresent(findTestObject('Object Repository/BigBasket/Checkout/Checkout_DefaultDeliveryOptionHeading'), 0)

		WebUI.verifyElementPresent(findTestObject('BigBasket/Checkout/Checkout_ShipmentDeliveryCharge')  , 0)
		
		// Amount in Basket
		BasketValue= Integer.parseInt(	WebUI.getText( findTestObject('Object Repository/BigBasket/Checkout/Checkout_BasketValue') )) 
		
		println("BasketValue ... " +BasketValue)
		
				if(BasketValue<1000){
					
					WebUI.verifyElementPresent(findTestObject('Object Repository/BigBasket/Checkout/Checkout_DefaultDeliveryChargeRs30'), 15)
					
				}
				else{
					
					freeDelivery= WebUI.getText( findTestObject('Object Repository/BigBasket/Checkout/Checkout_defaultDeliveryChargeFREE'))
					assert freeDelivery.equals("FREE")
					
				}
				
		WebUI.waitForPageLoad(15)
			
		WebUI.click( findTestObject('BigBasket/Checkout/Checkout_DefaultDeliverySlotDropDown') )
		
		Thread.sleep(2000)		
		
		WebElement selectAnotherSlot= WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/Checkout/Checkout_DefaultDeliverySelectAnotherSlot') , 15).get(1)
		
		selectAnotherSlot.click()
		
		Thread.sleep(1000)
		
		DeliveryCharges= WebUI.getText(	findTestObject('Object Repository/BigBasket/Checkout/Checkout_OrderSummary_DeliveryCharge') ) 
		
		def DeliveryChargesApplied=0
		
		if(BasketValue>=1000){
			
			assert DeliveryCharges.equals("FREE")
		}
		else{
			
			DeliveryChargesApplied= Integer.parseInt(DeliveryCharges.replace("Rs ", "").trim())
		}
		
		println("DeliveryChargesApplied... " + DeliveryChargesApplied)
		
		SettleBBBalance=Integer.parseInt(WebUI.getText(findTestObject('Object Repository/BigBasket/Checkout/Checkout_OrderSummary_SettleBigBasketBalance') ).replace("Rs ", "").trim())
		
		println("SettleBBBalance.... " + SettleBBBalance)
		
		CalculatedTotalPayableAmount= BasketValue+ DeliveryChargesApplied+SettleBBBalance
		
		TotalPayableAmount= Integer.parseInt (WebUI.getText(findTestObject('Object Repository/BigBasket/Checkout/Checkout_OrderSummary_TotalAmountPayable') ))
		assert TotalPayableAmount==CalculatedTotalPayableAmount
		
		WebUI.closeBrowser()


