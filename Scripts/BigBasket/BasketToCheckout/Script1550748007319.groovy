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


// not clicking on viewbasket and checkout button
WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'))

WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/a_My Basket No Items'))

WebUI.waitForPageLoad(15)

// Count no of items in basket
items = WebUI.getText(findTestObject('Object Repository/BigBasket/Basket_CheckingOut/Page_Best Online Grocery Store in I/Basket_CountNumberOfItemsinBasket'))

count = Integer.parseInt(items.trim())

println('Count is : ' + count)

SubTotal_Calculated = 0

for (i = 0; i < count; i++) {
    WebElement title_Product = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/Basket_CheckingOut/Page_Best Online Grocery Store in I/Basket_ItemsInBasket'), 
        15).get(i)

    println((('title_Product for product ' + i) + ' is : ') + title_Product.getText())

    WebElement unitPrice_Product = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/Basket_CheckingOut/Page_Best Online Grocery Store in I/Basket_UnitPriceperProductinBasket'), 
        15).get(i)

    println((('unitPrice_Product for product ' + i) + ' is : ') + unitPrice_Product.getAttribute('value'))

    WebElement quantity_Product = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/Basket_CheckingOut/Page_Best Online Grocery Store in I/Basket_QuantityPerProductInBasket'), 
        15).get(i)

    println((('quantity_Product for product ' + i) + ' is : ') + quantity_Product.getAttribute('value'))

    WebElement subTotal_Product = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/Basket_CheckingOut/Page_Best Online Grocery Store in I/Basket_SubtotalPerProductInBasket'), 
        15).get(i)

    println((('subTotal_Product for product ' + i) + ' is : ') + subTotal_Product.getText())

    SubTotal = Double.parseDouble(subTotal_Product.getText())
	
	assert SubTotal==Double.parseDouble(quantity_Product.getAttribute('value'))*Double.parseDouble(unitPrice_Product.getAttribute('value'))

    //Calculate the Subtotal which is some of subtotal per product
    SubTotal_Calculated = (SubTotal_Calculated + SubTotal)
}

println('calculated Subtotal is .....' + SubTotal_Calculated)

Subtotal= Double.parseDouble(WebUI.getText( findTestObject('Object Repository/BigBasket/Basket_CheckingOut/Page_Best Online Grocery Store in I/Basket_SubtotalFinal')).replace("Rs.", "").trim())

assert Subtotal==SubTotal_Calculated

WebUI.scrollToElement(findTestObject('BigBasket/Basket/CHECKOUT'), 15)

//WebUI.click(findTestObject('BigBasket/Basket/CHECKOUT'))
WebUiCommonHelper.findWebElement(findTestObject('BigBasket/Basket/CHECKOUT'), 15).click()

WebUI.closeBrowser()

/*
WebUI.verifyElementPresent(findTestObject('Page_Best Online Grocery Store in I/span_Default Address'), 10)

WebUI.verifyElementPresent(findTestObject('Page_Best Online Grocery Store in I/div_Default Address    Home - '), 10)

WebUI.verifyElementPresent(findTestObject('Page_Best Online Grocery Store in I/div_Default Delivery Option   '), 10)

WebUI.click(findTestObject('Object Repository/Page_Best Online Grocery Store in I/span_Note Selecting the slot m'))

WebUI.closeBrowser()
*/

