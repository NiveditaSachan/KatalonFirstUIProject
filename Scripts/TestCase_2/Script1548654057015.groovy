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

WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/symfony/web/index.php/auth/login')

WebUI.setText(findTestObject('Page_OrangeHRM/input_LOGIN Panel_txtUsername'), findTestData('TestdataExcel').getValue(1, 
        1))

WebUI.setText(findTestObject('Page_OrangeHRM/input_Username_txtPassword'), findTestData('TestDataExcel').getValue(2, 1))

WebUI.click(findTestObject('Page_OrangeHRM/input_Password_Submit'))

if (!(WebUI.verifyElementPresent(findTestObject('Page_OrangeHRM/Page_OrangeHRM/img (1)'), 0))) {
    println('Invaid Credentials')

    WebUI.verifyElementPresent(findTestObject('Page_OrangeHRM/Page_OrangeHRM/img (1)'), 0)

    assert false
}

WebUI.verifyElementPresent(findTestObject('Page_OrangeHRM/Page_OrangeHRM/b_Dashboard'), 0)

WebUI.verifyElementPresent(findTestObject('Page_OrangeHRM/Page_OrangeHRM/h1_Dashboard'), 0)

WebUI.verifyElementVisible(findTestObject('Page_OrangeHRM/img'))

WebUI.waitForElementPresent(findTestObject('Page_OrangeHRM/Page_OrangeHRM/h1_Dashboard'), 10)

WebUI.closeBrowser()

