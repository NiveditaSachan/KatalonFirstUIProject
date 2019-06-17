import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
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

@SetUp(skipped=false)

def setUp()
{
			
	WebUI.openBrowser('')
	
	WebUI.navigateToUrl("http://13.235.96.224:5100/")
	
	WebUI.verifyElementPresent(findTestObject('Lemoney/Setup/Login/img_Lemoney_logo'), 10)
	
	WebUI.verifyElementPresent(findTestObject('Lemoney/Setup/Login/Title_Lemoney'), 10)
	
	WebUI.verifyElementPresent(findTestObject('Lemoney/Setup/Login/Title_Making Banking Useful'), 10)
	
	WebUI.verifyElementPresent(findTestObject('Lemoney/Setup/Login/div_Enter Username  Password'), 10)
	
	WebUI.setText(findTestObject('Lemoney/Setup/Login/input_EnterUserName'), "owner@lemoney.com")
	
	WebUI.setText(findTestObject('Lemoney/Setup/Login/input_EnterPassword'), "123456")
	
	WebUI.click(findTestObject('Lemoney/Setup/Login/button_Login'))	
		}


WebUI.waitForElementPresent( findTestObject('Lemoney/Setup/Logout/img_profileImage'), 10)

//WebUI.verifyElementPresent(findTestObject('Lemoney/Setup/InvoiceHeading/InvoicesHeading'), 10)
