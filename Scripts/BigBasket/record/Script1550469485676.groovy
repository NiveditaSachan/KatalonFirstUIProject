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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.bigbasket.com/')

WebUI.click(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/a_Login'))

WebUI.doubleClick(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/div_LOGINSIGN UP OREmailPlease'))

WebUI.click(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/label_Email'))

WebUI.setText(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/input_OR_email'), 'nivedita.hbti@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/input_Please enter valid email'), 
    'LqVTzjb8H0GS29zWb5N07g==')

WebUI.click(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/button_LOGIN'))

WebUI.setText(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/input_Shop for Rs.or moreand g'), 
    'daal')

WebUI.click(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/i_Shop for Rs.or moreand get f'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/span_My Basket1 items'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/div_x'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/button_Add'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/p_You are viewing our product'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/div_x'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/button_Add'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/button_'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/button_'))

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.bigbasket.com/')

WebUI.click(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/a_Login'))

WebUI.click(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/label_Email'))

WebUI.setText(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/input_OR_email'), 'nivedita.hbti@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/input_Please enter valid email'), 
    'LqVTzjb8H0GS29zWb5N07g==')

WebUI.click(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/button_LOGIN'))

WebUI.click(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/div_x'))

WebUI.setText(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/input_Shop for Rs.or moreand g'), 
    'daal')

WebUI.sendKeys(findTestObject('Object Repository/BB/Page_Online Grocery Shopping and On/input_Shop for Rs.or moreand g'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/button_Add'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/a_Continue'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/button_Add_btn lt'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/button_Add'))

WebUI.click(findTestObject('Object Repository/BB/Page_Best Online Grocery Store in I/div_Successfully added Organic'))

WebUI.closeBrowser()

