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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.util.List as List
import java.util.ArrayList as ArrayList

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
	
	orderNumber=WebUI.getText(findTestObject('Object Repository/BigBasket/OrderSummary/OrderDetails/OrderDetails_OrderNumber')).trim()
	
	println("orderNumber is "+ orderNumber)
	WebUI.scrollToElement(findTestObject('BigBasket/OrderSummary/OrderDetails/OrderDetails_Btn_SHOP FROM THIS OREDR') , 15)
	
		List<WebElement> NameofItemsInOrderDetail= WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/OrderSummary/OrderDetails/OrderDetails_Item_ItemName'), 15)
		List<WebElement> UnitPriceofItemsInOrderDetail= WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/OrderSummary/OrderDetails/OrderDetails_Item_UnitPrice'), 15)
		List<String> ItemName_OrderDetail= new ArrayList()
		List<String> UnitPrice_OrderDetail= new ArrayList()
		
		for(i=0;i<NameofItemsInOrderDetail.size();i++){
			
			ItemName_OrderDetail.add(NameofItemsInOrderDetail.get(i).getText().trim())
			UnitPrice_OrderDetail.add(UnitPriceofItemsInOrderDetail.get(i).getText().trim())			
		}
	
	println("Item name and Unit Price in Oredr details Page is  " + ItemName_OrderDetail + "         "+ UnitPrice_OrderDetail)
	
	WebUI.click (findTestObject('Object Repository/BigBasket/OrderSummary/Invoice/Btn_INVOICE LIST'))
	
	WebUI.click( findTestObject('Object Repository/BigBasket/OrderSummary/Invoice/DropDown_InvoiceList_OrderStatement'))
	
	println("Window 1: " + WebUI.getWindowTitle())
	
	Thread.sleep(3000)
	
	WebUI.switchToWindowUrl("https://www.bigbasket.com/order/$orderNumber/invoice/")
	
	println("Window 2: " + WebUI.getWindowTitle())
	
	List<WebElement> TableMetacolms= WebUiCommonHelper.findWebElements( findTestObject('Object Repository/BigBasket/OrderSummary/Invoice/OrderStatement_Tbl_IdentityMeta'), 15)
	List<String> Colomn1PerRow=new ArrayList()
	List<String> Colomn2PerRow=new ArrayList()
	
		for( i=0;i<TableMetacolms.size();i++){
			
			int j=i/2+1
			
			Colomn1PerRow.add( TableMetacolms.get(i).getText())
			Colomn2PerRow.add(TableMetacolms.get(i+1).getText())
			
			println("\n   Row "+ j +" is         " +TableMetacolms.get(i).getText() +" - "+ TableMetacolms.get(i+1).getText())
			
				i=i+1
			}
		
		for(i=0;i<Colomn2PerRow.size();i++){
			
			if(Colomn2PerRow.get(i).equals("MBO-71816640-260219"))
			{
				println ("Order no : MBO-71816640-260219 matched" )
				break;
			}
		}
		
		List<WebElement> NameofItems= WebUiCommonHelper.findWebElements( findTestObject('Object Repository/BigBasket/OrderSummary/Invoice/OrderStatement_Item_ItemName'), 15)
		List<WebElement> UnitCostofItems= WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/OrderSummary/Invoice/OrderStatement_Item_UnitPrice') , 15)
		List<WebElement> QuantityofItems= WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/OrderSummary/Invoice/OrderStatement_Item_Quantity'), 15)
		List<WebElement> PriceofItems= WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/OrderSummary/Invoice/OrderStatement_Item_Price') , 15)
		
		List<String> ItemName=new ArrayList()
		List<String> ItemUnitCost=new ArrayList()
		List<String> ItemQuantity=new ArrayList()
		List<String> ItemPrice=new ArrayList()
		
		for (i=0;i<PriceofItems.size();i++){
			ItemName.add(NameofItems.get(i).getText()) 
			ItemUnitCost.add(UnitCostofItems.get(i).getText())
			ItemQuantity.add(QuantityofItems.get(i).getText())
			ItemPrice.add(PriceofItems.get(i).getText())
		}
		println(PriceofItems.size())
				
		for(i=0;i<PriceofItems.size();i++){
						
			println("                 Name of Item is: " + ItemName.get(i))
		}
		println("                 Item is: " + ItemName)
		
		//This assertion is failing because in Invoice all the product names are with actual weight
		for(i=0;i<ItemName_OrderDetail.size();i++){
			assert (ItemName.get(i)).contains(ItemName_OrderDetail.get(i).replace("...", "").trim())
		}
						
WebUI.closeBrowser()


