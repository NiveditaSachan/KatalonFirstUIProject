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

WebUI.navigateToUrl('http://lemoney-dev-nlb2-bb7e2c16f0430ace.elb.ap-south-1.amazonaws.com:5100/')

WebUI.click(findTestObject('Page_React App/img_Lemoney_public__logo'))

WebUI.click(findTestObject('Page_React App/span_Lemoney'))

WebUI.click(findTestObject('Page_React App/div_Making Banking Useful'))

WebUI.click(findTestObject('Page_React App/div_Enter Username  Password'))

WebUI.setText(findTestObject('Page_React App/input_Enter Username  Password'), 'owner@lemoney.com')

WebUI.setEncryptedText(findTestObject('Page_React App/input_Enter Username  Password_1'), 'HeCM15nHKBI=')

WebUI.setEncryptedText(findTestObject('Page_React App/input_Enter Username  Password_2'), 'lnBUteI2ioQ=')

WebUI.setEncryptedText(findTestObject('Page_React App/input_Enter Username  Password_3'), 'tzH6RvlfSTg=')

WebUI.setEncryptedText(findTestObject('Page_React App/input_Enter Username  Password_4'), '4nvbrPglk7k=')

WebUI.setEncryptedText(findTestObject('Page_React App/input_Enter Username  Password_5'), 'iGDxf8hSRT4=')

WebUI.setEncryptedText(findTestObject('Page_React App/input_Enter Username  Password_6'), 'aeHFOx8jV/A=')

WebUI.setEncryptedText(findTestObject('Page_React App/input_Enter Username  Password_7'), 'aeHFOx8jV/A=')

WebUI.click(findTestObject('Page_React App/button_Login'))

WebUI.click(findTestObject('Page_Dashboard/span_Invoices'))

WebUI.closeBrowser()

