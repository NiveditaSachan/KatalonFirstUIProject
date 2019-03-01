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

Thread.sleep(2000)

WebUI.click(findTestObject('BigBasket/OrderSummary/OrderDetails/OrderDetails_Btn_SHOP FROM THIS OREDR'))

WebUI.waitForPageLoad(15)

	WebUI.verifyElementPresent(findTestObject('Object Repository/BigBasket/OrderSummary/ShopFromThisOrder_OrderID_Header'), 
    15)

	WebDriver driver= DriverFactory.getWebDriver()
	
	FruitAndVegCheckboxesXpath= xpathOfItemInBasket+"/div[@class='sl-check']/label"
	FruitAndVegProdTitleXpath= xpathOfItemInBasket+ "/div[@qa='product_name']/span/a/span[2]"
	
	List<WebElement> FruitAndVegCheckboxes = driver.findElements(By.xpath(FruitAndVegCheckboxesXpath))

	List<WebElement> FruitAndVegProdTitles = driver.findElements(By.xpath(FruitAndVegProdTitleXpath))
	
	List<String> FruitAndVegProdTitle=new ArrayList()
	
		for(i=1;i<=3;i++)
		{
			println("/////////////////////////////////////////////////////////////////////////////")
			FruitAndVegCheckboxes.get(i).click()	
					
			FruitAndVegProdTitle.add(FruitAndVegProdTitles.get(i).getText())
			
			println("Product name which is checked is : " + FruitAndVegProdTitle.get(i-1))
		}
		
	
///////////////////////////////	IMP : DYNAMICALLY CHANGE XPATH
//	abc = WebUI.getText(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount', [("xpath"): "//div[@class='uiv2-loggedin-user-link']/span[contains(.,'Nivedita')]"]))
			
WebUI.click(findTestObject('BigBasket/OrderSummary/OrderDetails/OrderDetails_Btn_COPY TO LIST'))

WebUI.waitForPageLoad(15)

Thread.sleep(2000)

WebUI.click(findTestObject('BigBasket/OrderSummary/OrderDetails/OrderDetails_CopyToList_RadioBtn_AddToExistingShoppingList'))

WebUI.click(findTestObject('BigBasket/OrderSummary/OrderDetails/OrderDetails_CopyToList_AddTo ExistingShoppingList_ListName'))

// Select List Name as List 2
WebUI.click(findTestObject('BigBasket/OrderSummary/OrderDetails/OrderDetails_CopyToList_AddTo ExistingShoppingList_SelectListName'))

WebUI.click(findTestObject('BigBasket/OrderSummary/OrderDetails/OrderDetails_CopyToList_AddToExistingShoppingList_Btn_COPY'))

Thread.sleep(5000)

WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'))

WebUI.click(findTestObject('Object Repository/BigBasket/OrderSummary/UserNivedita_MyOrders'))

WebUI.waitForPageLoad(15)

WebUI.click(findTestObject('BigBasket/OrderSummary/MyOrders_SHOP FROM_ShoppingList'))

WebUI.waitForPageLoad(15)

WebUI.scrollToElement(findTestObject('BigBasket/OrderSummary/MyShoppingLists_ShopFromYourList_ListName'), 15)

WebUI.click(findTestObject('BigBasket/OrderSummary/MyShoppingLists_ShopFromYourList_ListName'))

List<WebElement> ProductNames=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/OrderSummary/List2_ProductName'), 15)

println("ProductNames.size() : " +ProductNames.size())

List<String> ProductName = new ArrayList()

//Product added in Shopping List2 Are
for(i=0;i<ProductNames.size();i++){
	println("ProductNames.get(i).getText() : "+ ProductNames.get(i).getText())
	ProductName.add(ProductNames.get(i).getText())
	println("Product: "+i+" in List of size "+ProductNames.size()+" is : " + ProductName.get(i) +"\n")
}

//Verifying that all Products added in the shopping list are there in list 2 
assert ProductName.containsAll(FruitAndVegProdTitle)

WebUI.closeBrowser()

