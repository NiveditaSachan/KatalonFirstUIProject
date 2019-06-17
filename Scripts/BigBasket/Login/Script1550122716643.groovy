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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.bigbasket.com/')

WebUI.click(findTestObject('TestFolder/test/search/Page_Online Grocery Shopping and On/li'))

WebUI.click(findTestObject('TestFolder/test/search/Page_Online Grocery Shopping and On/a_Login'))

WebUI.click(findTestObject('TestFolder/test/search/Page_Online Grocery Shopping and On/label_Email'))

WebUI.setText(findTestObject('TestFolder/test/search/Page_Online Grocery Shopping and On/input_OR_email'), 'nivedita.hbti@gmail.com')

WebUI.setEncryptedText(findTestObject('TestFolder/test/search/Page_Online Grocery Shopping and On/input_Please enter valid email'), 
    'LqVTzjb8H0GS29zWb5N07g==')

WebUI.click(findTestObject('TestFolder/test/search/Page_Online Grocery Shopping and On/button_LOGIN'))

WebUI.setText(findTestObject('TestFolder/test/search/Page_Online Grocery Shopping and On/input_Shop for Rs.or moreand g'), 
    'daal')

WebUI.click(findTestObject('TestFolder/test/search/Page_Online Grocery Shopping and On/i_Shop for Rs.or moreand get f'))

WebUI.click(findTestObject('TestFolder/test/search/Page_Best Online Grocery Store in I/i_Add_fa fa-minus'))

WebUI.click(findTestObject('TestFolder/test/search/Page_Best Online Grocery Store in I/button_Add'))

WebUI.closeBrowser()

