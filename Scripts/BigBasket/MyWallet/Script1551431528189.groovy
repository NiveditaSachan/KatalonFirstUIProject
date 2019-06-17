import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.xml.ws.wsaddressing.W3CEndpointReference.Address as Address
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.junit.After as After
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.interactions.Mouse as Mouse
import org.openqa.selenium.remote.server.DefaultDriverFactory
import org.stringtemplate.v4.compiler.STParser.element_return
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.util.List as List
import java.util.ArrayList as ArrayList

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
	
	WebUI.waitForElementPresent( findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/LeftMenu_My Wallet'), 15)
	
	WebUI.click( findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/LeftMenu_My Wallet'))
	
	String FromDate=WebUiCommonHelper.findWebElement(findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/WalletActivity/MyWallet_WalletActivity/input_From_datePicker'),15).getAttribute("value")
	
	println("FromDate is : " + FromDate)
	
	String ToDate=WebUiCommonHelper.findWebElement(findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/WalletActivity/MyWallet_WalletActivity/input_To_datePicker'), 15).getAttribute("value")
	
	println("ToDate is : " + ToDate)
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/WalletActivity/MyWallet_WalletActivity/input_From_datePicker'))
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/WalletActivity/MyWallet_WalletActivity/a_PickDate_Row1_Colomn6_Fri1st'))

	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/WalletActivity/MyWallet_WalletActivity/btn_SHOW ACTIVITY'))
		
	List<WebElement> HeaderRow=WebUiCommonHelper.findWebElements(findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/WalletActivity/MyWallet_WalletActivity/WalletActivity_RowHeader'), 15)
	
	if(HeaderRow.size()>0){
		
		List<WebElement> Row1Data=WebUiCommonHelper.findWebElements(findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/WalletActivity/MyWallet_WalletActivity/WalletActivity_Row1Data'), 15)
		
		NoOfRowColomns=Row1Data.size()
		
			for(i=0;i<NoOfRowColomns;i++){
				
				println("DATA UNDER COLOMN: "+HeaderRow.get(i).getText() +" IN ROW1 is : "  +Row1Data.get(i).getText())
			}
		
	}
	else{
		println("...........No wallet activity available for the period!")
		
	}
	
//	try{
//			
//		List<WebElement> HeaderRow=WebUiCommonHelper.findWebElements(findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/WalletActivity/MyWallet_WalletActivity/WalletActivity_RowHeader'), 15)
//		
//		List<WebElement> Row1Data=WebUiCommonHelper.findWebElements(findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/WalletActivity/MyWallet_WalletActivity/WalletActivity_Row1Data'), 15)
//		
//		NoOfRowColomns=Row1Data.size()
//		
//			for(i=0;i<NoOfRowColomns;i++){
//				
//				println("Data under colomn: "+HeaderRow.get(i).getText() +" in row1 is : "  +Row1Data.get(i).getText())
//			}
//		}
//	
//		catch(NoSuchElementException e)
//		{
//			this.println("....................................No wallet activity available for the period!")
//		}
//		
//		catch(Exception e)
//		{
//			this.println("Inside Catch")
//			this.println("....................................No wallet activity available for the period!")
//		}
//	
	WebUI.waitForElementPresent( findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/MyWallet_Btn_ FUND WALLET'), 15)
	
	WebUI.click( findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/MyWallet_Btn_ FUND WALLET'))
	
	WebUI.waitForElementPresent( findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/FundTheWallet_ChooseYourPaymentOptions'), 15)
	
	WebUI.sendKeys( findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/FundTheWallet_AmountToFund'), "100")
	
	WebUI.click( findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/FundThewallet_Btn_SUBMIT'))
	
	WebUI.waitForElementPresent( findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/PayUbiz_Net banking'), 15)
	
	WebUI.click (findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/PayUbiz_Net banking'))
	
	WebUI.click( findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/PayUbiz_NetBanking_SelectBankDropDown'))
	
	WebUI.click( findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/PayUbiz_NetBanking_ICICI'))
	
	WebUI.click(findTestObject('TestFolder/nopCommerce_OR/BigBasket/MyWallet/PayUbiz_NetBanking_Btn_PAY NOW') )
	
	Thread.sleep(4000)

WebUI.closeBrowser()



