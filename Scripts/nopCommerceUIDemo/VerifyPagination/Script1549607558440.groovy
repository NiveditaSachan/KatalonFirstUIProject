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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By

WebUI.openBrowser('')

WebUI.navigateToUrl('http://demo.nopcommerce.com/camera-photo')

WebUI.verifyElementPresent(findTestObject('Object Repository/nopCommerce_OR/PaginationInCamera/Page_nopCommerce demo store. Camera/span_Sort by'), 
    10)

WebUI.verifyOptionSelectedByLabel(findTestObject('nopCommerce_OR/PaginationInCamera/Page_nopCommerce demo store. Camera/select_PositionName A to ZName'), 
    'Position', false, 60)

WebUI.selectOptionByLabel(findTestObject('Object Repository/nopCommerce_OR/PaginationInCamera/Page_nopCommerce demo store. Camera/select_PositionName A to ZName'), 
    'Price: Low to High', false)

WebUI.verifyElementPresent(findTestObject('Object Repository/nopCommerce_OR/PaginationInCamera/Page_nopCommerce demo store. Camera/span_Display'), 
    10)

WebUI.verifyOptionSelectedByLabel(findTestObject('nopCommerce_OR/PaginationInCamera/Page_nopCommerce demo store. Camera/select_369'), 
    '6', false, 10)

WebUI.selectOptionByLabel(findTestObject('nopCommerce_OR/PaginationInCamera/Page_nopCommerce demo store. Camera/select_369'), 
    '3', false)

i = 2

WebUI.verifyElementPresent(findTestObject('Object Repository/nopCommerce_OR/PaginationInCamera/Page_nopCommerce demo store. Camera/strong_Filter by price'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/nopCommerce_OR/PaginationInCamera/Page_nopCommerce demo store. Camera/a_Under 500.00'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/nopCommerce_OR/PaginationInCamera/Page_nopCommerce demo store. Camera/a_Over 500.00'), 
    0)

// Get all the Child of Grid
WebDriver driver = DriverFactory.getWebDriver()

eleCount = driver.findElements(By.xpath('//div[@class=\'item-grid\']/div'))

eleCount1 = driver.findElements(By.xpath('//div[@class=\'item-grid\']/child::div')).toArray()

for (i = 0; i < eleCount1.size(); i++) {
    println((('eleCount ... ' + i) + '..') + eleCount1[i].getText())
	if(eleCount1[i].getText().isEmpty()){
		Println("Text is missing for product number " + i+ "in the product grid")
		break;
	}
	
	btnAddtoCart= driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/*//div/input[@class='button-2 product-box-add-to-cart-button']"))
	println(btnAddtoCart.isDisplayed())
	
}

println('eleCount0 ... ' + eleCount1[0].getText())

println('eleCount1 ... ' + eleCount1[1].getText())

println('eleCount2 ... ' + eleCount1[2].getText())

//div/input[@class='button-2 product-box-add-to-cart-button']
btnAddtoCart= driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/*//div/input[@class='button-2 product-box-add-to-cart-button']"))
println(btnAddtoCart.isDisplayed())

// Get Text of first Child of grid without using webdriver method
abc = WebUI.getText(findTestObject('nopCommerce_OR/PaginationInCamera/Page_nopCommerce demo store. Camera/div_Nikon D5500 DSLR'))
println('abc ... ' + abc)


WebUI.closeBrowser()

