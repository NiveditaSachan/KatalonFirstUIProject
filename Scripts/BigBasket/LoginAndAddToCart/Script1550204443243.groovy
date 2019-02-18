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

import com.kms.katalon.core.webui.driver.DriverFactory

import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.interactions.Mouse
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.bigbasket.com/')

WebUI.click(findTestObject('BigBasket/LoginBigBasket/Page_Online Grocery Shopping and On/a_Login'))

WebUI.setText(findTestObject('BigBasket/LoginBigBasket/Page_Online Grocery Shopping and On/input_OR_email'), 'nivedita.hbti@gmail.com')

WebUI.setEncryptedText(findTestObject('BigBasket/LoginBigBasket/Page_Online Grocery Shopping and On/input_Please enter valid email'), 
    'LqVTzjb8H0GS29zWb5N07g==')

WebUI.click(findTestObject('BigBasket/LoginBigBasket/Page_Online Grocery Shopping and On/button_LOGIN'))

Thread.sleep(10000)

WebUI.setText(findTestObject('BigBasket/AddToCart/Page_Online Grocery Shopping and On/input_Shop for Rs.or moreand g'), 
    'Daal')

WebUI.waitForElementClickable(findTestObject('BigBasket/AddToCart/Page_Online Grocery Shopping and On/SearchIcon'), 10)

WebUI.click(findTestObject('Object Repository/BigBasket/AddToCart/Page_Online Grocery Shopping and On/SearchIcon'))

WebUI.waitForPageLoad(10)

WebUI.scrollToElement(findTestObject('BigBasket/AddToCart/Page_Best Online Grocery Store in I/btn_ADD_item'), 10)

WebUI.waitForElementClickable(findTestObject('BigBasket/AddToCart/Page_Best Online Grocery Store in I/button_Add'), 10)
'This is ADD button in Key word search results to add product to basket'

//Thread.sleep(10000)

WebDriver driver = DriverFactory.getWebDriver()

WebElement ele=driver.findElement(By.xpath("(//button[@class='btn btn-add col-xs-9'][contains(text(),'Add')])[1]"))

// Actions class to perform an action on an element which is not clickable
/*
Actions myAction = new Actions(driver)
myAction.moveToElement(ele).click().build().perform()
Thread.sleep(3000)
myAction.moveToElement(ele).click().perform()

*/
// Using JavaScript Executer to clickon an element whichis not clickable
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].click()",ele);


Thread.sleep(10000)

WebUI.closeBrowser()

